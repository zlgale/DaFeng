package com.zl.dafeng.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zl.dafeng.R;
import com.zl.dafeng.bo.model.VideoModel;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * <视频资源适配器>
 *
 * @author DaFeng 2017-02-10 14:44
 * @email 598787663@qq.com
 */

public class VideoAdapter extends BaseQuickAdapter<VideoModel.ShowapiResBodyBean.PagebeanBean.ContentlistBean, BaseViewHolder> {
    protected Context mContext;

    public VideoAdapter(int layoutResId, List<VideoModel.ShowapiResBodyBean.PagebeanBean.ContentlistBean> data, Context mContext) {
        super(layoutResId, data);
        this.mContext = mContext;
    }

//    public VideoAdapter(Context mContext, List<VideoModel.ShowapiResBodyBean.PagebeanBean.ContentlistBean> data) {
//        super(R.layout.item_video, data);
//        this.mContext = mContext;
//    }

    @Override
    protected void convert(BaseViewHolder helper, VideoModel.ShowapiResBodyBean.PagebeanBean.ContentlistBean item) {
        JCVideoPlayerStandard jcVideoPlayerStandard = helper.getView(R.id.videoplayer);
        ImageView imageView = null;
        TextView videoTitle = helper.getView(R.id.video_title);
        Bitmap bitmap = null;

        videoTitle.setText(item.getText());
        Glide.with(mContext).load(item.getProfile_image()).into(jcVideoPlayerStandard.thumbImageView);
        jcVideoPlayerStandard.setUp(
                item.getVideo_uri(), JCVideoPlayerStandard.SCREEN_LAYOUT_LIST,
                "");

    }
}
