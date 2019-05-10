package com.example.a22recyclecards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ExampleItem> exampleList;


    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private Button badd,bdelete;
    private EditText editTextAdd,editTextDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ExampleItem> exampleList=new ArrayList<>();

        exampleList.add(new ExampleItem(R.drawable.oner,"Clicked at Beach"));
        exampleList.add(new ExampleItem(R.drawable.twor,"Cycling"));
        exampleList.add(new ExampleItem(R.drawable.threer,"Clicked at Rome"));
        exampleList.add(new ExampleItem(R.drawable.fourr,"Clicked at India"));
        exampleList.add(new ExampleItem(R.drawable.fiver,"Clicked at UK"));
        exampleList.add(new ExampleItem(R.drawable.sixr,"Fruits"));


        // config for recycler view
        recyclerView= findViewById(R.id.recyclerView);

        //Performance
        recyclerView.setHasFixedSize(true);

        layoutManager= new LinearLayoutManager(this);
        adapter= new ExampleAdapter(exampleList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        // adapter is something which takes all the data and set something what you need inside in the data



        //find button
        badd=findViewById(R.id.buttonadd);
        bdelete=findViewById(R.id.buttondelete);
        //find EditText
        editTextAdd=findViewById(R.id.edittextadd);
        editTextDelete=findViewById(R.id.edittextdelete);

        badd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int position =Integer.parseInt(editTextAdd.getText().toString());
                AddCard(position);

            }
        });

        bdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               int position=Integer.parseInt(editTextDelete.getText().toString());
                DeleteCard(position);




            }
        });




    }


    public void AddCard(int position)
    {
        exampleList.add(position, new ExampleItem(R.drawable.oner,"New Card Added"));
            adapter.notifyDataSetChanged();
    //    adapter.notifyItemInserted(position);
    }

    public void DeleteCard(int position)
    {
        exampleList.remove(position);
        adapter.notifyDataSetChanged();
        //adapter.notifyItemRemoved(position);
    }


}

