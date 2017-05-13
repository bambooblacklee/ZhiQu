package com.bamboolmc.zhiqu.base;

import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.StringRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import butterknife.ButterKnife;

/**
 * author：cheikh.wang on 16/10/21 23:33
 * email：wanghonghi@126.com
 */
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder implements IViewHolder<T> {

    protected T mItem;
    protected int mPosition;

    public BaseViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, itemView);
    }


    @Override
    public void setItem(T item) {
        mItem = item;
    }

    @Override
    public void setPosition(int position) {
        mPosition = position;
    }



    protected String getString(@StringRes int strResId) {
        return itemView.getContext().getString(strResId);
    }

    protected String getString(@StringRes int stringResId, Object... formatArgs) {
        return itemView.getContext().getResources().getString(stringResId, formatArgs);
    }

    @ColorInt
    protected int getColor(@ColorRes int colorResId) {
        return itemView.getContext().getResources().getColor(colorResId);
    }
}
