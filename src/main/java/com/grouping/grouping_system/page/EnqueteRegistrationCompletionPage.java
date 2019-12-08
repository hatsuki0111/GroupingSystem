package com.grouping.grouping_system.page;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

public class EnqueteRegistrationCompletionPage extends TemplatePage{
    public EnqueteRegistrationCompletionPage(){
        add(new Link<>("toTopPage") {
            @Override
            public void onClick() {
                setResponsePage(TopPage.class);
            }
        });
    }
}
