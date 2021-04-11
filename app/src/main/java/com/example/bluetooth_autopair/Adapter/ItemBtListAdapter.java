package com.example.bluetooth_autopair.Adapter;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.example.bluetooth_autopair.Bean.BlueToothBean;
import com.example.bluetooth_autopair.R;

import java.util.List;

public class ItemBtListAdapter extends BaseAdapter {

    private List<BlueToothBean> objects;
    private Context context;
    private LayoutInflater layoutInflater;

    public ItemBtListAdapter(List<BlueToothBean> objects, Context context) {
        this.objects = objects;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public BlueToothBean getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_bt_list, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews(getItem(position), (ViewHolder) convertView.getTag(), position);
        return convertView;
    }

    private void initializeViews(BlueToothBean object, ViewHolder holder, int position) {
        if (position % 2 == 0)
            holder.layoutItem.setCardBackgroundColor(Color.parseColor("#EF9A9A"));
        else
            holder.layoutItem.setCardBackgroundColor(Color.parseColor("#9FA8DA"));
        holder.tvBtName.setText(object.getName());
        holder.tvBtMac.setText(object.getMac());
    }

    protected class ViewHolder {
        private CardView layoutItem;
        private TextView tvBtName;
        private TextView tvBtMac;

        public ViewHolder(View view) {
            layoutItem = view.findViewById(R.id.layout_item);
            tvBtName = view.findViewById(R.id.tv_bt_name);
            tvBtMac = view.findViewById(R.id.tv_bt_mac);
        }
    }
}
