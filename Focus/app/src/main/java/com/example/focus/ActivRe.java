package com.example.focus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class ActivRe extends AppCompatActivity {
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activ_re);

        ArrayList<String> OO = new ArrayList<String>();
        ArrayList<Integer> EE = new ArrayList<Integer>();
        ArrayList<Integer> AA = new ArrayList<Integer>();


        Bundle get = getIntent().getExtras();

        String Name =get.getString("act");
        int min =get.getInt("min");
        int sec =get.getInt("sec");
        counter =get.getInt("co");

        ACT actN = new ACT(Name,sec,min);
        ArrayList<ACT> arr = new ArrayList<ACT>();

        if(counter == 1){
            ACT act = new ACT(Name,sec,min);
            arr.add(act);
        }
        else if(counter == 2){
            ACT act2 = new ACT(Name,sec,min);
            arr.add(act2);
        }

        OO.add(Name);
        EE.add(min);
        AA.add(sec);

        RecyclerView rv = findViewById(R.id.rec);
        rv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        rv.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);

        PPad ad = new PPad(arr,OO,EE,AA,this);


        rv.setAdapter(ad);





    }
}