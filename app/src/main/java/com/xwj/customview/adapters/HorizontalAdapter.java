package com.xwj.customview.adapters;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.xwj.customview.R;

/**
 * Created by user on 2015/4/10.
 */
public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.ViewHolder> {
    private Context mContext;
    private int imagesId[];

    public HorizontalAdapter(int[] imagesId, Context mContext) {
        this.imagesId = imagesId;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recycler_horizontal, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        //ImageLoader.getInstance().displayImage(imagesId[position] + "", holder.ivVertical);
        //
        holder.ivVertical.setImageResource(imagesId[position]);

        Palette.generateAsync(BitmapFactory.decodeResource(mContext.getResources(), imagesId[position]), new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                Palette.Swatch swatch = palette.getVibrantSwatch();
                if (swatch != null) {
                    try {   //可能产生空对象异常 需要抛出异常 否则会报错
                        holder.tvUrl.setTextColor(swatch.getTitleTextColor());
                        holder.tvUrl.setBackgroundColor(swatch.getRgb());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    holder.tvUrl.setText(imagesId[position] + "");
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return imagesId.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // 大图
        public ImageView ivVertical;
        // 图片url
        public TextView tvUrl;

        public ViewHolder(View itemView) {
            super(itemView);
            ivVertical = (ImageView) itemView.findViewById(R.id.iv_vertical);
            tvUrl = (TextView) itemView.findViewById(R.id.tv_vertical);
        }
    }
}

