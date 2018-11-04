package com.example.maary.project05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    private ImageSwitcher mImageSwitcher;
    private Button buttonNext;

    int imageId[]={
            R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5
    };
    int count=imageId.length;
    int currentIndex= -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageSwitcher=(ImageSwitcher)findViewById(R.id.imageSwitcher);
        buttonNext=(Button)findViewById(R.id.buttonNext);
        mImageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT));
                return imageView;
            }
        });

        Animation in = AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right);

        mImageSwitcher.setInAnimation(in);
        mImageSwitcher.setOutAnimation(out);

        buttonNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                currentIndex++;
                if(currentIndex == count)
                    currentIndex = 0;
                mImageSwitcher.setImageResource(imageId[currentIndex]);
            }
        });

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
            }
        });



    }
}
