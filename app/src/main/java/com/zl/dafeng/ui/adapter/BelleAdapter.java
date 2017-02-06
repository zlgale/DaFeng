package com.zl.dafeng.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zl.dafeng.R;
import com.zl.dafeng.bo.model.BelleModel;

import java.util.List;

/**
 * <美女图片适配器>
 *
 * @author DaFeng 2017-02-06 13:54
 * @email 598787663@qq.com
 */

public class BelleAdapter extends RecyclerView.Adapter<BelleAdapter.BelleViewHolder> {

    protected Context mContext;
    protected int mLayoutId;
    protected List<BelleModel.ShowapiResBodyBean.NewslistBean> mDatas;
    protected LayoutInflater mInflater;


    public BelleAdapter(Context mContext, List<BelleModel.ShowapiResBodyBean.NewslistBean> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public BelleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = mInflater.inflate(R.layout.item_belle, parent, false);
        return new BelleViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(BelleViewHolder holder, int position) {
        holder.belleImg.setImageURI(Uri.parse(mDatas.get(position).getPicUrl()));
    }

    @Override
    public int getItemCount() {
        return this.mDatas != null ? mDatas.size() : 0;
    }

    class BelleViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView belleImg;

        public BelleViewHolder(View itemView) {
            super(itemView);
            belleImg = (SimpleDraweeView) itemView.findViewById(R.id.belle_img);
        }
    }

}
