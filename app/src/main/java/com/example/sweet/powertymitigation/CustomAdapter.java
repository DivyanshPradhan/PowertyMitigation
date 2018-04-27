package com.example.sweet.powertymitigation;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    Context context;

    public CustomAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null)
        {
            view =  View.inflate(context,R.layout.item_layout,null);
            view.setTag(view);
        }
        else
        {
            view = (View) view.getTag();
        }
        TextView  title = (TextView)view.findViewById(R.id.item_title);
        TextView  subtitle = (TextView)view.findViewById(R.id.item_subtitle);
        title.setText(Home.title.get(i));
        subtitle.setText(Home.subtitle.get(i));
        return view;
    }

}
