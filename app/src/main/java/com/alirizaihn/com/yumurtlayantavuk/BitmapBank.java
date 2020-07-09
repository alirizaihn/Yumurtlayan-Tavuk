package com.alirizaihn.com.yumurtlayantavuk;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;

public class BitmapBank {

    Bitmap background;
    Bitmap chicken;
    Bitmap egg;
    Bitmap basket;
    Bitmap cat;
    Bitmap basket2;
    Bitmap basket3;



    public BitmapBank(Resources res) {
        background = BitmapFactory.decodeResource(res, R.drawable.background);
        chicken = BitmapFactory.decodeResource(res, R.drawable.chicken);
        chicken = Bitmap.createScaledBitmap(chicken, AppConstants.SCREEN_WIDTH/10 , AppConstants.SCREEN_HEIGHT/12, true);
        background = scaleImage(background);
        egg= BitmapFactory.decodeResource(res,R.drawable.egg);
        egg=Bitmap.createScaledBitmap(egg, AppConstants.SCREEN_WIDTH/18 , AppConstants.SCREEN_HEIGHT/20, true);
        cat=BitmapFactory.decodeResource(res,R.drawable.cat);
        cat=Bitmap.createScaledBitmap(cat, AppConstants.SCREEN_WIDTH/10, AppConstants.SCREEN_HEIGHT/12, true);
        basket=BitmapFactory.decodeResource(res, R.drawable.basket);
        basket=Bitmap.createScaledBitmap(basket, AppConstants.SCREEN_WIDTH/10 , AppConstants.SCREEN_HEIGHT/12, true);
        basket2=Bitmap.createScaledBitmap(basket, AppConstants.SCREEN_WIDTH/15 , AppConstants.SCREEN_HEIGHT/17, true);
        basket3=Bitmap.createScaledBitmap(basket, AppConstants.SCREEN_WIDTH/17 , AppConstants.SCREEN_HEIGHT/20, true);
    }


    public Bitmap getCat() {
        return cat;
    }
    public int getCatWidth(){return cat.getWidth();}
    public int getCatHeight(){return cat.getHeight();}

    public Bitmap getBasket() {
        return basket;
    }
    public int getBasketWidth(){return basket.getWidth();}
    public int getBasketHeight(){return basket.getHeight();}

    public Bitmap getBasket2() {
        return basket2;
    }
    public int getBasket2Width(){return basket2.getWidth();}
    public int getBaske2tHeight(){return basket2.getHeight();}

    public Bitmap getBasket3() {
        return basket3;
    }
    public int getBasket3Width(){return basket3.getWidth();}
    public int getBasket3Height(){return basket3.getHeight();}


    public Bitmap getEgg(){
        return egg;
    }
    public int getEggWidth(){
        return egg.getWidth();
    }
    public int getEggHeight(){
        return egg.getHeight();
    }

    public Bitmap getChicken(){
        return  chicken;
    }
    public int getChickenWidth(){
        return chicken.getWidth();
    }
    public int getChickenHeight(){
        return chicken.getHeight();
    }



    //Return background bitmap
    public Bitmap getBackground(){
        return background;
    }

    //Return background width
    public int getBackgroundWidth(){
        return background.getWidth();
    }

    //Return background height
    public int getBackgroundHeight(){
        return background.getHeight();
    }

    public Bitmap scaleImage(Bitmap bitmap){
        float widthHeightRatio = getBackgroundWidth() / getBackgroundHeight();
        /*
        We'll multiply widthHeightRatio with screenHeight to get scaled width of the bitmap.
        Then call createScaledBitmap() to create a new bitmap, scaled from an existing bitmap, when possible.
         */
        int backgroundScaledWidth = (int) widthHeightRatio * AppConstants.SCREEN_HEIGHT;
        return Bitmap.createScaledBitmap(bitmap, backgroundScaledWidth, AppConstants.SCREEN_HEIGHT, false);
    }
}
