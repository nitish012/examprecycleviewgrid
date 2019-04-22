package com.example.examprecycleviewgrid;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Programingadapter extends RecyclerView.Adapter<Programingadapter.Programingviewholder>{

    //private String[] data;
    private ArrayList<Student> datalist;

    public Programingadapter(ArrayList<Student> datalist){
        //passing data to adapter
        this.datalist=datalist;
    }

    @NonNull
    @Override
    public Programingviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //holding the views
        LayoutInflater inflater =LayoutInflater.from(viewGroup.getContext());
        View view=inflater.inflate(R.layout.list,viewGroup,false);
        return new Programingviewholder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull Programingviewholder programingviewholder, int i) {
        //binding data to particular position view
        Student title=datalist.get(i);
        programingviewholder.texttitle1.setText(title.name);
        programingviewholder.texttitle2.setText(String.valueOf(title.rollno));

    }

    @Override
    public int getItemCount() {

        //return size of data which is passed to adapter
        Log.i("adapter","size");
        return datalist.size();
    }


    public class Programingviewholder extends RecyclerView.ViewHolder {

        //returning the id of items

        TextView texttitle1;
        TextView texttitle2;

        public Programingviewholder(@NonNull View itemView) {
            super(itemView);
           // img=itemView.findViewById(R.id.img);
            texttitle1=itemView.findViewById(R.id.texttitle1);
            texttitle2=itemView.findViewById(R.id.texttitle2);
        }
    }
}
