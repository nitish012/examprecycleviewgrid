package com.example.examprecycleviewgrid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int i,position;
   private Button button,buttonupdate;
    private RecyclerView programinglist;
   private String item;
    private int insertIndex;
    private Programingadapter p;
    ArrayList<Student> datalist=new ArrayList<Student>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        programinglist=findViewById(R.id.programinglist);
        button=findViewById(R.id.button);
        buttonupdate=findViewById(R.id.btnupdate);


        //programinglist.setLayoutManager(new GridLayoutManager(this,2));


        //String[] attributes={"color","name","age","height"};


       // programinglist.setAdapter(new Programingadapter(attributes));
//        ArrayList<String> datalist=new ArrayList<String>();
//        for(int i=0;i<100;i++){
//            datalist.add(":harsh");
//            datalist.add("rollno:13name2");
//        }


        for(i=0;i<100;i++){

            datalist.add(new Student("name:harish",i));
        }
        setlayout();
        settingadapter();
       buttonlistener();
       buttonupdatelistener();
    }

    private void setlayout(){
        //setting layoutmanager

        programinglist.setLayoutManager(new GridLayoutManager(this,2));
    }

    private void settingadapter(){
//passing data to adapter
        p=new Programingadapter(datalist);
        programinglist.setAdapter(p);
    }


    private void buttonlistener(){

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                programinglist.setLayoutManager(new GridLayoutManager(MainActivity.this, 3));

            }
        });

    }

    private void buttonupdatelistener(){


        buttonupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                datalist.set(2,new Student("Name :pig",5));
                // p.notifyDataSetChanged();
                p.notifyItemChanged(2);
            }
        });

    }
}
