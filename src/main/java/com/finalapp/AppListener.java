package com.finalapp;

import com.finalapp.controller.authentification.AccessControl;
import com.finalapp.controller.authentification.AccessControlFactory;
import com.finalapp.view.LoginScreen;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;

public class AppListener implements VaadinServiceInitListener {
    @Override
    public void serviceInit(ServiceInitEvent initEvent) {
        final AccessControl accessControl = AccessControlFactory.getInstance()
                .createAccessControl();

        initEvent.getSource().addUIInitListener(uiInitEvent -> {
            uiInitEvent.getUI().addBeforeEnterListener(enterEvent -> {
                if (!accessControl.isUserSignedIn() && !LoginScreen.class
                        .equals(enterEvent.getNavigationTarget()))
                    enterEvent.rerouteTo(LoginScreen.class);
            });
        });
    }
}
