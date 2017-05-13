package com.bamboolmc.zhiqu.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.bamboolmc.zhiqu.R;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

/**
 * Created by limc on 17/5/8.
 */
public class PicassoImage extends ImageView {

    private final String LOG_TAG = PicassoImage.class.getSimpleName();
    //    private PicassoHandler mPicassoHandler;
    private boolean mAutoFade = true;
    private boolean mAvatarMode = false;

    public PicassoImage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setAutoFade(boolean autoFade) {
        mAutoFade = autoFade;
    }

    public void setAvatarMode(boolean avatarMode) {
        mAvatarMode = avatarMode;
    }

    public void setImage(String url) {

    }

    public void setImage(String url, Listener listener) {
        if (!(url == null || url.length() == 0)) {
//            setPicassoHandler(new PhotoHandler(url, listener));
        } else {
            reset();
            setImageResourceImpl(R.mipmap.ic_launcher);
        }
    }
    
    private void reset() {
        setPicassoHandler(null);
        setImageDrawable(null);
    }

    private void setPicassoHandler(PicassoHandler handler) {
        /*if (mPicassoHandler != null && mPicassoHandler.isStarted()
                && !mPicassoHandler.isFinished()) {
            Picasso.with(getContext()).cancelRequest(mPicassoTarget);
        }

        if (handler != null && Objects.equal(handler, mPicassoHandler)) {
            handler.setDisplayPlaceholder(false);
        }

        mPicassoHandler = handler;

        if (handler != null && canLoadImage()) {
            loadUrlImmediate();
        }*/
    }
    

    private static  class PicassoHandler {

        private final String mObject;
        private final Listener mCallback;
        private boolean mIsStarted, mIsFinished;
        private boolean mDisplayPlaceholder = true;

        PicassoHandler(String object, Listener callback) {
            mObject = Preconditions.checkNotNull(object, "object cannot be null");
            mCallback = callback;
        }

        final String getUrl(ImageView imageView) {
            return buildUrl(mObject, imageView);
        }

        protected  String buildUrl(String object, ImageView imageView){
            return object;
        };

        void markAsStarted() {
            mIsStarted = true;
        }

        void markAsFinished() {
            mIsFinished = true;
        }

        boolean isStarted() {
            return mIsStarted;
        }

        boolean isFinished() {
            return mIsFinished;
        }

        int getPlaceholderDrawable() {
            return 0;
        }

        void setDisplayPlaceholder(boolean displayPlaceholder) {
            mDisplayPlaceholder = displayPlaceholder;
        }

        boolean shouldDisplayPlaceholder() {
            return mDisplayPlaceholder;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PicassoHandler that = (PicassoHandler) o;
            return Objects.equal(mObject, that.mObject);
        }

        boolean centerCrop() {
            return true;
        }

        @Override
        public int hashCode() {
            return mObject != null ? mObject.hashCode() : 0;
        }
    }

    

    void setImageResourceImpl(int resId) {
        if (mAvatarMode) {
            BitmapDrawable d = (BitmapDrawable) getResources().getDrawable(resId);
            setImageDrawable(new RoundedAvatarDrawable(d.getBitmap()));
        } else {
            setImageResource(resId);
        }
    }

    public interface Listener {

        void onSuccess(PicassoImage imageView, Bitmap bitmap);

        void onError(PicassoImage imageView);
    }

}
