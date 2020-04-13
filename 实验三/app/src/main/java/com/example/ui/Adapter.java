package com.example.ui;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Lenovo on 2020-03-27.
 */

public class Adapter extends BaseAdapter {
    List<Items> list;
    Context context;

    public Adapter(List<Items> list, Context context) {
        this.context = context;
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        class ViewHolder{
            TableRow tbr;
            TextView textView;
        }
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.am_items, null);
            viewHolder = new ViewHolder();
            viewHolder.tbr=(TableRow)convertView.findViewById(R.id.ambg);
            viewHolder.textView=(TextView)convertView.findViewById(R.id.number);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        int selected = Color.parseColor("#33B5E5");
        int unselected = Color.parseColor("#FAFAFA");
        viewHolder.textView.setText(list.get(position).getName());
        if(list.get(position).isChoose() == true){
            viewHolder.tbr.setBackgroundColor(selected);
        }
        else {
            viewHolder.tbr.setBackgroundColor(unselected);
        }
        return convertView;
    }
}
