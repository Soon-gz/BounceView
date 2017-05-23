package com.example.administrator.bounceview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ShuWen on 2017/5/23.
 */

public abstract class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private List list;

    public MyAdapter(Context context, List list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(ItemLayoutId(),null,false);
        return new MyViewHolder(view);
    }

    protected abstract int ItemLayoutId();

    protected abstract void onBindHolder(MyAdapter.MyViewHolder myViewHolder, int position);

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder myViewHolder, int position) {
        onBindHolder(myViewHolder, position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder{

        View view;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
        }

        public TextView getTextView(int resId){
            return (TextView) view.findViewById(resId);
        }
    }
}
