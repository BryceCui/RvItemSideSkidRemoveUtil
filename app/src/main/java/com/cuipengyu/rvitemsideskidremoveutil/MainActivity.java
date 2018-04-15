package com.cuipengyu.rvitemsideskidremoveutil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    RecyclerView main_rv;
    List<Integer> mDdat;
    RecycleViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDdat = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mDdat.add(i);
        }
        main_rv = findViewById(R.id.main_rv);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        main_rv.setLayoutManager(manager);
        mAdapter = new RecycleViewAdapter(this, mDdat);
        main_rv.setAdapter(mAdapter);

    }


}
