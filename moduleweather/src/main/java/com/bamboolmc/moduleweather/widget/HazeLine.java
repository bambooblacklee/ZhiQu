package com.bamboolmc.moduleweather.widget;

/**
 * Created by limc on 18/3/11.
 */
public class HazeLine extends BaseLine {
    public HazeLine(int maxX, int maxY) {
        super(maxX, maxY);
    }

    @Override
    protected void initRandom() {
        deltaX = 1+random.nextInt(5);
        startX = random.nextInt(maxX);
        startY = random.nextInt(maxY);
        stopY = startX+deltaX;
    }

    @Override
    protected void resetRandom() {
        startX = startX -maxX;
    }

    @Override
    protected boolean outOfBounds() {
        if (getStartX()>maxX){
            return true;
        }
        return false;
    }

    @Override
    protected void rain() {
        if (outOfBounds()){
            resetRandom();
        }
        startX+=deltaX;
        stopX +=deltaX;

    }
}
