package com.alirizaihn.com.yumurtlayantavuk;

import java.util.Random;

public class Basket {
    private int basketX, basketY, basketVelocity=15;
    public static final String RIGHT="right";
    public static final String LEFT="left";
    private String direction;
    private int size=0;

    public Basket() {
        basketY=AppConstants.SCREEN_HEIGHT+AppConstants.getBitmapBank().basket.getHeight();
        Random random = new Random();
        int n = random.nextInt(10);
        if(n%2==0){
            direction=LEFT;
            basketX=0;
        }
        else{
            direction=RIGHT;
            basketX=AppConstants.SCREEN_WIDTH-AppConstants.getBitmapBank().getBasketWidth();
            }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getBasketX() {
        return basketX;
    }
public String getDirection(){
        return direction;
}
    public void setBasketX(int basketX) {
        this.basketX = basketX;
    }

    public int getBasketY() {
        return basketY;
    }

    public void setBasketY(int basketY) {
        this.basketY = basketY;
    }

    public int getBasketVelocity() {
        return basketVelocity;
    }

    public void setBasketVelocity(int basketVelocity) {
        this.basketVelocity = basketVelocity;
    }
}
