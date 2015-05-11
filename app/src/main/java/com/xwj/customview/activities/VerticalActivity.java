package com.xwj.customview.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xwj.customview.R;
import com.xwj.customview.adapters.SampleRecyelerAdapter;

/**
 * Created by user on 2015/4/10.
 */
public class VerticalActivity extends Activity {
    private RecyclerView mRecyclerView;
    private SampleRecyelerAdapter mSampleRecyelerAdapter;
    public static int imagesId[] = {R.mipmap.images, R.mipmap.beautifulgirl, R.mipmap.beautifulgirl1,
            R.mipmap.beautifulgirl2, R.mipmap.beautifulgirl4, R.mipmap.beautifulgirl5, R.mipmap.beautifulgirl1,
            R.mipmap.beautifulgirl2, R.mipmap.beautifulgirl4, R.mipmap.beautifulgirl5, R.mipmap.beautifulgirl1,
            R.mipmap.beautifulgirl2, R.mipmap.beautifulgirl4, R.mipmap.beautifulgirl5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical);
        initComponent();
    }

    private void initComponent() {
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mSampleRecyelerAdapter = new SampleRecyelerAdapter(imagesId, this);

        // 线性布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        // 设置布局管理器
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mSampleRecyelerAdapter);}
}
