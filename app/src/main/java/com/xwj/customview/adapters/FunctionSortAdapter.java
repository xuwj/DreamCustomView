package com.xwj.customview.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xwj.customview.Interface.CommonRecyclerItemClickListener;
import com.xwj.customview.Interface.CommonRecyclerItemLongClickListener;
import com.xwj.customview.R;

import java.util.List;

/**
 * Created by user on 2015/4/10.
 */
public class FunctionSortAdapter extends RecyclerView.Adapter<FunctionSortAdapter.ViewHolder>{
    private List<String> mFunctionData;
    private CommonRecyclerItemClickListener mCommonRecyclerItemClickListener;
    private CommonRecyclerItemLongClickListener mCommonRecyclerItemLongClickListener;

    public FunctionSortAdapter(List<String> mFunctionData) {
        this.mFunctionData = mFunctionData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_function_sort,viewGroup,false);
        return new ViewHolder(view,mCommonRecyclerItemClickListener,mCommonRecyclerItemLongClickListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.tvFunctionName.setText(mFunctionData.get(i));
    }

    @Override
    public int getItemCount() {
        return mFunctionData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{
        public TextView tvFunctionName;
        private CommonRecyclerItemClickListener mCommonRecyclerItemClickListener;
        private CommonRecyclerItemLongClickListener mCommonRecyclerItemLongClickListener;

        public ViewHolder(View itemView,CommonRecyclerItemClickListener commonRecyclerItemClickListener,CommonRecyclerItemLongClickListener commonRecyclerItemLongClickListener) {
            super(itemView);
            this.tvFunctionName = (TextView) itemView.findViewById(R.id.tv_function);
            this.mCommonRecyclerItemClickListener = commonRecyclerItemClickListener;
            this.mCommonRecyclerItemLongClickListener = commonRecyclerItemLongClickListener;
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mCommonRecyclerItemClickListener != null)
                mCommonRecyclerItemClickListener.onItemClick(v,getPosition());
        }

        @Override
        public boolean onLongClick(View v) {
            if (mCommonRecyclerItemLongClickListener != null)
                mCommonRecyclerItemLongClickListener.onItemLongClick(v,getPosition());
            return true;
        }
    }

    public void setmCommonRecyclerItemClickListener(CommonRecyclerItemClickListener mCommonRecyclerItemClickListener) {
        this.mCommonRecyclerItemClickListener = mCommonRecyclerItemClickListener;
    }

    public void setmCommonRecyclerItemLongClickListener(CommonRecyclerItemLongClickListener mCommonRecyclerItemLongClickListener) {
        this.mCommonRecyclerItemLongClickListener = mCommonRecyclerItemLongClickListener;
    }
}
