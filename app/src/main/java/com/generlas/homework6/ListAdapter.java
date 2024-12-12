package com.generlas.homework6;

import android.text.Layout;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private final List<Things> dataList;
    private OnItemClikListener itemClikListener;

    public ListAdapter(List<Things> dataList,OnItemClikListener listener) {
        this.dataList = dataList;
        itemClikListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int ViewType) {
        //绑定视图
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,int position) {
        Things things = dataList.get(position);
        holder.nameView.setText(things.name);
        holder.messageView.setText(things.message);

        //点击事件
        holder.listView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Things things = dataList.get(position);
                Toast.makeText(v.getContext(),"修改第" + (position + 1) + "个消息",Toast.LENGTH_SHORT).show();
                if(itemClikListener != null) {
                    itemClikListener.OnItemClick(position);
                }
            }
        });
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,int position,@NonNull List<Object> payloads) {
        if(!payloads.isEmpty()) {
            for(Object payload : payloads) {
                if(payload instanceof String) {
                    holder.messageView.setText((String) payload);
                }
            }
        }
        else {
            super.onBindViewHolder(holder,position,payloads);
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View listView;
        TextView nameView;
        TextView messageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            listView = itemView;
            nameView = itemView.findViewById(R.id.item_tv_name);
            messageView = itemView.findViewById(R.id.item_tv_messsage);
        }
    }
}
