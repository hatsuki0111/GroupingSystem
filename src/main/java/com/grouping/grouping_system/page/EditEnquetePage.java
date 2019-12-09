package com.grouping.grouping_system.page;

import com.grouping.grouping_system.bean.Account;
import com.grouping.grouping_system.bean.Enquete;
import com.grouping.grouping_system.bean.Option;
import com.grouping.grouping_system.bean.Respondent;
import com.grouping.grouping_system.service.IEditEnqueteService;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.extensions.markup.html.form.datetime.LocalDateTimeField;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.CheckBoxMultipleChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LambdaModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.stream.Collectors;

public class EditEnquetePage extends TemplatePage {

    @SpringBean
    private IEditEnqueteService editEnqueteService;


    public EditEnquetePage(IModel<Enquete> enqueteModel) {
        var selectedAccountNameListModel = Model.ofList(editEnqueteService.getRespondentList(enqueteModel.getObject())
                .stream()
                .map(Respondent::getAccountName)
                .collect(Collectors.toList()));
        var groupNameListModel = Model.ofList(editEnqueteService.getOptionList(enqueteModel.getObject())
                .stream()
                .map(Option::getLabel)
                .collect(Collectors.toList()));
        var accountList = editEnqueteService.getAccountList().stream().map(Account::getName).collect(Collectors.toList());
        var groupNameModel = Model.of("");


        add(new MenuBarPanel("menuBar"));

        var addedGroupWMC = new WebMarkupContainer("addedGroupWMC") {
            @Override
            protected void onInitialize() {
                super.onInitialize();
                setOutputMarkupId(true);
            }
        };

        addedGroupWMC
                .add(new ListView<>("addedGroupNameListView", groupNameListModel) {
                    @Override
                    protected void populateItem(ListItem<String> listItem) {
                        var addedGroupForm = new Form<>("addedGroupForm");
                        addedGroupForm.add(new Label("groupNameLabel", listItem.getModelObject()));
                        addedGroupForm.add(new AjaxButton("deleteGroupButton") {
                            @Override
                            protected void onInitialize() {
                                super.onInitialize();
                                setLabel(Model.of("削除"));
                            }

                            @Override
                            protected void onSubmit(AjaxRequestTarget target) {
                                super.onSubmit(target);
                                groupNameListModel.getObject().remove(listItem.getModelObject());
                                target.add(addedGroupWMC);
                            }
                        });
                        listItem.add(addedGroupForm);
                    }
                });

        var enqueteForm = new Form<>("enqueteForm");
        add(enqueteForm);

        enqueteForm
                .add(new TextField<>("titleField", LambdaModel.of(enqueteModel, Enquete::getTitle, Enquete::setTitle)))
                .add(new Label("authAccountNameLabel", enqueteModel.getObject().getAuthorAccountName()))
                .add(new LocalDateTimeField("startDateTimeField", LambdaModel.of(enqueteModel, Enquete::getStartDateTime, Enquete::setEndDateTime)))
                .add(new LocalDateTimeField("endDateTimeField", LambdaModel.of(enqueteModel, Enquete::getEndDateTime, Enquete::setEndDateTime)))
                .add(new CheckBoxMultipleChoice<>("respondentCheckBox", selectedAccountNameListModel, accountList))
                .add(new TextField<>("groupNameField", groupNameModel))
                .add(addedGroupWMC)
                .add(new AjaxButton("addGroupButton") {
                    @Override
                    protected void onSubmit(AjaxRequestTarget target) {
                        super.onSubmit(target);
                        groupNameListModel.getObject().add(groupNameModel.getObject());
                        target.add(addedGroupWMC);
                    }
                })
                .add(new Button("submitButton") {
                    @Override
                    public void onSubmit() {
                        super.onSubmit();
                        editEnqueteService.editEnquete(enqueteModel.getObject(),selectedAccountNameListModel.getObject(),groupNameListModel.getObject());
                        setResponsePage(EnqueteRegistrationCompletionPage.class);
                    }
                });
    }
}