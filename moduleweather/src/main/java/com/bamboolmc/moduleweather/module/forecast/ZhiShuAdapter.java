package com.bamboolmc.moduleweather.module.forecast;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bamboolmc.moduleweather.R;
import com.bamboolmc.moduleweather.util.ConstantUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by limc on 18/3/12.
 */
public class ZhiShuAdapter extends BaseAdapter {
    private List<WeatherMZEntity.IndexesBean> zhishuList = new ArrayList<>();
    private Activity context;

    public ZhiShuAdapter(List<WeatherMZEntity.IndexesBean> zhishuList, Activity context) {
        this.zhishuList = zhishuList;
        this.context = context;
    }


    @Override
    public int getCount() {
        return zhishuList.size();
    }

    @Override
    public Object getItem(int position) {
        return zhishuList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(context, R.layout.item_living_index_simple, null);
            holder.icon = (ImageView) convertView.findViewById(R.id.iv_icon);
            holder.name = (TextView) convertView.findViewById(R.id.tv_nameAndValue);
            holder.details = (TextView) convertView.findViewById(R.id.tv_details);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        WeatherMZEntity.IndexesBean zhishu = zhishuList.get(position);

        if (!ConstantUtil.ZHISHU.containsKey(zhishu.getName())){
            holder.icon.setImageResource(R.drawable.ic_liangshaizhishu_white);
        }else {
            holder.icon.setImageResource(ConstantUtil.ZHISHU.get(zhishu.getName()));
        }

        holder.name.setText(zhishu.getName());
        holder.details.setText(zhishu.getContent());

        return convertView;
    }


    public class ViewHolder {
        public TextView name;
        public TextView details;
        public ImageView icon;
    }
}
