package com.finalapp.view;

import com.finalapp.controller.authentification.AccessControl;
import com.finalapp.controller.authentification.AccessControlFactory;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * UI content when the user is not logged in yet.
 */
@Route("")
@PageTitle("Login")
@StyleSheet("css/style.css")
public class LoginScreen extends FlexLayout {

    private AccessControl accessControl;

    public LoginScreen() {
        accessControl = AccessControlFactory.getInstance().createAccessControl();
        buildUI();
    }

    private void buildUI() {
        setSizeFull();
        setClassName("login-screen");

        // add title to our Application
        H1 title = new H1("Employe Manager");

        // login form, centered in the available part of the screen
        LoginForm loginForm = new LoginForm();
        loginForm.addLoginListener(this::login);
        loginForm.addForgotPasswordListener(
                event -> Notification.show("Hint: same as username"));

        // layout to center login form when there is sufficient screen space
        VerticalLayout centeringLayout = new VerticalLayout();
        centeringLayout.setSizeFull();
        centeringLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        centeringLayout.setAlignItems(Alignment.CENTER);
        centeringLayout.add(title,loginForm);


        // information text about logging in
        add(centeringLayout);
    }


    private void login(LoginForm.LoginEvent event) {
        if (accessControl.signIn(event.getUsername(), event.getPassword())) {
            getUI().get().navigate("dashboard");
        } else {
            event.getSource().setError(true);
        }
    }



}
