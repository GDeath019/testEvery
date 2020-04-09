package com.example.testeverything;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class shopAdapter extends RecyclerView.Adapter<shopAdapter.ViewHolder>{
    ArrayList<dataShop> DataShop;
    Context context;

    public shopAdapter(ArrayList<dataShop> dataShop, Context context) {
        DataShop = dataShop;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_row,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtName.setText(DataShop.get(position).getTen());
        holder.imgHinh.setImageResource(DataShop.get(position).getHinhAnh());
    }

    @Override
    public int getItemCount() {
        return DataShop.size();
    }
    public void RemoveItems(int position){
        DataShop.remove(position);
        notifyItemRemoved(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtName;
        ImageView imgHinh;
        public ViewHolder(View itemView){
            super(itemView);
            txtName = (TextView)itemView.findViewById(R.id.textView2);
            imgHinh = (ImageView)itemView.findViewById(R.id.imageView2);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    RemoveItems(getAdapterPosition());
                }
            });
        }
    }
}
