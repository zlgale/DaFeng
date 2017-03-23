package com.zl.dafeng.ui.widgetview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * <禁用/开启滑动切换功能>
 *
 * @author DaFeng 2017/03/22 14:24
 * @email 598787663@qq.com
 */

public class Myviewpager extends ViewPager {
    private boolean scrollble = true;

    public Myviewpager(Context context) {
        super(context);
    }

    public Myviewpager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (!scrollble) {
            return true;
        }
        return super.onTouchEvent(ev);
    }


    public boolean isScrollble() {
        return scrollble;
    }

    public void setScrollble(boolean scrollble) {
        this.scrollble = scrollble;
    }
}
