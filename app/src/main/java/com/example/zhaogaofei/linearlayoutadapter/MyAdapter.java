package com.example.zhaogaofei.linearlayoutadapter;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyAdapter {
    private LinearLayout mLinearLayout;
    private Context mContext;

    private List<TestModel> mList;

    public MyAdapter(LinearLayout linearLayout) {
        mLinearLayout = linearLayout;
        mContext = linearLayout.getContext();

        mList = new ArrayList<>();
    }

    public void setData(List<TestModel> list) {
        if (list != null && !list.isEmpty()) {
            clear();
            mList.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void updateData(List<TestModel> list) {
        if (list != null && !list.isEmpty()) {
            Collections.copy(mList, list);
            mLinearLayout.removeAllViews();
            notifyDataSetChanged();
        }
    }

    public void addData(TestModel entity) {
        if (entity != null) {
            mList.add(entity);
            View view = getView(mList.size() - 1);
            mLinearLayout.addView(view);
        }
    }

    public List<TestModel> getData() {
        return mList;
    }

    public void delete(int position) {
        mList.remove(position);
        mLinearLayout.removeViewAt(position);
    }

    public void clear() {
        if (mList != null && !mList.isEmpty()) {
            mList.clear();
        }
        mLinearLayout.removeAllViews();
    }

    private void updateTag() {
        int childCount = mLinearLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = mLinearLayout.getChildAt(i);
            setTag(view, i);
        }
    }

    private void setTag(View view, int position) {

    }

    public void notifyDataSetChanged() {
        for (int i = 0; i < mList.size(); i++) {
            View view = getView(i);
            mLinearLayout.addView(view);
        }
    }

    private View getView(int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_linear_layout, null);

        TestModel testModel = mList.get(position);
        ImageView imageView = (ImageView) view.findViewById(R.id.item_image_view);
        TextView textView = (TextView) view.findViewById(R.id.item_text_view);

        textView.setText(testModel.getText());

        return view;
    }
}
