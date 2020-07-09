package com.alirizaihn.com.yumurtlayantavuk;

import android.util.Log;

public class Egg {
    private int eggX, eggY;
    private String direction;
    public static final String RIGHT="right";
    public static final String LEFT="left";

    private int eggVelocity=30;

    public Egg(int x, int y){

        if (x>AppConstants.SCREEN_WIDTH/2){
            direction=RIGHT;
        }
        else {
            direction=LEFT;
        }

        eggY=y;
        eggX=x;
        Log.d("EGGX","YUMURTANIN X ="+eggX);

    }
    public float getEggX() {
        return eggX;
    }

    public String getDirection() {
        return direction;
    }

    public void setEggX(int eggX) {
        this.eggX = eggX;
    }

    public float getEggY() {
        return eggY;
    }

    public void setEggY(int eggY) {
        this.eggY = eggY;
    }

    public int getEggVelocity() {
        return eggVelocity;
    }

    public void setEggVelocity(int eggVelocity) {
        this.eggVelocity = eggVelocity;
    }
}
