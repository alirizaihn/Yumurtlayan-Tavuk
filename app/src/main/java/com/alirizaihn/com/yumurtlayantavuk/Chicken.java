package com.alirizaihn.com.yumurtlayantavuk;

public class Chicken {

    private int chickenX, chickenY, chickenVelocity;
    private String direction;
    public static final String RIGHT="right";
    public static final String LEFT="left";

    public Chicken() {
    chickenY= AppConstants.SCREEN_HEIGHT/2 - AppConstants.getBitmapBank().getChickenHeight()/2;
    chickenX= AppConstants.SCREEN_WIDTH/2 -  AppConstants.getBitmapBank().getChickenWidth()/2;
    }

    public int getChickenVelocity() {
        return chickenVelocity;

    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setChickenVelocity(int chickenVelocity) {
        this.chickenVelocity = chickenVelocity;
    }

    public int getChickenX() {
        return chickenX;
    }

    public void setChickenX(int chickenX) {
        if((chickenX<=AppConstants.SCREEN_WIDTH-AppConstants.getBitmapBank().getChickenWidth())&&(chickenX>=AppConstants.getBitmapBank().getChickenWidth())) {
            this.chickenX = chickenX;
        }
    }

    public int getChickenY() {
        return chickenY;
    }

    public void setChickenY(int chickenY) {
        this.chickenY = chickenY;
    }
}
