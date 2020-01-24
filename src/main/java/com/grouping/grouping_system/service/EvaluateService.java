package com.grouping.grouping_system.service;

import com.grouping.grouping_system.SigningSession;
import com.grouping.grouping_system.bean.evaluation.EvaluationGrade;
import com.grouping.grouping_system.repository.IEvaluationGradeRepository;
import com.grouping.grouping_system.repository.IEvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EvaluateService implements IEvaluateService {

    @Autowired
    private IEvaluationRepository evaluationRepository;

    @Autowired
    private IEvaluationGradeRepository evaluationGradeRepository;

    @Override
    public List<List<EvaluationGrade>> getEvaluationGrade(long enqueteId) {
        var evaluatorNameList = evaluationRepository.findEvaluatorList(enqueteId);
        var evaluationGradeList = new ArrayList<List<EvaluationGrade>>();
        for (var evaluatorName : evaluatorNameList) {
            var egl = evaluationGradeRepository.find(enqueteId, evaluatorName, SigningSession.get().getAccountName());
            evaluationGradeList.add(egl);
        }
        return evaluationGradeList;
    }
}
