package com.alirizaihn.com.yumurtlayantavuk;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewDebug;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.ArrayList;

import io.github.controlwear.virtual.joystick.android.JoystickView;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    GameThread gameThread;
    String message;
    float currentX;
    float  currentY;

    int state=0;



    public GameView(Context context) {

        super(context);
        initView();


    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
       // setWillNotDraw(false);
        if(!gameThread.isRunning()){
           gameThread = new GameThread(holder);
            gameThread.start();
        }else{
            gameThread.start();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        if(gameThread.isRunning()){
            gameThread.setIsRunning(false);
            boolean retry = true;
            while(retry){
                try{
                    gameThread.join();
                    retry = false;
                }catch(InterruptedException e){}
            }
        }
    }

    void initView(){
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        setFocusable(true);

        gameThread = new GameThread(holder);
    }

//    @Override
//   protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//
//        for(int i=0; i<3; i++){
//
//            if(eggs.get(i).getEggX() > AppConstants.getBitmapBank().getEggWidth()){
//                eggs.get(i).eggY -= eggs.get(i).getEggVelocity();
//  canvas.drawBitmap(AppConstants.getBitmapBank().getEgg(), AppConstants.getGameEngine().chicken.getChickenX(), AppConstants.getGameEngine().chicken.getChickenY()+20 ,null);
//                eggs.get(i).eggX -= eggs.get(i).getEggVelocity();
//            }else{
//                eggs.remove(i);
//            }
//        }
//    }

//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        Log.d("message", "BIRAKIYORUZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZzzz");
//
//        for(int i=0; i<eggs.size(); i++){
//            canvas.drawBitmap(eggs.get(i).egg, AppConstants.getGameEngine().chicken.getChickenX(), AppConstants.getGameEngine().chicken.getChickenY() + 20, null);
//            if(eggs.get(i).eggY > -eggs.get(i).getEggHeight()){
//                eggs.get(i).eggX -= eggs.get(i).getEggVelocity();
//                canvas.drawBitmap(eggs.get(i).egg, AppConstants.getGameEngine().chicken.getChickenX(), AppConstants.getGameEngine().chicken.getChickenY() + 20, null);
//            }else{
//                eggs.remove(i);
//            }
//        }
//
//
//
//    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();

        float finalX, finalY;
        float result, resultY;
        switch (action){
            case MotionEvent.ACTION_DOWN:

               currentX=event.getX();
               currentY=event.getY();
                String message2 = Float.toString(currentY);
                Log.d("message", "CURRENT*Y*"+message2);
                break;
            case MotionEvent.ACTION_MOVE:
                finalX=event.getX();
                finalY=event.getY();

                Log.d("message", "FINAL*Y*"+Float.toString(finalY));
                result=Math.abs(currentX-finalX);
                resultY=Math.abs(currentY-finalY);

                Log.d("message", "RESULT*Y*"+Float.toString(resultY));

                if(currentX<finalX){

                  AppConstants.getGameEngine().chicken.setChickenX((int) (AppConstants.getGameEngine().chicken.getChickenX()+ result*2));
                    AppConstants.getGameEngine().chicken.setDirection("right");
               }
               else{
                  AppConstants.getGameEngine().chicken.setChickenX((int) (AppConstants.getGameEngine().chicken.getChickenX()- result*2));
                    AppConstants.getGameEngine().chicken.setDirection("left");
               }


                if(currentY<finalY){
                    AppConstants.getGameEngine().chicken.setChickenY((int) (AppConstants.getGameEngine().chicken.getChickenY()+ resultY*2));
                }
                else{
                    AppConstants.getGameEngine().chicken.setChickenY((int) (AppConstants.getGameEngine().chicken.getChickenY()- resultY*2));
                }
                currentX=finalX;
                currentY=finalY;


                  String message = Float.toString(currentY);
                    Log.d("message", "ENSON CURRENT Y="+message);

                break;
            case MotionEvent.ACTION_UP:
                AppConstants.getGameEngine().EggFunction();

                break;


        }
        return true;
    }

}
