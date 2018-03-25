package com.bamboolmc.moduleweather.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.SurfaceHolder;

/**
 * Created by limc on 18/3/11.
 */
public class CloudyView extends BaseAnimView {
    Paint paint;
    //最小圆半径
    private float MIN = getFitSize(560);
    //最大圆半径
    private float MAX = MIN + getFitSize(60);
    //圆半径
    private float radius = MIN;
    private int deltaRadius = 1;

    public CloudyView(Context context, int backColor) {
        super(context, backColor);
    }

    @Override
    protected void init() {
        super.init();
        paint = new Paint();
        paint.setStrokeWidth(getFitSize(3));
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        paint.setAlpha(70);
    }

    @Override
    protected void drawSub(Canvas canvas) {
        if (radius > MAX) {
            deltaRadius = -deltaRadius;
        }
        if (radius < MIN) {
            deltaRadius = -deltaRadius;
        }
        RectF rect1 = new RectF(-radius, -radius, radius, radius);
        RectF rect2 = new RectF((windowWidth / 2 - radius), -radius, (windowWidth / 2 + radius), radius);
        RectF rect3 = new RectF(windowWidth - radius, -radius, windowWidth + radius, radius);
        canvas.drawArc(rect3, 0, 360, false, paint);
        canvas.drawArc(rect2, 0, 360, false, paint);
        canvas.drawArc(rect1, 0, 360, false, paint);

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
    public void run() {
        doLogic();
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
