package com.grouping.grouping_system.page;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.wicketstuff.annotation.mount.MountPath;

@WicketHomePage
@MountPath("TopPage")
public class TopPage extends TemplatePage {
    public TopPage(){
        add(new MenuBarPanel("menuBar"));
    }
}
