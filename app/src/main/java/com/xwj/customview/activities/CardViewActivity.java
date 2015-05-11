package com.xwj.customview.activities;

import android.app.Activity;
import android.graphics.Outline;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.TextView;

import com.xwj.customview.R;

/**
 * Created by user on 2015/4/13.
 */
public class CardViewActivity extends Activity{
    private CardView mCardView;
    private TextView mRemindTv;
    private TextView mRemindTv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_cradview);
        mRemindTv = (TextView) findViewById(R.id.tv_cardview_remind);

        mRemindTv1 = (TextView) findViewById(R.id.tv_cardview_remind1);



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() {
                @Override
                public void getOutline(View view, Outline outline) {
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 10);
                }
            };
            mRemindTv.setOutlineProvider(viewOutlineProvider);

            ViewOutlineProvider viewOutlineProvider1 = new ViewOutlineProvider() {
                @Override
                public void getOutline(View view, Outline outline) {

                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), view.getHeight() / 2);
                }
            };
            mRemindTv1.setOutlineProvider(viewOutlineProvider1);

        }else
        {

        }



    }
}
