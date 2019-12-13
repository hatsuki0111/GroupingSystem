package com.grouping.grouping_system.page;

import com.grouping.grouping_system.SigningSession;
import com.grouping.grouping_system.bean.Account;
import com.grouping.grouping_system.bean.Enquete;
import com.grouping.grouping_system.service.ICreateEnqueteService;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.extensions.markup.html.form.datetime.LocalDateTimeField;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.LambdaModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

import java.util.ArrayList;
import java.util.stream.Collectors;


/**
 * アンケート作成ページ
 */
@MountPath("CreateEnquete")
public class CreateEnquetePage extends TemplatePage {

    @SpringBean
    private ICreateEnqueteService createEnqueteService;

    public CreateEnquetePage() {
        var accountList = createEnqueteService.getAccountList().stream()
                .map(Account::getName)
                .collect(Collectors.toList());
        var enqueteModel = new Model<>(new Enquete());
        var selectedAccountModel = Model.ofList(new ArrayList<String>());

        var enqueteForm = new Form<>("enqueteForm");
        add(enqueteForm);

        enqueteForm.add(new TextField<>("enqueteTitle", LambdaModel.of(enqueteModel, Enquete::getTitle, Enquete::setTitle)));

        var respondentCheckBox = new CheckBoxMultipleChoice<>("respondentCheckBox",
                selectedAccountModel,
                accountList,
                new ChoiceRenderer<>());

        respondentCheckBox
                .setPrefix("<li>")
                .setSuffix("</li>");

        enqueteForm.add(respondentCheckBox);

        enqueteForm.add(new Link<>("selectAllLink") {
            @Override
            public void onClick() {
                selectedAccountModel.setObject(accountList);
            }
        });

        enqueteForm.add(new Link<>("deselectAllLink") {
            @Override
            public void onClick() {
                selectedAccountModel.setObject(new ArrayList<>());
            }
        });

        enqueteForm.add(new LocalDateTimeField("startDate", LambdaModel.of(enqueteModel, Enquete::getStartDateTime, Enquete::setStartDateTime)));
        enqueteForm.add(new LocalDateTimeField("endDate", LambdaModel.of(enqueteModel, Enquete::getEndDateTime, Enquete::setEndDateTime)));

        var groupNameListModel = Model.ofList(new ArrayList<String>());

//        var addGroupForm = new Form("addGroupForm");
//        add(addGroupForm);

        var addedGroupNameModel = Model.of("");
        var groupNameField = new TextField<>("groupNameField", addedGroupNameModel);
        enqueteForm.add(groupNameField);

        var webMarkupContainer = new WebMarkupContainer("addedGroupWMC");
        webMarkupContainer.setOutputMarkupId(true);
//        add(webMarkupContainer);
        enqueteForm.add(webMarkupContainer);

        var addedGroupListView = new ListView<>("addedGroupListView", groupNameListModel) {
            @Override
            protected void populateItem(ListItem<String> listItem) {
                Form form = new Form("addedGroupForm");
                listItem.add(form);

                form.add(new Label("groupNameLabel", listItem.getModelObject()));
                // 削除ボタン
                AjaxButton ajaxButton = new AjaxButton("deleteGroupButton") {
                    @Override
                    protected void onSubmit(AjaxRequestTarget target) {
                        super.onSubmit(target);
                        groupNameListModel.getObject().remove(listItem.getModelObject());
                        target.add(webMarkupContainer);
                    }
                };
                ajaxButton.setLabel(Model.of("削除"));
                form.add(ajaxButton);
            }
        };
        addedGroupListView.setOutputMarkupId(true);
        webMarkupContainer.add(addedGroupListView);

        // 追加ボタン
        var addGroupButton = new AjaxButton("addGroupButton") {
            @Override
            protected void onSubmit(AjaxRequestTarget target) {
                super.onSubmit(target);
                groupNameListModel.getObject().add(addedGroupNameModel.getObject());
                target.add(webMarkupContainer);
            }
        };
//        addGroupForm.add(addGroupButton);
        enqueteForm.add(addGroupButton);

        // 送信ボタン
        enqueteForm.add(new Button("submitButton") {
            @Override
            public void onSubmit() {
                super.onSubmit();
                enqueteModel.getObject().setAuthorAccountName(SigningSession.get().getAccountName());
                createEnqueteService.registerEnquete(enqueteModel.getObject(), groupNameListModel.getObject(), selectedAccountModel.getObject());
                setResponsePage(EnqueteRegistrationCompletionPage.class);
            }
        });
//        add(new Link<>("toTopPage") {
//            @Override
//            public void onClick() {
//                setResponsePage(TopPage.class);
//            }
//        });
    }
}