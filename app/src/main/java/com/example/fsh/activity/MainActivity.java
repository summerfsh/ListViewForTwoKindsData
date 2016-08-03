package com.example.fsh.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.fsh.R;
import com.example.fsh.adapter.LvAdapter;
import com.example.fsh.bean.Adata;
import com.example.fsh.bean.Bdata;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Object> mAlist = null;
    private List<Object> mBlist = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lv = (ListView) findViewById(R.id.main_lv);
        LvAdapter adapter = new LvAdapter(this);
        // 初始化数据
        initAData();
        adapter.setData(mAlist);
//        initBData();
//        adapter.setData(mBlist);
        lv.setAdapter(adapter);
    }

    private void initAData() {
        mAlist = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Adata a = new Adata("A---" + i);
            mAlist.add(a);
        }
    }

    private void initBData() {
        mBlist = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Bdata b = new Bdata("B---" + i);
            mBlist.add(b);
        }
    }
}
