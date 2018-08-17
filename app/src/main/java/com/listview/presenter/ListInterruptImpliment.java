package com.listview.presenter;

import android.os.Handler;

import java.util.Arrays;
import java.util.List;

public class ListInterruptImpliment implements ListInterrupt{

    @Override
    public void onListInterruptSuccess(final onListInterruptListener onListInterruptListener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onListInterruptListener.setItemIntoList(createItem());
            }
        } , 1000);

    }
    public List<String> createItem(){
        return Arrays.asList("item 1", "item 2", "item 3", "item 4", "item 5", "item 6", "item 7", "item 8", "item 9", "item 10");
    }

}
