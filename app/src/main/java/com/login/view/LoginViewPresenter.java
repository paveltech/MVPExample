package com.login.view;

public interface LoginViewPresenter {

    void onDestroy();
    void onFinished(String userName , String userEmail);
}
