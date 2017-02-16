package com.zl.dafeng.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zl.dafeng.R;
import com.zl.dafeng.bo.model.BelleModel;
import com.zl.dafeng.ui.widgetview.RatingBar;

import java.util.List;

/**
 * <飘风适配器>
 *
 * @author DaFeng 2017-02-06 13:54
 * @email 598787663@qq.com
 */

public class BitchAdapter extends BaseQuickAdapter<BelleModel.ShowapiResBodyBean.NewslistBean, BaseViewHolder> {

    protected Context mContext;

    public BitchAdapter(Context mContext, List<BelleModel.ShowapiResBodyBean.NewslistBean> data) {
        super(R.layout.item_bitch, data);
        this.mContext = mContext;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, BelleModel.ShowapiResBodyBean.NewslistBean newslistBean) {


        SimpleDraweeView personIcon = baseViewHolder.getView(R.id.person_icon);
        TextView personSex = baseViewHolder.getView(R.id.person_sex);
        SimpleDraweeView personSexIcon = baseViewHolder.getView(R.id.person_sex_icon);
        personSexIcon.setBackground(mContext.getResources().getDrawable(R.mipmap.sex_girl));
        RatingBar ratingBar = baseViewHolder.getView(R.id.ratingbar);
        ratingBar.setStar(4.3f);
        personIcon.setImageURI(Uri.parse(newslistBean.getPicUrl()));
        personIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "点击了", Toast.LENGTH_LONG).show();
//                    Intent intent = new Intent(mContext, MaterialPagerActivity.class);
//                    mContext.startActivity(intent);
            }
        });
    }

}
