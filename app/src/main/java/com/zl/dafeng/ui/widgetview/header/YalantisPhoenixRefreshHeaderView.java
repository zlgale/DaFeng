package com.zl.dafeng.ui.widgetview.header;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.aspsine.swipetoloadlayout.SwipeRefreshTrigger;
import com.aspsine.swipetoloadlayout.SwipeTrigger;
import com.zl.dafeng.R;
import com.zl.dafeng.ui.widgetview.drawable.yalantis.BaseRefreshDrawable;
import com.zl.dafeng.ui.widgetview.drawable.yalantis.SunRefreshDrawable;
import com.zl.dafeng.util.ScreenUtils;

/**
 * Created by Aspsine on 2015/11/5.
 */
public class YalantisPhoenixRefreshHeaderView extends FrameLayout implements SwipeTrigger, SwipeRefreshTrigger {

    private ImageView ivRefresh;

    private BaseRefreshDrawable mDrawable;

    private int mTriggerOffset;

    public YalantisPhoenixRefreshHeaderView(Context context) {
        this(context, null);
    }

    public YalantisPhoenixRefreshHeaderView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public YalantisPhoenixRefreshHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mTriggerOffset = getResources().getDimensionPixelOffset(R.dimen.refresh_header_height_yalantis);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ivRefresh = (ImageView) findViewById(R.id.ivRefresh);
        mDrawable = new SunRefreshDrawable(getContext(), this, mTriggerOffset, ScreenUtils.getScreenWidth(getContext()));
        ivRefresh.setBackgroundDrawable(mDrawable);
    }


    @Override
    public void onRefresh() {
        if (!mDrawable.isRunning()){
            mDrawable.start();
        }
    }

    @Override
    public void onPrepare() {

    }

    private int mOldY = 0;

    @Override
    public void onMove(int y, boolean isComplete, boolean automatic) {
        int delta = y - mOldY;
        mDrawable.offsetTopAndBottom(delta);
        mDrawable.setPercent(y / (float) mTriggerOffset, true);
        mOldY = y;
    }

    @Override
    public void onRelease() {
        if (!mDrawable.isRunning()){
            mDrawable.start();
        }
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onReset() {
        mDrawable.stop();
    }
}
