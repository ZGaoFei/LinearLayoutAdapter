package com.example.zhaogaofei.linearlayoutadapter;


import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhaogaofei.linearlayoutadapter.adapter.LinearLayoutAdapter;

/**
 * 测试多种类型的item
 */
public class TwoTypeAdapter extends LinearLayoutAdapter<TestTwoModel> implements View.OnClickListener {
    private Context mContext;

    public TwoTypeAdapter(List<TestTwoModel> list, Context context) {
        super(list);
        mContext = context;
    }

    @Override
    public View getView(List<TestTwoModel> list, int position) {
        View view;
        int type = list.get(position).getType();
        if (type == 0) {
            view = inflateOneView(list, position);
        } else {
            view = inflateTwoView(list, position);
        }
        return view;
    }

    private View inflateOneView(List<TestTwoModel> list, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_linear_layout, null);

        TestTwoModel testModel = list.get(position);
        ImageView imageView = (ImageView) view.findViewById(R.id.item_image_view);
        TextView textView = (TextView) view.findViewById(R.id.item_text_view);

        textView.setText(testModel.getText());
        textView.setTag(position);
        textView.setOnClickListener(this);

        return view;
    }

    private View inflateTwoView(List<TestTwoModel> list, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_two_type, null);

        TestTwoModel testModel = list.get(position);
        ImageView imageView = (ImageView) view.findViewById(R.id.item_image_view_two);
        TextView textView = (TextView) view.findViewById(R.id.item_text_view_two);

        textView.setText(testModel.getText());
        textView.setTag(position);
        textView.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        int position = (int) view.getTag();
        Toast.makeText(mContext, "position=" + position, Toast.LENGTH_SHORT).show();
    }
}
