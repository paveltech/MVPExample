package com.login.mainpresenter;

import com.login.presenter.LoginInterrupt;
import com.login.presenter.LoginInterruptListnerImpliment;
import com.login.view.LoginView;
import com.login.view.LoginViewPresenter;

public class MainLoginPresenter implements LoginInterrupt.LoginInterruptListener , LoginViewPresenter {


    private LoginView loginView;
    private LoginInterrupt loginInterrupt;


    public MainLoginPresenter(LoginView loginView){
        this.loginView = loginView;
        loginInterrupt = new LoginInterruptListnerImpliment();
    }

    @Override
    public void showUserNameError() {
        if (loginView!=null){
            loginView.setUserNameError();
            loginView.hideProgressBar();
        }
    }

    @Override
    public void showEmailError() {
        if (loginView!=null){
            loginView.setUserEmailError();
            loginView.hideProgressBar();
        }
    }

    @Override
    public void onSuccess() {
        if (loginView!=null){
            loginView.onOpenNewActivity();
            loginView.hideProgressBar();
        }
    }

    @Override
    public void onDestroy() {
        if (loginView!=null){
            loginView = null;
        }
    }

    @Override
    public void onFinished(String userName, String userEmail) {
        loginInterrupt.onLoginListenerFinished(userName , userEmail , this);
        if (loginView!=null){
            loginView.showProgressBar();
        }
    }
}
