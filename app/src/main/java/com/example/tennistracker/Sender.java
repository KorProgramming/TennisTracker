package com.example.tennistracker;

import android.os.AsyncTask;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.widget.Button;
import android.widget.TextView;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by haroonpc on 3/19/2018.
 */

public class Sender extends AsyncTask<String,Void,String>
{
    private List<float[]> AccelData;
    private List<float[]> GyroData;
    Sender(List<float[]> Accel,List<float[]> Gyro)
    {
        AccelData=Accel;
        GyroData=Gyro;
    }
    @Override
    protected String doInBackground(String... params) {

        String message = params[0];
        String sample= "HELLO";
        try
        {
            Socket mySocket = new Socket("192.168.56.1",9000);
            DataOutputStream dos = new DataOutputStream(mySocket.getOutputStream());
            dos.writeUTF(sample);
            dos.writeUTF("Over");
            dos.close();
            mySocket.close();

        }catch(IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}