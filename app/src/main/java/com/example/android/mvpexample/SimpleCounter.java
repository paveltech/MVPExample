package com.example.android.mvpexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.counter.presenter.MainCounterPresenter;
import com.counter.view.MainCounterView;
import com.counter.view.MainCounterViewImpliment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SimpleCounter extends AppCompatActivity implements MainCounterView{

    @BindView(R.id.plus)
    Button plus;
    @BindView(R.id.message)
    TextView messageDisplay;

    @BindView(R.id.minus)
    Button minus;

    @BindView(R.id.refresh)
    Button refresh;

    private MainCounterViewImpliment mainCounterViewImpliment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_counter);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mainCounterViewImpliment = new MainCounterPresenter(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainCounterViewImpliment.onSuccess();
    }

    @Override
    public void setPositiveButton() {
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainCounterViewImpliment.onAddNumber();
            }
        });
    }

    @Override
    public void setNegitiveButton() {
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainCounterViewImpliment.onRemoveNumber();
            }
        });
    }

    @Override
    public void setRefreshButton() {
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainCounterViewImpliment.onRefreshNUmber();
            }
        });
    }

    @Override
    public void showMessage(String message) {
        messageDisplay.setText(message);
    }
}
