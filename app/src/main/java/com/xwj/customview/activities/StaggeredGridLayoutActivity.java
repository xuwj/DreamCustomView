package com.xwj.customview.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.xwj.customview.R;
import com.xwj.customview.adapters.StaggeredGridLayoutAdapter;

/**
 * Created by user on 2015/4/10.
 */
public class StaggeredGridLayoutActivity extends Activity {
    private RecyclerView mRecyclerView;
    private StaggeredGridLayoutAdapter mStaggeredGridLayoutAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical);
        initComponent();
    }

    private void initComponent() {
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mStaggeredGridLayoutAdapter = new StaggeredGridLayoutAdapter(VerticalActivity.imagesId, this);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL);

        //设置布局管理器
        mRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        mRecyclerView.setAdapter(mStaggeredGridLayoutAdapter);}
}

