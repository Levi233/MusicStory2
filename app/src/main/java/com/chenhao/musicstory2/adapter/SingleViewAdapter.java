package com.chenhao.musicstory2.adapter;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by chenhao on 2016/8/24.
 */
public abstract class SingleViewAdapter<T>{

    private Context mContext;
    private T mItem;
    private int mItemType;
    private Handler mHandler;
    private LayoutInflater mInflater;

    public SingleViewAdapter(Context context, T t, int type, Handler handler) {
        this.mContext = context;
        this.mItem = t;
        this.mItemType = type;
        this.mHandler = handler;
        this.mInflater = LayoutInflater.from(context);
    }

    public T getItem() {
        return mItem;
    }

    public Context getContext(){
        return mContext;
    }

    public int getItemType(){
        return  mItemType;
    }

    public LayoutInflater getLayoutInflater(){
        return mInflater;
    }

    public Handler getHandler(){
        return mHandler;
    }
    public abstract View getView(int position, View convertView, ViewGroup parent);
}
