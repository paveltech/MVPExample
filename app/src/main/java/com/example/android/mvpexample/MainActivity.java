package com.example.android.mvpexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.login.mainpresenter.MainLoginPresenter;
import com.login.view.LoginView;
import com.login.view.LoginViewPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements LoginView{

    private LoginViewPresenter loginViewPresenter;

    @BindView(R.id.password)
    EditText userPassword;
    @BindView(R.id.username)
    EditText userName;
    @BindView(R.id.progress)
    ProgressBar progressBar;
    @BindView(R.id.button)
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        loginViewPresenter = new MainLoginPresenter(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginViewPresenter.onFinished(userName.getText().toString() , userPassword.getText().toString());
            }
        });

    }


    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUserNameError() {
        userName.setError(getResources().getString(R.string.username_error));
    }

    @Override
    public void setUserEmailError() {
        userPassword.setError(getResources().getString(R.string.password_error));
    }

    @Override
    public void onOpenNewActivity() {
        startActivity(new Intent(this , SecondActivity.class));
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginViewPresenter.onDestroy();
    }
}
