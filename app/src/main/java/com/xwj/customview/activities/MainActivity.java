package com.xwj.customview.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.xwj.customview.Interface.CommonRecyclerItemClickListener;
import com.xwj.customview.Interface.CommonRecyclerItemLongClickListener;
import com.xwj.customview.R;
import com.xwj.customview.adapters.FunctionSortAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2015/4/7.
 */
public class MainActivity extends Activity implements CommonRecyclerItemLongClickListener, CommonRecyclerItemClickListener {
    //private CustomCircle customCircle;
    private RecyclerView mRecyclerView;
    private FunctionSortAdapter mFunctionSortAdapter;
    private List<String> mLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //customCircle = (CustomCircle) findViewById(R.id.custom_circle);
        // new Thread(customCircle).start();
        initComponent();
        initData();
    }


    private void initData() {
        mLists = new ArrayList<>();
        mLists.add("竖直效果");
        mLists.add("水平效果");
        mLists.add("瀑布流效果");
        mLists.add("GridView效果");
        mLists.add("卡片效果");
        mLists.add("listview不同item效果");
        mFunctionSortAdapter = new FunctionSortAdapter(mLists);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mFunctionSortAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mFunctionSortAdapter.setmCommonRecyclerItemClickListener(this);
        mFunctionSortAdapter.setmCommonRecyclerItemLongClickListener(this);
    }

    private void initComponent() {
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
    }


    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "点击了---" + mLists.get(position), Toast.LENGTH_SHORT).show();

        Intent intent = null;
        switch (position) {
            case 0:
                intent = new Intent(this, VerticalActivity.class);
                break;
            case 1:
                intent = new Intent(this, HorizontalActivity.class);
                break;
            case 2:
                intent = new Intent(this, StaggeredGridLayoutActivity.class);
                break;
            case 3:
                intent = new Intent(this, GridlayoutActivity.class);
                break;
            case 4:
                intent = new Intent(this, CardViewActivity.class);
                break;
            case 5:
                intent = new Intent(this, ListViewItemActivity.class);
                break;
        }
        if (intent != null)
            startActivity(intent);

    }

    @Override
    public void onItemLongClick(View view, int position) {
        Toast.makeText(this, "长按了---" + mLists.get(position), Toast.LENGTH_SHORT).show();
    }
}
