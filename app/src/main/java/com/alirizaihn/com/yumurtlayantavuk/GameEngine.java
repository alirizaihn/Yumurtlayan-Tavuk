package com.alirizaihn.com.yumurtlayantavuk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.Random;

public class GameEngine {


    BackgroundImage backgroundImage;
    Chicken chicken;
    Egg egg;
    ArrayList<Egg>eggs;
    ArrayList<Basket>baskets;
    ArrayList<Cat>cats;
    int score = 0;
    int counter=30;
    int catCounter=40;
    int counter2=35;
    int state=0;
    Paint scorePaint;
    Paint healtPaint;
    Paint levelPaint;


    public GameEngine() {
        backgroundImage = new BackgroundImage();
        chicken = new Chicken();
        eggs = new ArrayList<>();
        baskets = new ArrayList<>();
        cats= new ArrayList<>();

        healtPaint = new Paint();
        healtPaint.setColor(Color.RED);
        healtPaint.setTextSize(100);
        healtPaint.setTextAlign(Paint.Align.LEFT);

        scorePaint = new Paint();
        scorePaint.setColor(Color.RED);
        scorePaint.setTextSize(100);
        scorePaint.setTextAlign(Paint.Align.LEFT);

        levelPaint = new Paint();
        levelPaint.setColor(Color.RED);
        levelPaint.setTextSize(100);
        levelPaint.setTextAlign(Paint.Align.CENTER);
    }
    public void EggFunction(){
        if(eggs.size() < 15){
            Egg m  = new Egg(chicken.getChickenX(),chicken.getChickenY());
            eggs.add(m);

        }
    }

    public void updateAndDrawBackgroundImage(Canvas canvas){
       // backgroundImage.setX(backgroundImage.getX() - backgroundImage.getVelocity());
        /*if(backgroundImage.getX() < -AppConstants.getBitmapBank().getBackgroundWidth()){
            backgroundImage.setX(0);
        }*/
        canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(), backgroundImage.getX(), backgroundImage.getY(), null);
       if(backgroundImage.getX() < -(AppConstants.getBitmapBank().getBackgroundWidth() - AppConstants.SCREEN_WIDTH)){
            canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(), backgroundImage.getX() +
                    AppConstants.getBitmapBank().getBackgroundWidth(), backgroundImage.getY(),null);
        }
    }

    public void updateAndDrawChickenImage(Canvas canvas){


      canvas.drawBitmap(AppConstants.getBitmapBank().getChicken(), chicken.getChickenX(),chicken.getChickenY(),null);
    }

    public void updateAndDrawEggImage(Canvas canvas){



       for(int i=0; i<eggs.size();i++) {


               Log.d("MESSAGE", "X KONUMU FOR ALTI=" + eggs.get(i).getEggX());
          if(eggs.get(i).getDirection()==Egg.RIGHT) {

                   eggs.get(i).setEggX((int) (eggs.get(i).getEggX() + eggs.get(i).getEggVelocity()));
                   if(eggs.get(i).getEggX()>=AppConstants.SCREEN_WIDTH-AppConstants.getBitmapBank().getBasketWidth()){
                       checkCollision(eggs.get(i));
                   }
               }else
               {
                   eggs.get(i).setEggX((int) (eggs.get(i).getEggX() - eggs.get(i).getEggVelocity()));
                   if(eggs.get(i).getEggX()<=AppConstants.getBitmapBank().getBasketWidth()){
                       checkCollision(eggs.get(i));
                   }
               }
                 canvas.drawText("Pt:"+ AppConstants.score, 0,110,scorePaint);
               canvas.drawBitmap(AppConstants.getBitmapBank().getEgg(), eggs.get(i).getEggX(), eggs.get(i).getEggY(), null);

           if ((eggs.get(i).getEggX() < -AppConstants.getBitmapBank().getEggWidth()) || (eggs.get(i).getEggX() > AppConstants.SCREEN_WIDTH ))  {
               Log.d("MESSAGE", "X KONUMU=" + eggs.get(i).getEggX());
               eggs.remove(i);
           }

       }

    }
    public void updateDrawBasketImage(Canvas canvas){

        if(counter==0){
            Basket basket = new Basket();
            Random random2 = new Random();
            int i = random2.nextInt(3);
            basket.setSize(i);
            baskets.add(basket);


            Random random = new Random();
            counter= random.nextInt(20) + 5;
        }
        for (int i=0; i<baskets.size(); i++){
            baskets.get(i).setBasketY(baskets.get(i).getBasketY()-baskets.get(i).getBasketVelocity());

            if(baskets.get(i).getSize()==0){
                canvas.drawBitmap(AppConstants.getBitmapBank().getBasket(), baskets.get(i).getBasketX(),baskets.get(i).getBasketY(), null);
            }
            else if (baskets.get(i).getSize()==1){
                canvas.drawBitmap(AppConstants.getBitmapBank().getBasket2(), baskets.get(i).getBasketX(),baskets.get(i).getBasketY(), null);
            }
            else {
                canvas.drawBitmap(AppConstants.getBitmapBank().getBasket3(), baskets.get(i).getBasketX(),baskets.get(i).getBasketY(), null);
            }

            if(baskets.get(i).getBasketY()<-AppConstants.getBitmapBank().basket.getHeight()){
                baskets.remove(i);
            }
        }

        counter-=1;

    }
