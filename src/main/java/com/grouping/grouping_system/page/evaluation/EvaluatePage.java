package com.grouping.grouping_system.page.evaluation;

import com.grouping.grouping_system.page.TemplatePage;
import com.grouping.grouping_system.service.IEvaluateService;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

@MountPath("Evaluation")
public class EvaluatePage extends TemplatePage {
    @SpringBean
    private IEvaluateService evaluateService;

    public EvaluatePage(long enqueteId) {

    }
}
