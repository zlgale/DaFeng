package com.zl.dafeng.service.interfaces;

import android.support.design.widget.AppBarLayout;

/**
 * <监听CollapsingToolbarLayout的展开与折叠>
 *
 * @author DaFeng 2017-02-07 15:29
 * @email 598787663@qq.com
 */

public abstract class AppBarStateChangeListener implements AppBarLayout.OnOffsetChangedListener {
    public enum State {
        EXPANDED,
        COLLAPSED,
        IDLE
    }
    private State mCurrentState = State.IDLE;
    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if (verticalOffset == 0) {
            if (mCurrentState != State.EXPANDED) {
                onStateChanged(appBarLayout, State.EXPANDED);
            }
            mCurrentState = State.EXPANDED;
        } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
            if (mCurrentState != State.COLLAPSED) {
                onStateChanged(appBarLayout, State.COLLAPSED);
            }
            mCurrentState = State.COLLAPSED;
        } else {
            if (mCurrentState != State.IDLE) {
                onStateChanged(appBarLayout, State.IDLE);
            }
            mCurrentState = State.IDLE;
        }
    }
    public abstract void onStateChanged(AppBarLayout appBarLayout, State state);
}
