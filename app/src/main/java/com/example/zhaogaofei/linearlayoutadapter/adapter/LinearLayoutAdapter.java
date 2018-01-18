package com.example.zhaogaofei.linearlayoutadapter.adapter;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.view.View;
import android.widget.LinearLayout;

public abstract class LinearLayoutAdapter<T> implements LinearLayoutBaseAdapter<T> {

    private LinearLayout mLinearLayout;
    private List<T> mList;

    public LinearLayoutAdapter(List<T> list) {
        if (list != null && !list.isEmpty()) {
            mList = list;
        } else {
            mList = new ArrayList<>();
        }
    }

    @Override
    public void setLinearLayout(LinearLayout linearLayout) {
        mLinearLayout = linearLayout;
        notifyDataSetChanged();
    }

    @Override
    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            clear();
            mList.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override
    public List<T> getData() {
        return mList;
    }

    @Override
    public void addData(T t) {
        if (t != null) {
            mList.add(t);
            View view = getView(mList, mList.size() - 1);
            mLinearLayout.addView(view);
        }
    }

    @Override
    public void updateData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            if (getCount() < size) {
                return;
            }

            Collections.copy(mList, list);
            mLinearLayout.removeAllViews();
            notifyDataSetChanged();
        }
    }

    @Override
    public void delete(int position) {
        if (position > getCount() - 1) {
            return;
        }
        mList.remove(position);
        mLinearLayout.removeAllViews();

        notifyDataSetChanged();
    }

    @Override
    public void clear() {
        if (mList != null && !mList.isEmpty()) {
            mList.clear();
        }
        mLinearLayout.removeAllViews();
    }

    public void notifyDataSetChanged() {
        for (int i = 0; i < mList.size(); i++) {
            View view = getView(mList, i);
            mLinearLayout.addView(view);
        }
    }

    public int getCount() {
        return mLinearLayout.getChildCount();
    }
}
