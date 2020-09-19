package com.example.tennistracker;
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
public class Data extends WearableActivity implements SensorEventListener{

    private TextView mTextView;
    private SensorManager mSensorManager;//=(SensorManager)getSystemService(SENSOR_SERVICE);;
    private Sensor accel;//=mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    private Sensor gyro;//=mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
    SensorEventListener mListener;
    List<float[]> AccelData=new ArrayList<float[]>();
    List<float[]> GyroData=new ArrayList<float[]>();


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
