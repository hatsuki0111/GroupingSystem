package com.grouping.grouping_system;

import org.apache.wicket.Session;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

/**
 * サインイン処理に関するセッション
 */
public class SigningSession extends AbstractAuthenticatedWebSession {
    private String userName;

    public SigningSession(Request request) {
        super(request);
        userName = null;
    }

    @Override
    public Roles getRoles() {
        if(isSignedIn()){
            return new Roles(Roles.USER);
        }
        return new Roles();
    }

    @Override
    public boolean isSignedIn() {
        return userName != null;
    }

    public void signIn(String userName) {
        changeSessionId();
        setUserName(userName);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public static SigningSession get(){
        return (SigningSession) Session.get();
    }
}
