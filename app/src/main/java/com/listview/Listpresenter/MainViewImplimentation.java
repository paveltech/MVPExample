package com.listview.Listpresenter;

import com.listview.presenter.ListInterrupt;
import com.listview.presenter.ListInterruptImpliment;
import com.listview.view.MainListView;
import com.listview.view.MainListViewPresenter;

import java.util.List;

public class MainViewImplimentation implements ListInterrupt.onListInterruptListener , MainListViewPresenter{


    private MainListView mainListView;
    private ListInterrupt listInterrupt;


    public MainViewImplimentation(MainListView mainListView){
        this.mainListView = mainListView;
        listInterrupt = new ListInterruptImpliment();

    }

    @Override
    public void setItemIntoList(List<String> itemIntoList) {
        if (mainListView!=null){
            mainListView.setListItem(itemIntoList);
            mainListView.hideProgressBar();
        }
    }

    @Override
    public void onClick(int position) {
        if (mainListView!=null){
            mainListView.showMessage("Item Click: "+position);
        }
    }

    @Override
    public void onSuccess() {
        if (mainListView!=null){
            listInterrupt.onListInterruptSuccess(this);
            mainListView.showProgressBar();
        }
    }
}
