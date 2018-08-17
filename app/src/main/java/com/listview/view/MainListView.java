package com.listview.view;

import java.util.List;

public interface MainListView {

    void showProgressBar();
    void hideProgressBar();
    void showMessage(String message);
    void setListItem(List<String> listItem);
}
