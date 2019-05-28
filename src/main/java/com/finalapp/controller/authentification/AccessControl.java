package com.finalapp.controller.authentification;

import java.io.Serializable;


public interface AccessControl extends Serializable {


    boolean signIn(String username, String password);

    boolean isUserSignedIn();

    String getPrincipalName();

    void signOut();
}
