package com.zl.dafeng.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuAdapter;
import com.zl.dafeng.R;
import com.zl.dafeng.bo.model.BelleModel;
import com.zl.dafeng.service.interfaces.OnItemClickListener;

import java.util.List;

/**
 * <美女图片适配器>
 *
 * @author DaFeng 2017-02-06 13:54
 * @email 598787663@qq.com
 */

public class BelleAdapter extends SwipeMenuAdapter<BelleAdapter.DefaultViewHolder> {

    protected Context mContext;
    protected int mLayoutId;
    protected List<BelleModel.ShowapiResBodyBean.NewslistBean> mDatas;
    private OnItemClickListener mOnItemClickListener;

    public BelleAdapter(Context mContext, List<BelleModel.ShowapiResBodyBean.NewslistBean> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
    }

    @Override
    public View onCreateContentView(ViewGroup parent, int viewType) {
        return LayoutInflater.from(parent.getContext()).inflate(R.layout.item_belle, parent, false);
    }

    @Override
    public DefaultViewHolder onCompatCreateViewHolder(View realContentView, int viewType) {
        return new DefaultViewHolder(realContentView);
    }

    @Override
    public void onBindViewHolder(DefaultViewHolder holder, int position) {

        holder.setData(mDatas.get(position));
        holder.setOnItemClickListener(mOnItemClickListener);

    }

    @Override
    public int getItemCount() {
        return this.mDatas != null ? mDatas.size() : 0;
    }

    //    class BelleViewHolder extends RecyclerView.ViewHolder {
//        SimpleDraweeView belleImg;
//
//        public BelleViewHolder(View itemView) {
//            super(itemView);
//            belleImg = (SimpleDraweeView) itemView.findViewById(R.id.belle_img);
//        }
//    }
    class DefaultViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        SimpleDraweeView belleImg;
        OnItemClickListener mOnItemClickListener;

        public DefaultViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            belleImg = (SimpleDraweeView) itemView.findViewById(R.id.belle_img);
        }

        public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
            this.mOnItemClickListener = onItemClickListener;
        }

        public void setData(final BelleModel.ShowapiResBodyBean.NewslistBean myChooseType) {
            belleImg.setImageURI(Uri.parse(myChooseType.getPicUrl()));
            belleImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "点击了", Toast.LENGTH_LONG).show();
//                    Intent intent = new Intent(mContext, MaterialPagerActivity.class);
//                    mContext.startActivity(intent);
                }
            });
        }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(getAdapterPosition());
            }
        }
    }
}
