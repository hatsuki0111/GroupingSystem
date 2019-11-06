package com.grouping.grouping_system.page;

import com.grouping.grouping_system.bean.Account;
import com.grouping.grouping_system.service.IEnqueteTargetService;
import org.apache.wicket.markup.html.form.*;
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
    }
}
