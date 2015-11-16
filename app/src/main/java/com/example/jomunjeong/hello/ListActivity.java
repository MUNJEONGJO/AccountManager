package com.example.jomunjeong.hello;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        init();
    }

    private void init(){
        recyclerView = (RecyclerView)findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new MyRecyclerAdapter(getApplicationContext(), createItemList() , R.layout.item_demo));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private List<ViewModel> createItemList(){
        List<ViewModel> items = new ArrayList<ViewModel>();
        for(int i=0; i<20; i++){
            ViewModel model = new ViewModel();
            model.setTitle("title_" + i);
            items.add(model);

        }

        return items;
    }

}
