package com.login.view;

public interface LoginView {

    void showProgressBar();
    void hideProgressBar();
    void setUserNameError();
    void setUserEmailError();
    void onOpenNewActivity();

}
