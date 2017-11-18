package com.bwie.shop_nsg.sort.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwie.shop_nsg.R;
import com.bwie.shop_nsg.sort.view.view.GoodsListActivity;
import com.bwie.shop_nsg.sort.bean.DateGridBean;

import java.util.List;


/**
 * Created by Administrator on 2017/10/20 0020.
 */

public class MyAdapter_TypeGridView extends BaseAdapter {
    private Context context;
    private List<DateGridBean.DatasBean.ClassListBean> list;

    public MyAdapter_TypeGridView(Context context, List<DateGridBean.DatasBean.ClassListBean> list){
        this.context = context;
        this.list = list;
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
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            convertView = View.inflate(context, R.layout.type_grid_item,null);
            holder = new ViewHolder();
            holder.tv = (TextView) convertView.findViewById(R.id.tv_gv_type);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv.setText(list.get(position).getGc_name());

        holder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                EventBus.getDefault().postSticky(new GoodsEvent(position));
                Intent intent = new Intent(context, GoodsListActivity.class);
//                intent.putExtra("position",position);
                context.startActivity(intent);
            }
        });

        return convertView;
    }
    class ViewHolder{
        TextView tv;
    }
}
