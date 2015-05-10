package com.xwj.customview.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.xwj.customview.utils.MeasureUtil;


/**
 * Created by admin on 2015/4/7.
 */
public class CustomCircle extends View implements Runnable{
    private Paint mPaint;
    private Context mContext;// 上下文环境引用
    private int radiu;// 圆环半径

    public CustomCircle(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initPaint();
    }

    public CustomCircle(Context context) {
        super(context);
    }

    private void initPaint() {
        // 实例化画笔并打开抗锯齿
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        /**
         * 设置画笔样式为描边，圆环嘛……当然不能填充不然就么意思了
         *
         * 画笔样式分三种：
         * 1.Paint.Style.STROKE：描边
         * 2.Paint.Style.FILL_AND_STROKE：描边并填充
         * 3.Paint.Style.FILL：填充
         */
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(getResources().getColor(android.R.color.holo_blue_bright));
        /**
         * 设置描边的粗细，单位：像素px
         * 注意：当setStrokeWidth(0)的时候描边宽度并不为0而是只占一个像素
         */
        mPaint.setStrokeWidth(10);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 绘制圆环
        canvas.drawCircle(MeasureUtil.getScreenSize((Activity) mContext)[0] / 2, MeasureUtil.getScreenSize((Activity) mContext)[1] / 2, radiu, mPaint);
    }

    @Override
    public void run() {
        while(true){
            try {
                if (radiu <= 200){
                    radiu += 10;
                    postInvalidate();
                }else{
                    radiu = 0;
                }
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
