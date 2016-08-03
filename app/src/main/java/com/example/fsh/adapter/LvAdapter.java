package com.example.fsh.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.fsh.R;
import com.example.fsh.bean.Adata;
import com.example.fsh.bean.Bdata;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fsh on 2016/8/3.
 */
public class LvAdapter extends BaseAdapter {
    private Context mContext;
    private List<Adata> mAdata = new ArrayList<>();
    private List<Bdata> mBdata = new ArrayList<>();

    public LvAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {
        int i = 0;
        if (mAdata.size() > 0) {
            i = mAdata.size();
        } else if (mBdata.size() > 0) {
            i = mBdata.size();
        }
        return i;
    }

    @Override
    public Object getItem(int i) {
        Object o = null;
        if (mAdata.size() > 0) {
            o = mAdata.get(i);
        } else if (mBdata.size() > 0) {
            o = mBdata.get(i);
        }
        return o;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.acy_item, null);
            viewHolder.tv_item = (TextView) view.findViewById(R.id.tv_item);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        if (mAdata.size() > 0) {
            viewHolder.tv_item.setText(mAdata.get(i).getName());
        } else if (mBdata.size() > 0) {
            viewHolder.tv_item.setText(mBdata.get(i).getTitle());
        }
        return view;
    }

    class ViewHolder {
        TextView tv_item;
    }

    public void setData(List<Object> o) {

        if (o.get(0) instanceof Adata) {
            for (int i = 0; i < o.size(); i++) {
                mAdata.add((Adata) o.get(i));
            }
        } else if (o.get(0) instanceof Bdata) {
            for (int i = 0; i < o.size(); i++) {
                mBdata.add((Bdata) o.get(i));
            }
        }
    }
}
