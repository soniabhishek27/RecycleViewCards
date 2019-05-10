package com.example.a22recyclecards;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    //6.2
    public ArrayList<ExampleItem> mExampleList;



    // step1 create a class
    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        //4
        public ImageView imageView;
        public TextView textView;


        //step 2
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);

            //4
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);


        }
    }

    //step 6.1
    public ExampleAdapter(ArrayList<ExampleItem> exampleList)
    {
        mExampleList = exampleList; //inorder to know how many items are generated
    }

    //step 3 generate these methods
    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        //step 5 all customization

       View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.mycard,parent,false);
       ExampleViewHolder exampleViewHolder= new ExampleViewHolder(view);
       return exampleViewHolder;

    }


    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder exampleViewHolder, int position) {
    //step 7
        ExampleItem currentItem=mExampleList.get(position);
        exampleViewHolder.imageView.setImageResource(currentItem.getmImageResource());
        exampleViewHolder.textView.setText(currentItem.getmText());
    }


    @Override
    public int getItemCount() {
        return mExampleList.size();
    }



}
