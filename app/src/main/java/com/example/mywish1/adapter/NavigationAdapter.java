package com.example.mywish1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mywish1.R;
import com.example.mywish1.interfaces.GetFragmentPosition;haloo

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.ViewHolder> {

    Context context;
    LinkedHashMap<Integer, String> naviData;
    GetFragmentPosition pos;

    public NavigationAdapter(Context context, LinkedHashMap<Integer, String> naviData, GetFragmentPosition position) {
        this.context = context;
        this.naviData = naviData;
        this.pos = position;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.item_drawer, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @NonNull
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        List<String> name = new ArrayList<String>(naviData.values());
        List<Integer> icon = new ArrayList<Integer>(naviData.keySet());
        holder.tvName.setText(name.get(position));
        holder.ivCon.setBackgroundResource(icon.get(position));
        holder.ll_navposition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pos.setitemposition(position);
            }
        });

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return naviData.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        ImageView ivCon;
        LinearLayout ll_navposition;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.txt_name);
            ivCon = itemView.findViewById(R.id.img_menu);
            ll_navposition = itemView.findViewById(R.id.ll_navposition);
        }
    }
}



