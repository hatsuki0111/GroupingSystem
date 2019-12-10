package com.grouping.grouping_system.page;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import com.grouping.grouping_system.service.ISignService;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.wicketstuff.annotation.mount.MountPath;

@WicketHomePage
@MountPath("SignIn")
public class SignInPage extends WebPage {

    @SpringBean
    private ISignService signService;

    public SignInPage(){
        add(new FooterPanel("footer"));
        var signInForm = new Form("signInForm");
        add(signInForm);

        var accountNameModel = Model.of("");
        signInForm.add(new TextField<String>("accountNameTextField",accountNameModel));

        var passwordModel = Model.of("");
        signInForm.add(new PasswordTextField("passwordTextField",passwordModel));

        signInForm.add(new Button("signInButton"){
            @Override
            public void onSubmit() {
                super.onSubmit();
                if (signService.signIn(accountNameModel.getObject(),passwordModel.getObject())){
                    setResponsePage(TopPage.class);
                    //ToDo feedbackPanelの追加
                }
            }
        });
    }
}