//    public void updateDrawBasket2Image(Canvas canvas){
//
//        if(counter2==0){
//            Basket basket = new Basket();
//            basket.setSize(2);
//            baskets.add(basket);
//
//            Random random = new Random();
//            counter2= random.nextInt(40) + 30;
//        }
//        for (int i=0; i<baskets.size(); i++){
//            baskets.get(i).setBasketY(baskets.get(i).getBasketY()-baskets.get(i).getBasketVelocity());
//            canvas.drawBitmap(AppConstants.getBitmapBank().getBasket2(), baskets.get(i).getBasketX(),baskets.get(i).getBasketY(), null);
//            if(baskets.get(i).getBasketY()<-AppConstants.getBitmapBank().basket.getHeight()){
//                baskets.remove(i);
//            }
//        }
//
//        counter2-=1;
//
//    }
    public void updateDrawCatImage(Canvas canvas){
        if(catCounter==0){
            Cat cat = new Cat();
            cats.add(cat);
            Random random = new Random();
            catCounter=random.nextInt(40)+15;
            }
            for(int i=0; i<cats.size();i++){
            cats.get(i).setCatY(cats.get(i).getCatY()-cats.get(i).getCatVelocity());

                    if(!cats.get(i).isTouched()){
                        checkCatCollision(cats.get(i));

                    }
                canvas.drawText("Pt:"+ AppConstants.score, 0,110,scorePaint);
                canvas.drawText("Hlt:"+ AppConstants.healt, AppConstants.SCREEN_WIDTH-220,110,scorePaint);
                canvas.drawText("Lvl="+AppConstants.level,AppConstants.SCREEN_WIDTH/2, 110, levelPaint);
            canvas.drawBitmap(AppConstants.getBitmapBank().getCat(),cats.get(i).getCatX(),cats.get(i).getCatY(), null);
            if(cats.get(i).getCatY()<-AppConstants.getBitmapBank().cat.getHeight()){
                cats.remove(i);
            }

        }

         catCounter-=1;
    }
    public void checkCollision(Egg egg){
        for (int i=0; i<baskets.size(); i++){
            if(Math.abs(egg.getEggY()-baskets.get(i).getBasketY())<AppConstants.getBitmapBank().getEggHeight()  && egg.getDirection()==baskets.get(i).getDirection()){
                baskets.remove(i);
                switch (baskets.get(i).getSize()){
                    case 0:
                    AppConstants.score+=10;
                    break;
                    case 1:
                        AppConstants.score+=15;
                        break;
                    case 2:
                        AppConstants.score+=20;
                        break;
                }
                Log.i("PUANN","VURDUN"+AppConstants.score);
            }
        }

    }
    public void checkCatCollision(Cat cat){

        if(Math.abs(cat.getCatX()-chicken.getChickenX())<AppConstants.getBitmapBank().getChickenWidth() && Math.abs(cat.getCatY()-chicken.getChickenY())<AppConstants.getBitmapBank().getCatHeight()) {
            Log.i("KESISICIM KEDI","KESISTI");
               cat.setTouched(true);
            AppConstants.healt-=1;
            if(AppConstants.healt==0){
                Context context = AppConstants.gameActivityContext;
                Intent intent = new Intent(context, GameOver.class);
                intent.putExtra("score", AppConstants.score);
                context.startActivity(intent);
                ((Activity) context).finish();

            }
            }

    }



    public void updateLevel(Canvas canvas) {
        if(AppConstants.score<100){
            AppConstants.level=1;}
            else if (AppConstants.score>=100 && AppConstants.score<300){
                AppConstants.level=2;
            }
            else if(AppConstants.score>=300){
            AppConstants.level=3;
        }

        }


}

