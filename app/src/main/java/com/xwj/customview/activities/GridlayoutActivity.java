package com.xwj.customview.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xwj.customview.R;
import com.xwj.customview.adapters.SampleRecyelerAdapter;

/**
 * Created by user on 2015/4/10.
 */
public class GridlayoutActivity  extends Activity {
    private RecyclerView mRecyclerView;
    private SampleRecyelerAdapter mSampleRecyelerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical);
        initComponent();
    }

    private void initComponent() {
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mSampleRecyelerAdapter = new SampleRecyelerAdapter(VerticalActivity.imagesId, this);

       // GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,LinearLayoutManager.VERTICAL,false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,LinearLayoutManager.HORIZONTAL,false);
        //设置布局管理器
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(mSampleRecyelerAdapter);}
}
