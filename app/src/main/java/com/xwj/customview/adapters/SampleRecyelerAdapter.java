package com.xwj.customview.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.xwj.customview.R;

/**
 * Created by admin on 2015/4/9.
 */
public class SampleRecyelerAdapter extends RecyclerView.Adapter<SampleRecyelerAdapter.ViewHolder> {

    private int imagesId[];
    public SampleRecyelerAdapter(int imagesId[]) {
        this.imagesId = imagesId;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_vertical, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ImageLoader.getInstance().displayImage(imagesId[position] + "", holder.ivVertical);
        holder.tvUrl.setText(imagesId[position] + "");
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
            ivVertical  = (ImageView) itemView.findViewById(R.id.iv_vertical);
            tvUrl = (TextView) itemView.findViewById(R.id.tv_vertical);
        }
    }
}
