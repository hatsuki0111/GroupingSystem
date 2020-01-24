package com.grouping.grouping_system.service;

import com.grouping.grouping_system.SigningSession;
import com.grouping.grouping_system.bean.evaluation.view.EvaluationGradeView;
import com.grouping.grouping_system.repository.IEvaluationGradeRepository;
import com.grouping.grouping_system.repository.IEvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Service
public class ViewEvaluationResultService implements IViewEvaluationResultService {

    @Autowired
    private IEvaluationRepository evaluationRepository;

    @Autowired
    private IEvaluationGradeRepository evaluationGradeRepository;

    @Override
    public List<List<EvaluationGradeView>> getEvaluationGrade(long enqueteId) {
        var evaluatorNameList = evaluationRepository.findEvaluatorList(enqueteId, SigningSession.get().getAccountName());
        var evaluationGradeList = new ArrayList<List<EvaluationGradeView>>();
        for (var evaluatorName : evaluatorNameList) {
            var egl = evaluationGradeRepository.find(enqueteId, evaluatorName, SigningSession.get().getAccountName());
            evaluationGradeList.add(egl);
        }
        return evaluationGradeList;
    }
}
