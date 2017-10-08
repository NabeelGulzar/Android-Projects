package com.example.nabee.lab_18sep2017;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ImageList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_list);
    }

//    public void ShowDetailView(View view)
//    {
//        Intent intent=new Intent(this,ImageDetail.class);
//        switch (view.getId())
//        {
//            case R.id.imageView:
//                intent.putExtra("Image",R.drawable.image5);
//                intent.putExtra("Description","It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.");
//                break;
//            case R.id.imageView2:
//                intent.putExtra("Image",R.drawable.image6);
//                intent.putExtra("Description","It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.");
//                break;
//            case R.id.imageView3:
//                intent.putExtra("Image",R.drawable.image7);
//                intent.putExtra("Description","It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.");
//                break;
//            case R.id.imageView4:
//                intent.putExtra("Image",R.drawable.image8);
//                intent.putExtra("Description","It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.");
//                break;
//        }
//
//        Log.d("ImageId",String.valueOf(R.drawable.image1));
//        startActivity(intent);
//    }

    public void ContactUsClicked(View view)
    {
        Intent i=new Intent(getBaseContext(), AboutUs.class);
        startActivity(i);
    }

    public void GalleryClicked(View view)
    {
        Intent i=new Intent(getBaseContext(), Gallery.class);
        startActivity(i);
    }

    public void AboutUsClicked(View view)
    {
        Intent i=new Intent(getBaseContext(), Information.class);
        startActivity(i);
    }

}
