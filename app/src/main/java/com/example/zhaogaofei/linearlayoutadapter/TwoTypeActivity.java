package com.example.zhaogaofei.linearlayoutadapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class TwoTypeActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout mLinearLayout;
    private Button mBtAdd;
    private Button mBtDelete;
    private Button mBtUpdate;
    private Button mBtClear;

    private List<TestTwoModel> mList;
    private TwoTypeAdapter mAdapter;

    public static void start(Context context) {
        context.startActivity(new Intent(context, TwoTypeActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_type);

        initView();
        initData();
    }

    private void initView() {
        mBtAdd = (Button) findViewById(R.id.bt_add_two_type);
        mBtDelete = (Button) findViewById(R.id.bt_delete_two_type);
        mBtUpdate = (Button) findViewById(R.id.bt_update_two_type);
        mBtClear = (Button) findViewById(R.id.bt_clear_two_type);
        mBtAdd.setOnClickListener(this);
        mBtDelete.setOnClickListener(this);
        mBtUpdate.setOnClickListener(this);
        mBtClear.setOnClickListener(this);

        mLinearLayout = (LinearLayout) findViewById(R.id.linear_layout_two_type);
    }

    private void initData() {
        mList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mList.add(new TestTwoModel(0, "", "item: " + i));
        }

        mAdapter = new TwoTypeAdapter(mList, this);
        mAdapter.setLinearLayout(mLinearLayout);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_add_two_type:
                mAdapter.addData(new TestTwoModel(1, "", "add"));
                break;
            case R.id.bt_delete_two_type:
                mAdapter.delete(0);
                break;
            case R.id.bt_update_two_type:
                List<TestTwoModel> list = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    list.add(new TestTwoModel(0, "", "hello world:" + i));
                }

                mAdapter.updateData(list);
                break;
            case R.id.bt_clear_two_type:
                mAdapter.clear();
                break;
        }
    }
}
