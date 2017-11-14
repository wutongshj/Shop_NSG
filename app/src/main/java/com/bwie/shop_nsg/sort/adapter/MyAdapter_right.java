package com.bwie.shop_nsg.sort.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.bwie.shop_nsg.R;
import com.bwie.shop_nsg.sort.bean.DatarightBean;
import com.bwie.shop_nsg.sort.bean.DateGridBean;
import com.bwie.shop_nsg.sort.model.UserModel;

import java.util.List;

/**
 * Created by Administrator on 2017/10/20 0020.
 */

public class MyAdapter_right extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private DatarightBean list;
    private MyLeftViewHolder myHolder;


    public MyAdapter_right(Context context, DatarightBean list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.typeson_item, parent, false);
        final MyLeftViewHolder leftViewHolder = new MyLeftViewHolder(view);
        return leftViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        //设置种类标题
        myHolder = new MyLeftViewHolder(holder.itemView);
        List<DatarightBean.DatasBean.ClassListBean> class_list = list.getDatas().getClass_list();
        //设置标题
        myHolder.tv_left_type.setText(class_list.get(position).getGc_name());

        UserModel userModel = new UserModel();
        userModel.getgridmessage(list.getDatas().getClass_list().get(position).getGc_id(), new UserModel.Grid_Finish() {
            @Override
            public void sortgridmessage(DateGridBean gridbean) {
                Log.d("maingridbean",gridbean.getDatas().getClass_list().get(position).getGc_name());
                myHolder.gv.setAdapter(new MyAdapter_TypeGridView(context,gridbean.getDatas().getClass_list()));
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.getDatas().getClass_list().size();
    }


    public class MyLeftViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_left_type;
        private GridView gv;
        public MyLeftViewHolder(View itemView) {
            super(itemView);
            tv_left_type = (TextView) itemView.findViewById(R.id.tv_type);
            gv = (GridView) itemView.findViewById(R.id.type_son);
        }
    }

    //声明成员变量
    public OnRecycleViewItemClickListener recycleViewItemClickListener;

    //定义点击接口
    public interface OnRecycleViewItemClickListener{
        void recycleViewItemClickListener(int position, View view, RecyclerView.ViewHolder viewHolder);
    }

    //提供set方法
    public void setRecycleViewItemClickListener(OnRecycleViewItemClickListener recycleViewItemClickListener) {
        this.recycleViewItemClickListener = recycleViewItemClickListener;
    }
}
