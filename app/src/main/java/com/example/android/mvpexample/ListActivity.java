package com.example.android.mvpexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.listview.Listpresenter.MainViewImplimentation;
import com.listview.view.MainListView;
import com.listview.view.MainListViewPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListActivity extends AppCompatActivity implements MainListView , AdapterView.OnItemClickListener{

    @BindView(R.id.list_list)
    ListView listView;
    @BindView(R.id.progress)
    ProgressBar progressBar;
    private MainListViewPresenter mainListViewPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mainListViewPresenter = new MainViewImplimentation(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainListViewPresenter.onSuccess();
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
    public void showMessage(String message) {
        Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setListItem(List<String> listItem) {
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItem));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mainListViewPresenter.onClick(position);
    }
}
