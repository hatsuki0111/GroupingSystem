package com.grouping.grouping_system.page;

import org.apache.wicket.markup.html.link.Link;

public class SignOutCompletionPage extends TemplatePage {
    public SignOutCompletionPage(){
        add(new Link<>("toSignInPage") {
            @Override
            public void onClick() {
                setResponsePage(SignInPage.class);
            }
        });
    }
}