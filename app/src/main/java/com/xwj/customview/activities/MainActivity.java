package com.xwj.customview.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xwj.customview.R;
import com.xwj.customview.adapters.SampleRecyelerAdapter;
import com.xwj.customview.views.CustomCircle;

/**
 * Created by admin on 2015/4/7.
 */
public class MainActivity extends Activity {
    private CustomCircle customCircle;
    private RecyclerView mRecyclerView;

    private SampleRecyelerAdapter mSampleRecyelerAdapter;

    private int imagesId[] = {R.mipmap.images, R.mipmap.beautifulgirl, R.mipmap.beautifulgirl1, R.mipmap.beautifulgirl2, R.mipmap.beautifulgirl4, R.mipmap.beautifulgirl5};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //customCircle = (CustomCircle) findViewById(R.id.custom_circle);
        // new Thread(customCircle).start();

        initComponent();
    }

    private void initComponent() {
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mSampleRecyelerAdapter = new SampleRecyelerAdapter(imagesId);

       // 线性布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        // 设置布局管理器
        mRecyclerView.setLayoutManager(linearLayoutManager);
    }



}
