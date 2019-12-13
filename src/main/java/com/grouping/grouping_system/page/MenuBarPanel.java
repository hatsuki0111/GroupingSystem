package com.grouping.grouping_system.page;

import com.grouping.grouping_system.SigningSession;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

public class MenuBarPanel extends Panel {
    public MenuBarPanel(String id) {
        super(id);
        add(new Link<>("toTopPage"){
            @Override
            public void onClick() {
                setResponsePage(TopPage.class);
            }
        });
        add(new Link<>("toCreateEnquetePage") {
            @Override
            public void onClick() {
                setResponsePage(CreateEnquetePage.class);
            }
        });
        add(new Link<>("toSignOutCompletionPage") {
            @Override
            public void onClick() {
                SigningSession.get().invalidate();
                setResponsePage(SignOutCompletionPage.class);
            }
        });
    }
}