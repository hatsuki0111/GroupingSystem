package com.grouping.grouping_system.page;

import org.apache.wicket.markup.html.link.Link;

public class EditEnqueteCompletionPage extends TemplatePage {
    public EditEnqueteCompletionPage(){
        add(new Link<>("toTopPage") {
            @Override
            public void onClick() {
                setResponsePage(TopPage.class);
            }
        });
    }
}