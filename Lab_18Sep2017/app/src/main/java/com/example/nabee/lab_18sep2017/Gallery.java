package com.example.nabee.lab_18sep2017;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;

public class Gallery extends AppCompatActivity {



    int imageId;
    String imageDes;
    ImageView iv1,iv2,iv3,iv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        iv1=(ImageView)findViewById(R.id.imageView);
        iv2=(ImageView)findViewById(R.id.imageView2);
        iv3=(ImageView)findViewById(R.id.imageView3);
        iv4=(ImageView)findViewById(R.id.imageView4);

        imageId=R.drawable.image5;
        imageDes="It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.";
    }

    private void UnselectAllImages()
    {
        iv1.setAlpha(0.5f);
        iv2.setAlpha(0.5f);
        iv3.setAlpha(0.5f);
        iv4.setAlpha(0.5f);
    }


    public void ShowDetailView(View view)
    {
        UnselectAllImages();
        switch (view.getId()) {
            case R.id.imageView:
                imageId=R.drawable.image5;
                imageDes="It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.";
                iv1.setAlpha(1f);
                break;
            case R.id.imageView2:
                imageId=R.drawable.image6;
                imageDes="It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.";
                iv2.setAlpha(1f);

                break;
            case R.id.imageView3:
                imageId=R.drawable.image7;
                imageDes="It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.";
                iv3.setAlpha(1f);

                break;
            case R.id.imageView4:
                imageId=R.drawable.image8;
                imageDes="It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.";
                iv4.setAlpha(1f);

                break;
        }
    }

    public void SetBackGround(View view)
    {
        Intent intent = new Intent(this, ImageDetail.class);
        intent.putExtra("Image", imageId);
        intent.putExtra("Description", imageDes);
        startActivity(intent);
    }
}
