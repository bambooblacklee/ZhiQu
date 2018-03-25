package com.bamboolmc.moduleweather.widget;

import java.util.Random;

/**
 * Created by limc on 18/3/11.
 */
public class Star {

    protected int x;
    protected int y;
    protected Random random = new Random();
    private int radius = 4;
    private int minAlpha = 30;
    private int maxAlpha = 140;
    private int currentAlpha = minAlpha;
    private int alphaDelta = 2;

    public Star(int maxX, int maxY) {
        this.x = random.nextInt(maxX);
        this.y = random.nextInt(maxY);
        this.radius = 2 + random.nextInt(2);
        currentAlpha = minAlpha + random.nextInt(110);
    }

    public void shine() {
        if (outOfBounds()) {
            alphaDelta = -alphaDelta;
            currentAlpha = currentAlpha + alphaDelta;
        }
    }

    public boolean outOfBounds() {
        if (currentAlpha >= maxAlpha || currentAlpha <= minAlpha) {
            return true;
        } else {
            return false;
        }
    }

    public int getCurrentAlpha() {
        return currentAlpha;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }
}
