package com.zl.dafeng.ui.activity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.SoundEffectConstants;
import android.view.View;
import android.widget.ImageView;

import com.zl.dafeng.R;
import com.zl.dafeng.ui.base.BaseActivity;
import com.zl.dafeng.ui.widgetview.PinchImageView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PicViewActivity extends BaseActivity {

    private static final long ANIM_TIME = 200;
    @BindView(R.id.pic)
    PinchImageView pic;
    @BindView(R.id.background)
    ImageView background;

    private RectF mThumbMaskRect;
    private Matrix mThumbImageMatrix;

    private ObjectAnimator mBackgroundAnimator;

    private View mBackground;
    private PinchImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        //获取参数
//        ImageSource image = (ImageSource) getIntent().getSerializableExtra("image");
//        String memoryCacheKey =  getIntent().getStringExtra("cache_key");
//        final Rect rect = getIntent().getParcelableExtra("rect");
//        final ImageView.ScaleType scaleType = (ImageView.ScaleType) getIntent().getSerializableExtra("scaleType");
//
//        final ImageObject thumb = image.getThumb(100, 100);
//
//        ImageLoader imageLoader = Global.getImageLoader(getApplicationContext());
//        DisplayImageOptions originOptions = new DisplayImageOptions.Builder().build();

        //view初始化
        setContentView(R.layout.activity_pic_view);
        ButterKnife.bind(this);

//        mImageView = (PinchImageView) findViewById(R.id.pic);
//        mBackground = findViewById(R.id.background);
//        Bitmap bitmap = imageLoader.getMemoryCache().get(memoryCacheKey);
//        if (bitmap != null && !bitmap.isRecycled()) {
//            mImageView.setImageBitmap(bitmap);
//        }
//        imageLoader.displayImage(image.getOrigin().url, mImageView, originOptions);

//        mImageView.post(new Runnable() {
//            @Override
//            public void run() {
//                mImageView.setAlpha(1f);
//
//                //背景动画
//                mBackgroundAnimator = ObjectAnimator.ofFloat(mBackground, "alpha", 0f, 1f);
//                mBackgroundAnimator.setDuration(ANIM_TIME);
//                mBackgroundAnimator.start();
//
//                //status bar高度修正
//                Rect tempRect = new Rect();
//                mImageView.getGlobalVisibleRect(tempRect);
//                rect.top = rect.top - tempRect.top;
//                rect.bottom = rect.bottom - tempRect.top;
//
//                //mask动画
//                mThumbMaskRect = new RectF(rect);
//                RectF bigMaskRect = new RectF(0, 0, mImageView.getWidth(), mImageView.getHeight());
//                mImageView.zoomMaskTo(mThumbMaskRect, 0);
//                mImageView.zoomMaskTo(bigMaskRect, ANIM_TIME);
//
//
//                //图片放大动画
//                RectF thumbImageMatrixRect = new RectF();
//                PinchImageView.MathUtils.calculateScaledRectInContainer(new RectF(rect), thumb.width, thumb.height, scaleType, thumbImageMatrixRect);
//                RectF bigImageMatrixRect = new RectF();
//                PinchImageView.MathUtils.calculateScaledRectInContainer(new RectF(0, 0, mImageView.getWidth(), mImageView.getHeight()), thumb.width, thumb.height, ImageView.ScaleType.FIT_CENTER, bigImageMatrixRect);
//                mThumbImageMatrix = new Matrix();
//                PinchImageView.MathUtils.calculateRectTranslateMatrix(bigImageMatrixRect, thumbImageMatrixRect, mThumbImageMatrix);
//                mImageView.outerMatrixTo(mThumbImageMatrix, 0);
//                mImageView.outerMatrixTo(new Matrix(), ANIM_TIME);
//            }
//        });
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImageView.playSoundEffect(SoundEffectConstants.CLICK);
                finish();
            }
        });
    }

    @Override
    protected int getLayout() {
        return 0;
    }

    @Override
    protected void initialize() {

    }

    @Override
    public void finish() {
        if ((mBackgroundAnimator != null && mBackgroundAnimator.isRunning())) {
            return;
        }

        //背景动画
        mBackgroundAnimator = ObjectAnimator.ofFloat(mBackground, "alpha", mBackground.getAlpha(), 0f);
        mBackgroundAnimator.setDuration(ANIM_TIME);
        mBackgroundAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                PicViewActivity.super.finish();
                overridePendingTransition(0, 0);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        mBackgroundAnimator.start();

        //mask动画
        mImageView.zoomMaskTo(mThumbMaskRect, ANIM_TIME);

        //图片缩小动画
        mImageView.outerMatrixTo(mThumbImageMatrix, ANIM_TIME);
    }
}