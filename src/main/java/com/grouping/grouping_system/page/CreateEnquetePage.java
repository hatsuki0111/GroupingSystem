package com.grouping.grouping_system.page;

import com.grouping.grouping_system.bean.Account;
import com.grouping.grouping_system.service.IEnqueteTargetService;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.ArrayList;

/**
 * アンケート作成ページ
 */
public class CreateEnquetePage extends TemplatePage {
    @SpringBean
    private IEnqueteTargetService enqueteTargetService;

    public CreateEnquetePage() {
        var accountList = enqueteTargetService.nantoka();
        var enqueteTitleModel = Model.of("");

        var enqueteForm = new Form<>("enqueteForm");
        add(enqueteForm);
        enqueteForm.add(new TextField<>("enqueteTitle", enqueteTitleModel));

        var selectedAccountModel = Model.ofList(new ArrayList<Account>());
        // 対象者のList
        enqueteForm.add(new CheckBoxMultipleChoice<>("respondentCheckBox",
                selectedAccountModel,
                accountList,
                new ChoiceRenderer<>("name")));

        // 送信ボタン
        enqueteForm.add(new Button("submitButton") {
            @Override
            public void onSubmit() {
                super.onSubmit();
                setResponsePage(EnqueteRegistrationCompletionPage.class);
            }
        });

        var groupNameList = new ArrayList<String>();
        var groupNameListModel = Model.ofList(groupNameList);

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
                var groupName = listItem.getModelObject();
                var label = new Label("groupNameLabel", groupName);
                listItem.add(label);
            }
        };
        addedGroupListView.setOutputMarkupId(true);
        webMarkupContainer.add(addedGroupListView);

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
