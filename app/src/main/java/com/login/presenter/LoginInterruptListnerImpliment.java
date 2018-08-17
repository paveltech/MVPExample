package com.login.presenter;

import android.os.Handler;
import android.text.TextUtils;

public class LoginInterruptListnerImpliment implements LoginInterrupt{
    @Override
    public void onLoginListenerFinished(final String userName, final String userEmail, final LoginInterruptListener loginInterruptListener) {
        new Handler().postDelayed(new Runnable() {

            boolean isError = false;
            @Override
            public void run() {
                if (TextUtils.isEmpty(userName)){
                    loginInterruptListener.showUserNameError();
                    isError = true;
                }
                if (TextUtils.isEmpty(userEmail)){
                    loginInterruptListener.showEmailError();
                    isError = true;
                }

                if (!isError){
                    loginInterruptListener.onSuccess();
                }

            }
        } , 1000);
    }
}
