package com.grouping.grouping_system;

import com.giffing.wicket.spring.boot.starter.app.WicketBootSecuredWebApplication;
import com.grouping.grouping_system.page.CreateEnquetePage;
import com.grouping.grouping_system.page.EnqueteRegistrationCompletionPage;
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
public class CreateEnqueteTest {
    private WicketTester wicketTester;

    @Autowired
    private WicketBootSecuredWebApplication webApplication;

    @Autowired
    private ApplicationContext applicationContext;

    @Before
    public void setUp() {
        ReflectionTestUtils.setField(webApplication, "applicationContext", applicationContext);
        wicketTester = new WicketTester(webApplication);
        wicketTester.startPage(CreateEnquetePage.class);
    }

    @Test
    public void アンケートを作成する() {
//        wicketTester.clickLink("selectAllLink", true);
//
//        wicketTester.newFormTester("enqueteForm")
//                .setValue("enqueteTitle", "enqueteTest-Title")
//                .setValue("startDate", "20000101")
//                .setValue("endDate", "20010101")
//                .setValue("groupNameField", "enqueteFormTest-Group1")
//                .submit("addGroupButton")
//                .setValue("groupNameField", "enqueteFormTest-Group2")
//                .submit("addGroupButton")
//                .setValue("groupNameField", "enqueteFormTest-Group3")
//                .submit("addGroupButton")
//                .submit("submitButton");
//
//        wicketTester.assertRenderedPage(EnqueteRegistrationCompletionPage.class);
    }
}
