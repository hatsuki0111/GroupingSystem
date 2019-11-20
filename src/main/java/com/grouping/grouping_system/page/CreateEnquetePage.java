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
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.time.LocalDateTime;
import java.util.ArrayList;


/**
 * アンケート作成ページ
 */
public class CreateEnquetePage extends TemplatePage {
    @SpringBean
    private ICreateEnqueteService createEnqueteService;

    public CreateEnquetePage() {
        var accountList = createEnqueteService.getAccountList();
//        var enqueteModel = new Model<>(new Enquete());
        var enqueteTitleModel = Model.of("");

        var enqueteForm = new Form<>("enqueteForm");
        add(enqueteForm);
        enqueteForm.add(new TextField<>("enqueteTitle", enqueteTitleModel));
//        enqueteForm.add(new TextField<>("", LambdaModel.of(enqueteModel,Enquete::getTitle,Enquete::setTitle)));

        var selectedAccountModel = Model.ofList(new ArrayList<Account>());
        // 対象者のList
        enqueteForm.add(new CheckBoxMultipleChoice<>("respondentCheckBox",
                selectedAccountModel,
                accountList,
                new ChoiceRenderer<>("name")));


        var startDateTime = Model.of(LocalDateTime.now());
        enqueteForm.add(new LocalDateTimeField("startDate", startDateTime));

        var endDateTime = Model.of(LocalDateTime.now());
        enqueteForm.add(new LocalDateTimeField("endDate", endDateTime));

        // 送信ボタン
        enqueteForm.add(new Button("submitButton") {
            @Override
            public void onSubmit() {
                super.onSubmit();
                var enquete = new Enquete();
                enquete.setTitle(enqueteTitleModel.getObject());
//                enquete.setAuthorAccountName(SigningSession.get().getUserName());
                enquete.setAuthorAccountName("admin");
                enquete.setStartDateTime(startDateTime.getObject());
                enquete.setEndDateTime(endDateTime.getObject());
                // TODO: DBに追加
                createEnqueteService.registerEnquete(enquete);
                setResponsePage(EnqueteRegistrationCompletionPage.class);
            }
        });

        var groupNameListModel = Model.ofList(new ArrayList<String>());

        var addGroupForm = new Form("addGroupForm");
        add(addGroupForm);

        var addedGroupNameModel = Model.of("");
        var groupNameField = new TextField<>("groupNameField", addedGroupNameModel);
        addGroupForm.add(groupNameField);

        var webMarkupContainer = new WebMarkupContainer("addedGroupWMC");
        webMarkupContainer.setOutputMarkupId(true);
        add(webMarkupContainer);

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
        addGroupForm.add(addGroupButton);

    }
}
