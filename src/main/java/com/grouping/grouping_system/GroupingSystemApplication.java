package com.grouping.grouping_system;

import com.giffing.wicket.spring.boot.starter.app.WicketBootSecuredWebApplication;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GroupingSystemApplication extends WicketBootSecuredWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(GroupingSystemApplication.class, args);
    }

    @Override
    protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
        return SigningSession.class;
    }
}
