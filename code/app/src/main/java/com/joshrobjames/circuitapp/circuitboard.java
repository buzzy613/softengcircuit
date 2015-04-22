package com.joshrobjames.circuitapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Toast;


public class circuitboard extends ActionBarActivity implements View.OnTouchListener {
   // Bitmap battery;
   // Bitmap resistor;

    //float x = 0;
    //float y = 0;
    //private SurfaceHolder svHolder;
    //private SurfaceView sv;
    //Canvas c = new Canvas();

    OurView v;
    Bitmap battery;
    Bitmap resistor;
    float x,y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circuitboard);
        //battery = BitmapFactory.decodeResource(getResources(), R.drawable.genericbattery);
        //resistor = BitmapFactory.decodeResource(getResources(), R.drawable.genericresistor);
          //sv = (SurfaceView) findViewById(R.id.surfaceView);
         //svHolder = sv.getHolder();
        //sv.setWillNotDraw(false);

       //c  = sv.getHolder().lockCanvas();
        //c.drawARGB(255,150,150,10);
        //svHolder.unlockCanvasAndPost(c);

        v = new OurView(this); //calls the public class OurView
        v.setOnTouchListener(this);
        battery = BitmapFactory.decodeResource(getResources(), R.drawable.genericbattery);
        resistor = BitmapFactory.decodeResource(getResources(), R.drawable.genericresistor);

        x = 0;
        y = 0;
        setContentView(v);

    }

    @Override
    protected void onPause() {
        super.onPause();
        v.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        v.resume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_circuitboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        //x = event.getX();
        //y = event.getY();

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                x = event.getX();
                y = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                x = event.getX();
                y = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                x = event.getX();
                y = event.getY();
                break;
        }


        return true;
    }

    public class OurView extends SurfaceView implements Runnable {

        Thread t = null;
        SurfaceHolder holder;
        boolean isItOk = false;

        public OurView(Context context) {
            super(context);
            holder = getHolder();
        }

        @Override
        public void run() {
            while (isItOk == true){
                //perform canvas drawing
                if(!holder.getSurface().isValid()){ //looping back to the while loop if it is not valid
                    continue;
                }
                    Canvas c = holder.lockCanvas(); //to lock the canvas in order to paint to the canvas
                    c.drawARGB(255, 150, 150, 10); //paint background of canvas
                    c.drawBitmap(battery, x - (battery.getWidth()/2), y - (battery.getHeight()/2), null);
                    c.drawBitmap(resistor, x - (resistor.getWidth()/2), y - (resistor.getHeight()/2), null);
                    holder.unlockCanvasAndPost(c);
            }
        }
        public void pause(){
            isItOk = false;
            while(true){
                try{
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
            t=null;
        }
        public void resume(){
            isItOk = true;
            t = new Thread(this);
            t.start();
        }


    }


    public void displayPS2(View view) {

        //Toast.makeText(this,"button clicked",Toast.LENGTH_SHORT).show();

        //Toast.makeText(this,"battery created",Toast.LENGTH_SHORT).show();
      //  c.drawBitmap(battery, x, y, null);

    }

    public void displayR2(View view) {
        //  c.drawBitmap(resistor, x, y, null);
    }
}
