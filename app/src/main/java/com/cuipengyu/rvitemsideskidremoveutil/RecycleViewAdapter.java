package com.cuipengyu.rvitemsideskidremoveutil;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

/**
 * Create by    ： 崔鹏宇
 * Time  is     ： 2018/4/13
 * Email        ： cuipengyusoul@gmail.com
 * Github       ： https://github.com/SolitarySoul
 * Instructions ：
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHodler> implements RvItemHelperInterface {
    List<Integer> mData;
    Context mContext;

    RecycleViewAdapter(Context context, List<Integer> data) {
        this.mContext = context;
        this.mData = data;
    }

    @Override
    public ViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
       ViewHodler viewHodler =new ViewHodler(LayoutInflater.from(mContext).inflate( R.layout.item_rv, parent,false));
        return viewHodler;
    }

    @Override
    public void onBindViewHolder(ViewHodler holder, final int position) {
        holder.contentTv.setText(String.valueOf(mData.get(position)));
        holder.deleteTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "delete onclick" + position, Toast.LENGTH_SHORT).show();
            }
        });

        holder.moreTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "moreTv onclick" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public void onItemMove(int fromPostion, int toPostion) {
        Collections.swap(mData, fromPostion, toPostion);
        notifyItemMoved(fromPostion, toPostion);
    }

    @Override
    public void onItemRemove(int postion) {

    }

    @Override
    public View getContentView(RecyclerView.ViewHolder holder) {
        ViewHodler messageHolder = (ViewHodler) holder;
        return messageHolder.contentTv;
    }

    @Override
    public int getMenuWidth(RecyclerView.ViewHolder holder) {
        ViewHodler messageHolder = (ViewHodler) holder;
        return messageHolder.moreTv.getWidth() + messageHolder.deleteTv.getWidth();
    }

    class ViewHodler extends RecyclerView.ViewHolder {
        public TextView contentTv;
        public TextView deleteTv;
        public TextView moreTv;

        public ViewHodler(View itemView) {
            super(itemView);
            contentTv = (TextView) itemView.findViewById(R.id.list_item);
            deleteTv = (TextView) itemView.findViewById(R.id.delete);
            moreTv = (TextView) itemView.findViewById(R.id.more);
        }
    }


}
