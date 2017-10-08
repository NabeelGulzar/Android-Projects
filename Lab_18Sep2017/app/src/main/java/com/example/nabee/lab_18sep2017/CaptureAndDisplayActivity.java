package com.example.nabee.lab_18sep2017;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class CaptureAndDisplayActivity extends AppCompatActivity {

    ImageView iv[]=new ImageView[4];
    int currentImage=0;
//    int imageId;
//    String imageDes;
    Drawable imageToSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture_and_display);
        iv[0]=(ImageView) findViewById(R.id.imageView);
        iv[1]=(ImageView) findViewById(R.id.imageView2);
        iv[2]=(ImageView) findViewById(R.id.imageView3);
        iv[3]=(ImageView) findViewById(R.id.imageView4);
    }

    public void OpenCamera(View view)
    {
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 1888);
    }

    public void SetBackground(View view)
    {

    }

    private void UnselectAllImages()
    {
        iv[0].setAlpha(0.5f);
        iv[1].setAlpha(0.5f);
        iv[2].setAlpha(0.5f);
        iv[3].setAlpha(0.5f);
    }


    public void ShowDetailView(View view)
    {
        UnselectAllImages();
        switch (view.getId()) {
            case R.id.imageView:
//                imageId=R.drawable.image5;
                imageToSend=iv[0].getDrawable();
//                imageDes="It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.";
                iv[0].setAlpha(1f);
                break;
            case R.id.imageView2:
//                imageId=R.drawable.image6;
                imageToSend=iv[1].getDrawable();
//                imageDes="It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.";
                iv[1].setAlpha(1f);
                break;
            case R.id.imageView3:
//                imageId=R.drawable.image7;
                imageToSend=iv[2].getDrawable();
//                imageDes="It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.";
                iv[2].setAlpha(1f);

                break;
            case R.id.imageView4:
                imageToSend=iv[3].getDrawable();
//                imageId=R.drawable.image8;
//                imageDes="It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.";
                iv[3].setAlpha(1f);
                break;
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode == 1888 && resultCode == Activity.RESULT_OK)
        {
            currentImage=(currentImage>3 || currentImage<0)?0:currentImage;
            Bitmap photo=(Bitmap) data.getExtras().get("data");
            iv[currentImage++].setImageBitmap(photo);
            imageToSend=iv[currentImage-1].getDrawable();
            UnselectAllImages();
            iv[currentImage-1].setAlpha(1f);


        }
    }

    public void SetBackGround(View view)
    {

        try
        {
            if(currentImage==4)
            {
                Bitmap bitmap = ((BitmapDrawable) imageToSend).getBitmap();
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                byte[] b = stream.toByteArray();
                Intent intent = new Intent(this, ForBackgroundActivity.class);
                intent.putExtra("picture", b);
                startActivity(intent);
            }
            else
                Toast.makeText(getBaseContext(),4-currentImage+" Capture remaining.",Toast.LENGTH_LONG).show();
        }
        catch (Exception ex)
        {
            Toast.makeText(getBaseContext(),ex.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

}
