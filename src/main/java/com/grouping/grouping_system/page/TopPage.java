package com.grouping.grouping_system.page;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import com.grouping.grouping_system.bean.Enquete;
import com.grouping.grouping_system.page.evaluation.EvaluatePage;
import com.grouping.grouping_system.page.evaluation.ViewEvaluationPage;
import com.grouping.grouping_system.service.IAnswerEnqueteService;
import com.grouping.grouping_system.service.IEditEnqueteService;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

@WicketHomePage
@AuthorizeInstantiation(Roles.USER)
@MountPath("Top")
public class TopPage extends TemplatePage {

    @SpringBean
    private IAnswerEnqueteService answerEnqueteService;

    @SpringBean
    private IEditEnqueteService editEnqueteService;

    public TopPage() {
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
                listItem.add(new Label("startDateTimeLabel", listItem.getModelObject().getStartDateTime()));
                listItem.add(new Label("endDateTimeLabel", listItem.getModelObject().getEndDateTime()));
                listItem.add(new Label("postedDateTimeLabel", listItem.getModelObject().getPostedDateTime()));
                listItem.add(new Link<>("toViewResultPage") {
                    @Override
                    public void onClick() {
                        setResponsePage(new ViewResultPage(listItem.getModel()));
                    }
                });
                listItem.add(new Link<>("toEvaluationPage") {
                    @Override
                    public void onClick() {
                        setResponsePage(new ViewEvaluationPage(listItem.getModel()));
                    }
                });
            }
        });

        add(new ListView<>("editableEnqueteListView", Model.ofList(editEnqueteService.getEditableEnqueteList())) {
            @Override
            protected void populateItem(ListItem<Enquete> listItem) {
                listItem.add(new Link<String>("toEditEnquetePage") {
                    @Override
                    public void onClick() {
                        setResponsePage(new EditEnquetePage(listItem.getModel()));
                    }
                }.add(new Label("enqueteTitleLabel", Model.of(listItem.getModelObject().getTitle()))));
                listItem.add(new Label("startDateTimeLabel", listItem.getModelObject().getStartDateTime()));
                listItem.add(new Label("endDateTimeLabel", listItem.getModelObject().getEndDateTime()));
                listItem.add(new Label("postedDateTimeLabel", listItem.getModelObject().getPostedDateTime()));
                listItem.add(new Link<>("toViewResultPage") {
                    @Override
                    public void onClick() {
                        setResponsePage(new ViewResultPage(listItem.getModel()));
                    }
                });
            }
        });
    }
}