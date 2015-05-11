package com.xwj.customview.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xwj.customview.R;
import com.xwj.customview.adapters.HorizontalAdapter;

/**
 * Created by user on 2015/4/10.
 */
public class HorizontalActivity extends Activity {
    private RecyclerView mRecyclerView;
    private HorizontalAdapter mSampleRecyelerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical);
        initComponent();
    }

    private void initComponent() {
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mSampleRecyelerAdapter = new HorizontalAdapter(VerticalActivity.imagesId, this);

        // 线性布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        //设置布局管理器
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mSampleRecyelerAdapter);}
}

