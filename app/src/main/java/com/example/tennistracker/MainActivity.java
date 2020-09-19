package com.example.tennistracker;

import android.hardware.SensorEventListener;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.widget.Button;
import android.widget.TextView;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends WearableActivity implements SensorEventListener {

    //TextInputEditText message;
    private SensorManager mSensorManager;//=(SensorManager)getSystemService(SENSOR_SERVICE);;
    private Sensor accel;//=mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    private Sensor gyro;//=mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
    SensorEventListener mListener;
    List<float[]> AccelData=new ArrayList<float[]>();
    List<float[]> GyroData=new ArrayList<float[]>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //message = findViewById(R.id.edit);
        Button StartButt= findViewById(R.id.button);
        Button StopButt= findViewById(R.id.button);
        mSensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        accel=mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        gyro=mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        StartButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Start();
            }
        });
        StopButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Stop();
            }
        });
        /*butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sender messageSender = new Sender();
                messageSender.execute();//message.getText().toString());
            }
        });*/

        // Enables Always-on
        setAmbientEnabled();
    }
    public void Start()
    {
        if(accel==null)
        {
            return;
        }
        if(gyro==null)
        {
            return;
        }
        mSensorManager.registerListener(mListener,accel,mSensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(mListener,gyro,mSensorManager.SENSOR_DELAY_NORMAL);


    }
    public void Stop()
    {
        if(accel==null)
        {
            return;
        }
        if(gyro==null)
        {
            return;
        }
        mSensorManager.unregisterListener(mListener,accel);
        mSensorManager.unregisterListener(mListener,gyro);
        Sender messageSender = new Sender(AccelData,GyroData);
        messageSender.execute();

    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER) {
            AccelData.add(event.values.clone());
        }
        if(event.sensor.getType()==Sensor.TYPE_GYROSCOPE)
        {
            GyroData.add(event.values.clone());
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
    /*public void sendMessage(View v)
    {
        Sender messageSender = new Sender();
        messageSender.execute(message.getText().toString());

    }*/

}
