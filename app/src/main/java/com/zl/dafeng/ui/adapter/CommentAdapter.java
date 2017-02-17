package com.zl.dafeng.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zl.dafeng.R;
import com.zl.dafeng.bo.model.BelleModel;

import java.util.List;

/**
 * <美女详情-评论适配器>
 *
 * @author DaFeng 2017-02-06 13:54
 * @email 598787663@qq.com
 */

public class CommentAdapter extends BaseQuickAdapter<BelleModel.ShowapiResBodyBean.NewslistBean, BaseViewHolder> {

    protected Context mContext;

    public CommentAdapter(Context mContext, List<BelleModel.ShowapiResBodyBean.NewslistBean> data) {
        super(R.layout.item_comment, data);
        this.mContext = mContext;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, BelleModel.ShowapiResBodyBean.NewslistBean newslistBean) {


        final SimpleDraweeView praiseImg = baseViewHolder.getView(R.id.praise_img);
        final TextView praiseNumText = baseViewHolder.getView(R.id.praise_num);
        final int[] praiseNum = {Integer.parseInt(praiseNumText.getText().toString())};
        praiseImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                praiseImg.setBackground(mContext.getResources().getDrawable(R.mipmap.praise_red));
                praiseNum[0] += 1;
                praiseNumText.setText(praiseNum[0]+"");
                praiseNumText.setTextColor(Color.rgb(215,3,6));

            }
        });
    }

}
