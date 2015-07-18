package com.example.tdh.nospyflashlight;

import android.app.Activity;
import android.hardware.Camera;
//import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Toast;


public class Main extends Activity {

    //Creating global objects for camera and media player
    Camera c;
    //MediaPlayer med;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        try {
            //opening up the camera and setting it up for use
            c = Camera.open();
            Camera.Parameters params = c.getParameters();
            params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);

            //setting the flash to on and starting the camera action
            c.setParameters(params);
            c.startPreview();
        }
        catch (NullPointerException n)
        {
            //error message for no camera found
            Toast.makeText(this,"Error: No back facing camera, exiting app",Toast.LENGTH_LONG).show();
            finish();
        }

        //Implementing sound effect on start
       // med = MediaPlayer.create(getApplicationContext(), R.raw.test);
        //med.start();
        //med.release();

    }

    @Override
    public void onStop()
    {
        super.onStop();

        //Implementing sound effect on close
        //med = MediaPlayer.create(getApplicationContext(), R.raw.out);
        //med.start();
       // med.release();

        //turning off flash and releasing the camera for use
        c.stopPreview();
        c.release();
    }
}
