package com.bamboolmc.zhiqu.base;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * author: cheikh.wang on 16/11/23
 * email: wanghonghi@126.com
 * loadmorewrapperadapter
 */
public abstract class BaseAdapter<T> extends RecyclerView.Adapter implements IAdapter<T> {

    private List<T> mItems;
    protected OnItemClickListener mOnItemClickListener;
    protected OnItemLongClickListener mOnItemLongClickListener;


    public BaseAdapter() {
        mItems = new ArrayList<>();
    }

    @Override
    public void setItems(List<T> items) {
        mItems.clear();
        mItems.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public void addItems(List<T> items) {
        mItems.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public void addItem(T item) {
        mItems.add(item);
        notifyDataSetChanged();
    }

    @Override
    public void delItem(T item) {
        mItems.remove(item);
        notifyDataSetChanged();
    }

    @Override
    public void clearItems() {
        mItems.clear();
        notifyDataSetChanged();
    }

    @Override
    public T getItem(int position) {
        return mItems.get(position);
    }

//以上继承自Iadapter    -------------------------

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mItems != null ? mItems.size() : 0;
    }


    @Override
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(getViewLayoutId(viewType), parent, false);

        final RecyclerView.ViewHolder viewHolder = createViewHolder(view, viewType);

        //item点击事件,短点击
        if (mOnItemClickListener != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(viewHolder.getAdapterPosition());
                }
            });
        }

        //item长点击事件
        if (mOnItemLongClickListener != null) {
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener(){
                @Override
                public boolean onLongClick(View v) {
                    return mOnItemLongClickListener.onItemLongClick(viewHolder.getAdapterPosition());
                }
            });
        }

        return viewHolder;
    }


    @Override
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof IViewHolder) {
            IViewHolder<T> holder = (IViewHolder) viewHolder;
            holder.setItem(getItem(position));
            holder.setPosition(position);
        }
        bindViewHolder(viewHolder, getItem(position), position);
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public interface OnItemLongClickListener {
        boolean onItemLongClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public abstract int getViewLayoutId(int viewType);

    public abstract RecyclerView.ViewHolder createViewHolder(View view, int viewType);

    public abstract void bindViewHolder(RecyclerView.ViewHolder holder, T item, int position);

}
