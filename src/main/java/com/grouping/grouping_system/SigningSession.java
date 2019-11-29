package com.grouping.grouping_system;

import org.apache.wicket.Session;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

/**
 * サインイン処理に関するセッション
 */
public class SigningSession extends AbstractAuthenticatedWebSession {
    private String accountName;

    public SigningSession(Request request) {
        super(request);
        accountName = null;
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
        return accountName != null;
    }

    public void signIn(String accountName) {
        changeSessionId();
        setAccountName(accountName);
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }


    public static SigningSession get(){
        return (SigningSession) Session.get();
    }
}
