package com.bamboolmc.moduleweather.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.SurfaceHolder;

/**
 * Created by limc on 18/3/9.
 */
public class SunnyDayView extends BaseAnimView {
    Paint paint;
    private float MIN = getFitSize(200);
    private float MAX = getFitSize(260);
    private float addRadius = getFitSize(200);

    private float radius = MIN;
    private int deltaRadius = 1;


    public SunnyDayView(Context context, int backColor) {
        super(context, backColor);
    }

    @Override
    protected void init() {
        super.init();
        paint = new Paint();
        paint.setStrokeWidth((float) 3.0);
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
    }

    @Override
    public void run() {
        doLogic();
    }

    @Override
    protected void drawSub(Canvas canvas) {
        if(radius > MAX){
            deltaRadius =  -deltaRadius;
        }
        if (radius < MIN){
            deltaRadius = -deltaRadius;
        }

        RectF rect1 = new RectF(-radius,-radius,radius,radius);
        RectF rect2 = new RectF(-(radius+addRadius),-(radius+addRadius),(radius+addRadius),(radius+addRadius));
        RectF rect3 = new RectF(-(radius+ 2*addRadius),-(radius+ 2*addRadius),(radius+ 2*addRadius),(radius+ 2*addRadius));

        paint.setAlpha(50);
        canvas.drawArc(rect3,0,360,false,paint);
        paint.setAlpha(30);
        canvas.drawArc(rect2,0,360,false,paint);
        paint.setAlpha(15);
        canvas.drawArc(rect1,0,360,false,paint);

    }

    @Override
    protected void animLogic() {
        radius += deltaRadius;

    }

    @Override
    protected void reset() {
        radius = MIN;
    }

    @Override
    protected int sleepTime() {
        return 50;
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
