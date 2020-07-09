package com.alirizaihn.com.yumurtlayantavuk;

import java.util.Random;

public class Cat {
    private int catX, catY, catVelocity=10;
    private boolean isTouched=false;
    public Cat(){
        switch (AppConstants.level){
            case 1:
                catVelocity=10;
                break;
            case 2:
                catVelocity=20;
                break;
            case 3:
                catVelocity=30;
                break;
        }
        Random random = new Random();

        int n = random.nextInt(AppConstants.SCREEN_WIDTH-AppConstants.getBitmapBank().getBasketWidth()-AppConstants.getBitmapBank().getCatWidth())+AppConstants.getBitmapBank().getBasketWidth();
        catX=n;
        catY=AppConstants.SCREEN_HEIGHT+AppConstants.getBitmapBank().getEggHeight();

    }

    public boolean isTouched() {
        return isTouched;
    }

    public void setTouched(boolean touched) {
        isTouched = touched;
    }

    public int getCatX() {
        return catX;
    }

    public void setCatX(int catX) {
        this.catX = catX;
    }

    public int getCatY() {
        return catY;
    }

    public void setCatY(int catY) {
        this.catY = catY;
    }

    public int getCatVelocity() {
        return catVelocity;
    }

    public void setCatVelocity(int catVelocity) {
        this.catVelocity = catVelocity;
    }
}
