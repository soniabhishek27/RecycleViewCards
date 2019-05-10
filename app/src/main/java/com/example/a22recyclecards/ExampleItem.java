package com.example.a22recyclecards;

public class ExampleItem {


    private  int mImageResource;
    private  String mText;

    public ExampleItem(int imageResource,String text)
    {
        mImageResource=imageResource;
        mText=text;

    }

    public int getmImageResource() {
        return mImageResource;
    }

    public String getmText() {
        return mText;
    }
}
