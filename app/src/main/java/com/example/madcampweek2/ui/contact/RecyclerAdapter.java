package com.example.madcampweek2.ui.contact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.madcampweek2.R;
import com.example.madcampweek2.model.Contact;

import java.util.ArrayList;
import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder> {

    // Data(Contact class) list for adapter
    private List<Contact> listData = new ArrayList<>();
    private Context adapterContext;
    AdapterView.OnItemLongClickListener onItemLongClickListener;

    public RecyclerAdapter(Context adapterContext, AdapterView.OnItemLongClickListener onItemLongClickListener){
        this.adapterContext = adapterContext;
        this.onItemLongClickListener = onItemLongClickListener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflate contact.xml via LayoutInflater
        // return ViewHolder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item,
                parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.onBind(listData.get(position));
    }

    @Override
    public int getItemCount() {
        // RecyclerView Item number
        return listData.size();
    }

    public Contact getItem(int pos){
        return listData.get(pos);
    }

    void addItem(Contact data) {
        listData.add(data);
    }

    void setData(List<Contact> newData){
        listData = newData;
        notifyDataSetChanged();
    }

    // ViewHolder of RecyclerView
    // Setting subViews consisting the ItemView
    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textView1;
        private TextView textView2;
        private ImageView imageView;

        ItemViewHolder(View itemView) {
            super(itemView);

            textView1 = itemView.findViewById(R.id.name);
            textView2 = itemView.findViewById(R.id.phone);
            imageView = itemView.findViewById(R.id.profile);

            imageView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onItemLongClickListener.onItemLongClick(null, view, getAdapterPosition(), view.getId());
        }

        void onBind(Contact data) {
            textView1.setText(data.getName());
            textView2.setText(data.getPhoneNumber());
//            imageView.setImageResource(R.drawable.angmond);
//
            Glide.with(adapterContext)
                .load("http://192.249.19.240:3080/api/images/get/scappy.png")
                .into(imageView);
        }


    }
}