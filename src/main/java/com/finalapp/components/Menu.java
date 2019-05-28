package com.finalapp.components;


import com.finalapp.controller.authentification.AccessControlFactory;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.RouterLink;

@StyleSheet("css/style.css")
public class Menu extends FlexLayout {

    private static final String SHOW_TABS = "show-tabs";
    private Tabs tabs;

    public Menu() {
        setClassName("menu-bar");


        // header of the menu
        final HorizontalLayout top = new HorizontalLayout();
        top.setDefaultVerticalComponentAlignment(Alignment.CENTER);
        top.setClassName("menu-header");

        Label title = new Label("Book store");

        Icon logo = new Icon(VaadinIcon.COG);
        top.add(logo);
        top.add(title);
        add(top);

        // container for the navigation buttons, which are added by addView()
        tabs = new Tabs();
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        setFlexGrow(1, tabs);
        add(tabs);

        // logout menu item
        Button logoutButton = new Button("Logout",
                VaadinIcon.SIGN_OUT.create());
        logoutButton.addClickListener(event -> AccessControlFactory
                .getInstance().createAccessControl().signOut());

        logoutButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
        add(logoutButton);
    }


    public void addView(Class<? extends Component> viewClass, String caption,
            Icon icon) {
        Tab tab = new Tab();
        RouterLink routerLink = new RouterLink(null, viewClass);
        routerLink.setClassName("menu-link");
        routerLink.add(icon);
        routerLink.add(new Span(caption));
        tab.add(routerLink);
        tabs.add(tab);
    }
}
