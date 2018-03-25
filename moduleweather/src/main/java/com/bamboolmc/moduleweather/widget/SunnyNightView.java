package com.bamboolmc.moduleweather.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.SurfaceHolder;

import java.util.ArrayList;

/**
 * Created by limc on 18/3/11.
 */
public class SunnyNightView extends BaseAnimView {
    private Paint paint;
    private static final int STAR_COUNT = 150;
    private ArrayList<Star> stars;


    public SunnyNightView(Context context, int backColor) {
        super(context, backColor);
    }

    @Override
    protected void init() {
        super.init();
        paint = new Paint();
        paint.setStrokeWidth(getFitSize(3));
        paint.setColor(Color.WHITE);
        paint.setShadowLayer(getFitSize(10),0,0,Color.WHITE);
        stars = new ArrayList<>();
        for (int i = 0; i < STAR_COUNT; i++) {
            stars.add(new Star(windowWidth,windowHeight));
        }
    }

    @Override
    protected void drawSub(Canvas canvas) {
        for(Star star:stars){
            paint.setAlpha(star.getCurrentAlpha());
            Float fitRadius = getFitSize(star.getRadius());
            RectF rect = new RectF(star.getX()-fitRadius,star.getY()-fitRadius,star.getX()+fitRadius,star.getY()+fitRadius);
            canvas.drawArc(rect,0,360,false,paint);
        }

    }

    @Override
    protected void animLogic() {
        for (Star star :stars){
            star.shine();
        }

    }

    @Override
    public void run() {
        doLogic();

    }

    @Override
    protected void reset() {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        startAnim();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
