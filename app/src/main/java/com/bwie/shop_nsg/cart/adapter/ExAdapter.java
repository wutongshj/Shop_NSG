package com.bwie.shop_nsg.cart.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bwie.shop_nsg.R;
import com.bwie.shop_nsg.cart.bean.SearchCartBean;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by Administrator on 2017/11/17 0017.
 */

public class ExAdapter extends BaseExpandableListAdapter {

    SearchCartBean bean;
    Context context;


    public ExAdapter(SearchCartBean bean, Context context) {
        this.bean = bean;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return bean.getData().size();
    }

    @Override
    public int getChildrenCount(int i) {
        return bean.getData().get(i).getList().size();
    }

    @Override
    public Object getGroup(int i) {
        return bean.getData().get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return bean.getData().get(i).getList().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        MyGroup group;
        if(view==null){
            view= LayoutInflater.from(context).inflate(R.layout.car_item_group,null);
            group = new MyGroup();
            group.groupcheck= (CheckBox) view.findViewById(R.id.group_check);
            group.groupname= (TextView) view.findViewById(R.id.group_name);
//            group.groupbtn= (Button) view.findViewById(R.id.group_edtor);
            view.setTag(group);
        }else {
            group= (MyGroup) view.getTag();
        }
        group.groupcheck.setChecked(bean.getData().get(i).isSelected());
        group.groupname.setText(bean.getData().get(i).getSellerName());

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        MyChild child;
        if (view==null){
            view=LayoutInflater.from(context).inflate(R.layout.car_item_child, null);
            child = new MyChild();
            child.childname= (TextView) view.findViewById(R.id.child_name);
            child.childcheck= (CheckBox) view.findViewById(R.id.child_check);
            child.childprice= (TextView) view.findViewById(R.id.child_price);
            child.img= (SimpleDraweeView) view.findViewById(R.id.child_img);
            view.setTag(child);
        }else {
            child= (MyChild) view.getTag();
        }

        Log.d("child",bean.getData().get(i).getList().get(i1).getTitle());
        child.childname.setText(bean.getData().get(i).getList().get(i1).getTitle());
        child.childprice.setText("价格："+bean.getData().get(i).getList().get(i1).getPrice()+"");
        child.childcheck.setChecked(bean.getData().get(i).getList().get(i1).isChildSelected());
        String images = bean.getData().get(i).getList().get(i1).getImages();
        String[] split = images.split("\\|");
        child.img.setImageURI(split[0]);

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

    class MyGroup{
        CheckBox groupcheck;
        TextView groupname;
//        Button groupbtn;
    }

    class MyChild{
        CheckBox childcheck;
        TextView childname,childprice;
        SimpleDraweeView img;
    }
}
