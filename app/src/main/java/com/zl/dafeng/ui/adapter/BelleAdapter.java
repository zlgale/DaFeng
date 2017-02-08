package com.zl.dafeng.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
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

public class BelleAdapter extends BaseQuickAdapter<BelleModel.ShowapiResBodyBean.NewslistBean,BaseViewHolder> {

    protected Context mContext;

    public BelleAdapter(Context mContext, List<BelleModel.ShowapiResBodyBean.NewslistBean> data) {
        super(R.layout.item_belle, data);
        this.mContext = mContext;
    }
    @Override
    protected void convert(BaseViewHolder baseViewHolder, BelleModel.ShowapiResBodyBean.NewslistBean newslistBean) {
        SimpleDraweeView belleImg = baseViewHolder.getView(R.id.belle_img);
        belleImg.setImageURI(Uri.parse(newslistBean.getPicUrl()));
        belleImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "点击了", Toast.LENGTH_LONG).show();
//                    Intent intent = new Intent(mContext, MaterialPagerActivity.class);
//                    mContext.startActivity(intent);
            }
        });
    }

}
