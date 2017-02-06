package com.zl.dafeng.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * <一句话功能简述>
 *
 * @author DaFeng 2017-02-06 13:54
 * @email 598787663@qq.com
 */

public class CommonAdapter<T> extends RecyclerView.Adapter {

    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;

    public CommonAdapter(Context mContext, int mLayoutId, List<T> mDatas) {
        this.mContext = mContext;
        this.mLayoutId = mLayoutId;
        this.mDatas = mDatas;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return this.mDatas != null ? mDatas.size() : 0;
    }

    class CommonViewHolder extends RecyclerView.ViewHolder{

        public CommonViewHolder(View itemView) {
            super(itemView);
        }
    }
}
