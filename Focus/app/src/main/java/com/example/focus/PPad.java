package com.example.focus;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;

public class PPad extends RecyclerView.Adapter {

    ArrayList<String> pArray;
    ArrayList<Integer> eArray;
    ArrayList<Integer> sArray;
    ArrayList<ACT> AArray;
    Context context;


    public PPad(ArrayList<ACT> AArray,ArrayList<String> pArray,ArrayList<Integer> eArray,ArrayList<Integer> sArray, Context context) {
        this.AArray = AArray;
        this.pArray = pArray;
        this.eArray = eArray;
        this.sArray = sArray;
        this.context = context;

    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rvlayout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {

     //   ((ViewHolder) holder).name.setText("Your Activity was: "+pArray.get(position).toString());
   //     ((ViewHolder) holder).time.setText(eArray.get(position).toString()+":"+sArray.get(position).toString());
      //  ((ViewHolder) holder).sec.setText(":"+sArray.get(position).toString());

        ((ViewHolder) holder).name.setText("Your Activity was: "+AArray.get(position).getActi().toString());
           ((ViewHolder) holder).time.setText(AArray.get(position).min+":"+AArray.get(position).sec);



    }




    @Override
    public int getItemCount() {
        return pArray.size();
    }

public static class ViewHolder extends RecyclerView.ViewHolder {

    public TextView name;
    public TextView time;
    public TextView sec;
    public View view;


    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView;

        name = itemView.findViewById(R.id.textView);
        time = itemView.findViewById(R.id.textView3);
     //   sec = itemView.findViewById(R.id.textViews);


    }


}


}
