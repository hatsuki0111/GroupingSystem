package com.grouping.grouping_system.page;

import com.grouping.grouping_system.bean.Enquete;
import com.grouping.grouping_system.bean.Option;
import com.grouping.grouping_system.service.AnswerEnqueteService;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AnswerEnquetePage extends TemplatePage {

    @SpringBean
    private AnswerEnqueteService answerEnqueteService;

    public AnswerEnquetePage(IModel<Enquete> enqueteModel) {
        var enquete = enqueteModel.getObject();
        add(new Label("titleNameLabel", enquete.getTitle()));
        add(new Label("startTimeLabel", enquete.getStartDateTime()));
        add(new Label("endTimeLabel", enquete.getEndDateTime()));

        add(new MenuBarPanel("menuBar"));

        var optionListModel = Model.ofList(answerEnqueteService.getOptionListBy(enquete.getId()));

        var selectedOptionModel = Model.of("");
        var optionList = optionListModel.getObject().stream()
                .map(Option::getLabel)
                .collect(Collectors.toList());

        var radioChoice = new RadioChoice<>("radioButton", selectedOptionModel, optionList);

        radioChoice
                .setPrefix("<p>")
                .setSuffix("</p>");

        var nantokaForm = new Form("nantokaForm");
        add(nantokaForm);

        nantokaForm.add(radioChoice);

        nantokaForm.add(new Button("nantokaButton") {
            @Override
            public void onSubmit() {
                super.onSubmit();
                answerEnqueteService.registerSelectedOption(enquete.getId(), selectedOptionModel.getObject());
            }
        });
    }
}
