package com.counter.presenter;

import com.counter.view.MainCounterView;
import com.counter.view.MainCounterViewImpliment;

public class MainCounterPresenter implements CounterInterrupt.onCounterInterruptListener , MainCounterViewImpliment {

    private MainCounterView mainCounterView;
    private CounterInterrupt counterInterrupt;
    private static int number = 0;

    public MainCounterPresenter(MainCounterView mainCounterView){
        this.mainCounterView = mainCounterView;
        counterInterrupt = new CounterInterruptImpliment();
    }

    @Override
    public void onCounterSuccess() {
        if (mainCounterView!=null){
            counterInterrupt.onCounterInterruptListenerSuccess(this);
        }
    }

    @Override
    public void onAddNumber() {
        if (mainCounterView!=null){
            number = number+1;
            mainCounterView.showMessage("Count: "+number);

        }
    }

    @Override
    public void onRemoveNumber() {
        if (mainCounterView!=null){
            number = number - 1;
            mainCounterView.showMessage("Count: "+number);

        }
    }

    @Override
    public void onRefreshNUmber() {
        if (mainCounterView!=null){
            if (number>0){
                number = 0;
                mainCounterView.showMessage("count: "+number);
            }
        }
    }

    @Override
    public void onSuccess() {
        if (mainCounterView!=null){
            mainCounterView.setNegitiveButton();
            mainCounterView.setPositiveButton();
            mainCounterView.setRefreshButton();
        }
    }
}
