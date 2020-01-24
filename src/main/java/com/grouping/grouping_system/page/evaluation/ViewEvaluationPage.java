package com.grouping.grouping_system.page.evaluation;

import com.grouping.grouping_system.bean.Enquete;
import com.grouping.grouping_system.bean.evaluation.view.EvaluationGradeView;
import com.grouping.grouping_system.page.TemplatePage;
import com.grouping.grouping_system.service.IViewEvaluationResultService;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

import java.util.List;

/**
 * 評価閲覧ページ
 *
 * @author ChocoSotan
 */
@MountPath("ViewEvaluation")
public class ViewEvaluationPage extends TemplatePage {

    @SpringBean
    private IViewEvaluationResultService viewEvaluationResultService;

    public ViewEvaluationPage(IModel<Enquete> enqueteModel) {
        setDefaultModel(CompoundPropertyModel.of(enqueteModel));
        var gradeListModel = Model.ofList(viewEvaluationResultService.getEvaluationGrade(enqueteModel.getObject().getId()));

        add(new Label("title"));
        add(new Label("authorAccountName"));
        add(new ListView<>("evaluatorList", gradeListModel) {
            @Override
            protected void populateItem(ListItem<List<EvaluationGradeView>> listItem) {
                listItem.add(new ListView<>("gradeList", listItem.getModel()) {
                    @Override
                    protected void populateItem(ListItem<EvaluationGradeView> listItem) {
                        listItem.add(new Label("name", listItem.getModelObject().getName()));
                        listItem.add(new Label("grade", listItem.getModelObject().getGrade()));
                    }
                });
            }
        });
    }
}
