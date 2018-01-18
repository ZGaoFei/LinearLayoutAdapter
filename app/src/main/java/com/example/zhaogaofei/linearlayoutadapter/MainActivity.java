package com.example.zhaogaofei.linearlayoutadapter;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * 尝试多种type类型，是否支持
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout mLinearLayout;
    private Button mBtAdd;
    private Button mBtDelete;
    private Button mBtUpdate;
    private Button mBtClear;
    private EditText mEditDelete;

    private List<TestModel> mList;
    private MyAdapter mMyAdapter;
    private TestAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    private void initView() {
        mBtAdd = (Button) findViewById(R.id.bt_add);
        mBtDelete = (Button) findViewById(R.id.bt_delete);
        mBtUpdate = (Button) findViewById(R.id.bt_update);
        mBtClear = (Button) findViewById(R.id.bt_clear);
        mBtAdd.setOnClickListener(this);
        mBtDelete.setOnClickListener(this);
        mBtUpdate.setOnClickListener(this);
        mBtClear.setOnClickListener(this);

        mEditDelete = (EditText) findViewById(R.id.edit_delete);

        mLinearLayout = (LinearLayout) findViewById(R.id.linear_layout);
    }

    private void initData() {
        mList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mList.add(new TestModel("", "item: " + i));
        }

//        mMyAdapter = new MyAdapter(mLinearLayout);
//        mMyAdapter.setData(mList);

        mAdapter = new TestAdapter(mList, this);
        mAdapter.setLinearLayout(mLinearLayout);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_add:
//                mMyAdapter.addData(new TestModel("", "add"));

                mAdapter.addData(new TestModel("", "add"));
                break;
            case R.id.bt_delete:
//                mMyAdapter.delete(0);

                String deleteP = mEditDelete.getText().toString().trim();
                mAdapter.delete(Integer.parseInt(deleteP));
                break;
            case R.id.bt_update:
                List<TestModel> list = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    list.add(new TestModel("", "hello world:" + i));
                }

//                mMyAdapter.updateData(list);
                mAdapter.updateData(list);
                break;
            case R.id.bt_clear:
//                mMyAdapter.clear();

                mAdapter.clear();
                break;
        }
    }
}
