package com.grouping.grouping_system;

import com.giffing.wicket.spring.boot.starter.app.WicketBootSecuredWebApplication;
import com.grouping.grouping_system.page.SignInPage;
import com.grouping.grouping_system.page.TopPage;
import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = GroupingSystemApplication.class
)
@RunWith(SpringRunner.class)
public class SignInTest {
    private WicketTester wicketTester;

    @Autowired
    private WicketBootSecuredWebApplication webApplication;

    @Autowired
    private ApplicationContext applicationContext;

    @Before
    public void setUp() {
        ReflectionTestUtils.setField(webApplication, "applicationContext", applicationContext);
        wicketTester = new WicketTester(webApplication);
        wicketTester.startPage(SignInPage.class);
    }

    @Test
    public void SignInPageが正常にレンダリングされる(){
        wicketTester.assertRenderedPage(SignInPage.class);
        wicketTester.assertNoErrorMessage();
    }

    @Test
    public void 正常にDBに接続できるかどうか(){

    }

    @Test
    public void ACCOUNTテーブルにテスト用アカウントがあるか() {
        var formTester = wicketTester.newFormTester("signInForm");
        formTester
                .setValue("accountNameTextField", "admin")
                .setValue("passwordTextField", "admin")
                .submit("signInButton");
        wicketTester.assertNoErrorMessage();
        wicketTester.assertRenderedPage(TopPage.class);
    }
}
