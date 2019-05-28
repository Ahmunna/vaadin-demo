package com.finalapp.view;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "about",layout = MainLayout.class)
public class AboutView extends VerticalLayout {

    public static final String VIEW_NAME="About";
    public AboutView()
    {
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        H1 title = new H1("Created by 5 stressed students");
        add(title);
    }
}
