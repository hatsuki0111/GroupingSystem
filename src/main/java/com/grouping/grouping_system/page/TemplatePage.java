package com.grouping.grouping_system.page;

import com.grouping.grouping_system.page.panel.FooterPanel;
import com.grouping.grouping_system.page.panel.MenuBarPanel;
import org.apache.wicket.markup.html.WebPage;

/**
 * 一部を除く全てのページの大元となるクラス
 */
public class TemplatePage extends WebPage {
    public TemplatePage() {
        add(new MenuBarPanel("menuBar"));
        add(new FooterPanel("footer"));
    }
}
