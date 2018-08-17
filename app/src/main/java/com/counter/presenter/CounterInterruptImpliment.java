package com.counter.presenter;

public class CounterInterruptImpliment implements CounterInterrupt {

    @Override
    public void onCounterInterruptListenerSuccess(onCounterInterruptListener onCounterInterruptListener) {
        onCounterInterruptListener.onCounterSuccess();
    }
}
