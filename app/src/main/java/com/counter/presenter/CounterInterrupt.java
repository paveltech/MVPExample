package com.counter.presenter;

public interface CounterInterrupt {

    interface onCounterInterruptListener{
        void onCounterSuccess();
    }
    void onCounterInterruptListenerSuccess(onCounterInterruptListener onCounterInterruptListener);
}
