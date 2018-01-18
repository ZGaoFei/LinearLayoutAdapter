package com.example.zhaogaofei.linearlayoutadapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhaogaofei.linearlayoutadapter.adapter.LinearLayoutAdapter;


public class TestAdapter extends LinearLayoutAdapter<TestModel> implements View.OnClickListener {
    private List<TestModel> mList;
    private Context mContext;

    public TestAdapter(List<TestModel> list, Context context) {
        super(list);
        this.mList = list;
        mContext = context;
    }

    @Override
    public View getView(List<TestModel> list, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_linear_layout, null);

        TestModel testModel = list.get(position);
        ImageView imageView = (ImageView) view.findViewById(R.id.item_image_view);
        TextView textView = (TextView) view.findViewById(R.id.item_text_view);

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
