package com.example.readjson_demo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class JSONADAPTOR extends RecyclerView.Adapter<JSONADAPTOR.JSONVIEW> {

    private ArrayList<classViewJSON> classViewJSONS;

    classViewJSON nameclassViewJSON;
    public JSONADAPTOR(ArrayList<classViewJSON> classViewJSONS) {
        this.classViewJSONS = classViewJSONS;
    }

    @NonNull
    @Override
    public JSONVIEW onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view= layoutInflater.inflate(R.layout.unit_json,null);
        return new JSONVIEW(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JSONVIEW holder, int position) {
        nameclassViewJSON=classViewJSONS.get(position);
        holder.name.setText(nameclassViewJSON.getName());

    }

    @Override
    public int getItemCount() {
        return classViewJSONS!=null? classViewJSONS.size():0;
    }

    class  JSONVIEW extends  RecyclerView.ViewHolder
    {

        TextView name;
        public JSONVIEW(@NonNull View itemView) {
            super(itemView);
            name= itemView.findViewById(R.id.unit_name_item);
        }
    }
}
