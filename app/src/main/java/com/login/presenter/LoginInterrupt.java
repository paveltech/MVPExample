package com.login.presenter;

public interface LoginInterrupt {

    interface LoginInterruptListener{

        void showUserNameError();
        void showEmailError();
        void onSuccess();
    }

    void onLoginListenerFinished(String userName , String userEmail , LoginInterruptListener loginInterruptListener);
}
