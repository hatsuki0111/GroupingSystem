package com.grouping.grouping_system;

import com.giffing.wicket.spring.boot.starter.app.WicketBootSecuredWebApplication;
import com.grouping.grouping_system.page.SignInPage;
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
public class GroupingSystemApplicationTests {
    private WicketTester wicketTester;

    @Autowired
    private WicketBootSecuredWebApplication webApplication;

    @Autowired
    private ApplicationContext applicationContext;
}
