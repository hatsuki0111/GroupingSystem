package com.grouping.grouping_system.page.evaluation;

import com.grouping.grouping_system.bean.evaluation.Evaluation;
import com.grouping.grouping_system.bean.evaluation.EvaluationGrade;
import com.grouping.grouping_system.page.TemplatePage;
import com.grouping.grouping_system.page.TopPage;
import com.grouping.grouping_system.service.IEvaluateService;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

import java.util.Arrays;

@MountPath("Evaluate")
public class EvaluatePage extends TemplatePage {

    @SpringBean
    private IEvaluateService evaluateService;

    public EvaluatePage(long enqueteId) {
        var evaluationListModel = Model.ofList(evaluateService.getEvaluationList(enqueteId));

        add(new Label("title"));
        add(new Label("author"));

        var form = new Form<>("form");
        add(form);

        form.add(new ListView<>("evaluateeList", evaluationListModel) {
            @Override
            protected void populateItem(ListItem<Evaluation> listItem) {
                listItem.add(new Label("evaluateeName", listItem.getModelObject().getEvaluateeName()));
                listItem.add(new ListView<>("evaluationList", listItem.getModelObject().getEvaluationGradeList()) {
                    @Override
                    protected void populateItem(ListItem<EvaluationGrade> listItem) {
                        listItem.add(new Label("name", listItem.getModelObject().getName()));
                        listItem.add(new DropDownChoice<>("grade", Model.of(3), Arrays.asList(1, 2, 3, 4, 5)));
                    }
                });
            }
        });
        form.add(new Button("submitButton") {
            @Override
            public void onSubmit() {
                super.onSubmit();
                evaluateService.register(evaluationListModel.getObject());
                setResponsePage(new TopPage());
            }
        });
    }
}
