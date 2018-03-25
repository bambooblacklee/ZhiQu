package com.bamboolmc.moduleweather.widget;

/**
 * Created by limc on 18/3/11.
 */
public class RainOrSnowLine extends BaseLine {
    public RainOrSnowLine(int maxX, int maxY) {
        super(maxX, maxY);
    }

    @Override
    protected void initRandom() {
        deltaX = 20;
        stopX = startX = random.nextInt(maxX);
        startY = random.nextInt(maxY);
        stopY = startY + 20;
    }

    @Override
    protected void resetRandom() {
        startY = startY - maxY;
        stopY = startY + 20;

    }

    @Override
    protected boolean outOfBounds() {
        if (getStartY() >= maxY) {
            return true;
        }
        return false;
    }

    @Override
    protected void rain() {
        if (outOfBounds())
            resetRandom();
        startY += deltaY;
        stopY += deltaY;

    }
}
