package com.listview.presenter;

import java.util.List;

public interface ListInterrupt {

    interface onListInterruptListener{
        void setItemIntoList(List<String> itemIntoList);
    }
    void onListInterruptSuccess(onListInterruptListener onListInterruptListener);
}
