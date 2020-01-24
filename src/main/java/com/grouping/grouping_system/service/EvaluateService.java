package com.grouping.grouping_system.service;

import com.grouping.grouping_system.SigningSession;
import com.grouping.grouping_system.bean.evaluation.Evaluation;
import com.grouping.grouping_system.bean.evaluation.EvaluationGrade;
import com.grouping.grouping_system.repository.IEvaluationGradeRepository;
import com.grouping.grouping_system.repository.IEvaluationItemRepository;
import com.grouping.grouping_system.repository.IEvaluationRepository;
import com.grouping.grouping_system.repository.IRespondentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EvaluateService implements IEvaluateService {
    @Autowired
    private IEvaluationRepository evaluationRepository;

    @Autowired
    private IEvaluationGradeRepository evaluationGradeRepository;

    @Autowired
    private IEvaluationItemRepository evaluationItemRepository;

    @Autowired
    private IRespondentRepository respondentRepository;


    @Override
    public List<Evaluation> getEvaluationList(long enqueteId) {
        // 自分以外にenqueteIdに関連するアンケートに回答したアカウント
        var respondents = respondentRepository.findBy(enqueteId).stream()
                .filter(r -> !r.getAccountName().equals(SigningSession.get().getAccountName()))
                .collect(Collectors.toList());

        // 自分以外の対象者ごと
        var evaluationList = new ArrayList<Evaluation>();
        for (var respondent : respondents) {

            var evaluationGradeList = new ArrayList<EvaluationGrade>();
            // 各評価項目ごと
            for (var evaluationItem : evaluationItemRepository.find(enqueteId)) {
                evaluationGradeList.add(new EvaluationGrade(evaluationItem.getId(), evaluationItem.getName(), 3));
            }

            evaluationList.add(new Evaluation(enqueteId, SigningSession.get().getAccountName(), respondent.getAccountName(), evaluationGradeList));
        }
        return evaluationList;
    }

    @Override
    @Transactional
    public void register(List<Evaluation> evaluationList) {
        for (var evaluation : evaluationList) {
            var evaluationId = evaluationRepository.insert(evaluation.getEnqueteId(), evaluation.getEvaluatorName(), evaluation.getEvaluateeName());
            for (var evaluationGrade : evaluation.getEvaluationGradeList()) {
                evaluationGradeRepository.insert(evaluationId, evaluationGrade.getEvaluationItemId(), evaluationGrade.getGrade());
            }
        }
    }
}
