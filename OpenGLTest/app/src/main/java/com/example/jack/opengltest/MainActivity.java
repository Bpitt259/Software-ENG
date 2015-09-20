package com.example.jack.opengltest;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    float lastX = 0, lastY = 0;
    long startTime;
    SensorManager sensorManager;
    Sensor theSensor;
    OpenGLRenderer theRenderer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GLSurfaceView view = new GLSurfaceView(this);
        theRenderer = new OpenGLRenderer();
        view.setRenderer(theRenderer);
        this.setContentView(view);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        theSensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        view.setOnTouchListener(onTouchListener);
    }

    View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    lastX = motionEvent.getX();
                    lastY = motionEvent.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    float currentX = motionEvent.getX();
                    float currentY = motionEvent.getY();
                    float dx = (currentX - lastX) / 4;
                    float dy = (currentY - lastX) / 4;
//                    y += (currentX - lastX) / 4;
//                    x += (currentY - lastY) / 4;
                    float length = (float) Math.sqrt(dx * dx + dy * dy);
                    float angel = (float) Math.atan2(dx, dy);
                    float[] vector = new float[3];
                    vector[0] = (float) Math.cos(angel) * 1;
                    vector[1] = (float) Math.sin(angel) * 1;
                    vector[3] = 0;
                    theRenderer.rotateVector = vector;
                    theRenderer.rotate = length / 6;
                    lastX = currentX;
                    lastY = currentY;
                    glUpdate();
            }
            return true;
        }
    };
    public void onResume() {
        super.onResume();
//        sensorManager.registerListener(sensorEventListener, theSensor, SensorManager.SENSOR_DELAY_FASTEST);
}
    public void onPause() {
        super.onPause();
        sensorManager.unregisterListener(sensorEventListener);
    }
    public void glUpdate() {
//        theRenderer.x = x;
//        theRenderer.y = y;
//        theRenderer.z = z;
    }
    public SensorEventListener sensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            long currentTime = System.currentTimeMillis();
            if (startTime != 0) {
                float deltaTime = (float)(currentTime - startTime) / 1000;
                float valueX = sensorEvent.values[0];
                float valueY = sensorEvent.values[1];
                float valueZ = sensorEvent.values[2];
//                x += (valueX * 180 / Math.PI) * deltaTime;
//                y += (valueY * 180 / Math.PI) * deltaTime;
//                z += (valueZ * 180 / Math.PI) * deltaTime;
            }
            glUpdate();
            startTime = currentTime;
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
