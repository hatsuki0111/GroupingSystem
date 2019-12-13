package com.grouping.grouping_system.page;

import org.apache.wicket.markup.html.link.Link;

public class AnswerEnqueteCompletionPage extends TemplatePage {
    public AnswerEnqueteCompletionPage(){
        add(new Link<>("toTopPage") {
            @Override
            public void onClick() {
                setResponsePage(TopPage.class);
            }
        });
    }
}