package com.grouping.grouping_system.page;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import com.grouping.grouping_system.bean.Enquete;
import com.grouping.grouping_system.service.IAnswerEnqueteService;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.wicketstuff.annotation.mount.MountPath;

import java.lang.reflect.Parameter;
import java.time.LocalDateTime;

@MountPath("TopPage")
public class TopPage extends TemplatePage {

    @SpringBean
    private IAnswerEnqueteService answerEnqueteService;

    public TopPage() {
        add(new MenuBarPanel("menuBar"));

        add(new ListView<>("answerableEnqueteListView", Model.ofList(answerEnqueteService.getAnswerableEnqueteList())) {
            @Override
            protected void populateItem(ListItem<Enquete> listItem) {
                listItem.add(new Link<String>("toAnswerEnquetePage") {
                    @Override
                    protected void onInitialize() {
                        super.onInitialize();
                        if (!answerEnqueteService.isAnswerable(listItem.getModelObject())) {
                            setEnabled(false);
                        }
                    }

                    @Override
                    public void onClick() {
                        setResponsePage(new AnswerEnquetePage(listItem.getModel()));
                    }
                }.add(new Label("enqueteTitleLabel", Model.of(listItem.getModelObject().getTitle()))));
                listItem.add(new Label("authorAccountNameLabel", listItem.getModelObject().getAuthorAccountName()));
            }
        });
    }
}
