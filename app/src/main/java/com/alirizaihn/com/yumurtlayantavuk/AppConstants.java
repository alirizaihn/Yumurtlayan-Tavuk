package com.alirizaihn.com.yumurtlayantavuk;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class AppConstants {

    static BitmapBank bitmapBank; // Bitmap object reference
    static GameEngine gameEngine; // GameEngine object reference
    static int SCREEN_WIDTH, SCREEN_HEIGHT;
    static int gapBetweenBasketLeft;
    static int gapBetweenBasketRight;
    static int numberOfBasket;
    static int basketVelocity;
    static int minBasketOffsetY;
    static int maxBasketOffsetY;
    static int distanceBetweenBaskets;
    static int numberOfEgg;
    static int score;
    static int healt=3;
    static Context gameActivityContext;
    static int level=1;


    public static void initialization(Context context){
        setScreenSize(context);
        bitmapBank = new BitmapBank(context.getResources());
        gameEngine = new GameEngine();


    }
    public static void setGameConstants(){
        numberOfEgg=3;
        gapBetweenBasketLeft=600;
        gapBetweenBasketRight=600;
        AppConstants.numberOfBasket=2;
        AppConstants.basketVelocity=12;
        AppConstants.minBasketOffsetY= (int)(AppConstants.gapBetweenBasketLeft/2.0);
        AppConstants.maxBasketOffsetY=(AppConstants.SCREEN_HEIGHT-AppConstants.minBasketOffsetY-AppConstants.gapBetweenBasketLeft);
        AppConstants.distanceBetweenBaskets=AppConstants.SCREEN_WIDTH*3/4;
    }


    // Return BitmapBank instance
    public static BitmapBank getBitmapBank(){
        return bitmapBank;
    }

    // Return GameEngine instance
    public static GameEngine getGameEngine(){
        return gameEngine;
    }

    private static void setScreenSize(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        AppConstants.SCREEN_WIDTH = width;
        AppConstants.SCREEN_HEIGHT = height;
    }

}
