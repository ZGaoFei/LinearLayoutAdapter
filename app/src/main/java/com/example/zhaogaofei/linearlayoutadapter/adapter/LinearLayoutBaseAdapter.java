package com.example.zhaogaofei.linearlayoutadapter.adapter;


import java.util.List;

import android.view.View;
import android.widget.LinearLayout;

public interface LinearLayoutBaseAdapter<T> {
    void setLinearLayout(LinearLayout linearLayout);

    void setData(List<T> list);

    List<T> getData();

    void addData(T t);

    void updateData(List<T> list);

    void delete(int position);

    void clear();

    View getView(List<T> list, int position);
}
