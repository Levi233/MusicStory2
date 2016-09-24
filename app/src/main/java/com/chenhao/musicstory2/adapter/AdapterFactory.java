package com.chenhao.musicstory2.adapter;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.chenhao.musicstory2.bean.ItemViewType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenhao on 2016/8/24.
 */
public abstract class AdapterFactory<T> extends BaseAdapter {

    private Context mContext;
    private Handler mHandler;
    private List<SingleViewAdapter> mAdapters;

    public AdapterFactory(Context context, T t, Handler handler) {
        this.mContext = context;
        this.mHandler = handler;
        this.mAdapters = new ArrayList<SingleViewAdapter>();
        buildAdapters(t);
    }

    protected abstract void buildAdapters(T t);

    protected final void addAdapter(SingleViewAdapter adapter) {
        if (adapter != null) {
            // ----------------------
            mAdapters.add(adapter);
        }
    }

    public Context getContext() {
        return mContext;
    }

    public Handler getHandler() {
        return mHandler;
    }

    @Override
    public int getCount() {
        return mAdapters.size();
    }

    @Override
    public Object getItem(int i) {
        return mAdapters.get(i).getItem();
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return mAdapters.get(i).getView(i, view, viewGroup);
    }

    @Override
    public int getItemViewType(int position) {
        return mAdapters.get(position).getItemType();
    }

    @Override
    public int getViewTypeCount() {
        return ItemViewType.values().length;
    }
}
