package com.grouping.grouping_system.page;

import com.grouping.grouping_system.bean.Enquete;
import com.grouping.grouping_system.bean.Option;
import com.grouping.grouping_system.bean.SelectedOption;
import com.grouping.grouping_system.service.IAnswerEnqueteService;
import com.grouping.grouping_system.service.IViewResultService;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

@MountPath("ViewResult")
public class ViewResultPage extends TemplatePage {

    @SpringBean
    private IAnswerEnqueteService answerEnqueteService;

    @SpringBean
    private IViewResultService viewResultService;

    public ViewResultPage(IModel<Enquete> enqueteModel){
//        add(new MenuBarPanel("menuBar"));
        add(new Label("titleLabel",enqueteModel.getObject().getTitle()));
        add(new Label("authorAccountNameLabel",enqueteModel.getObject().getAuthorAccountName()));
        add(new ListView<>("optionListView",viewResultService.getOptionList(enqueteModel.getObject())) {
            @Override
            protected void populateItem(ListItem<Option> listItem) {
                listItem.add(new Label("optionLabel",listItem.getModelObject().getLabel()));
                listItem.add(new ListView<>("accountNameListView",viewResultService.getSelectedOptionList(listItem.getModelObject(),enqueteModel.getObject())) {
                    @Override
                    protected void populateItem(ListItem<SelectedOption> listItem) {
                        listItem.add(new Label("accountNameLabel",listItem.getModelObject().getAccountName()));
                    }
                });
            }
        });
        add(new Link<>("toTopPage") {
            @Override
            public void onClick() {
                setResponsePage(TopPage.class);
            }
        });
    }
}
