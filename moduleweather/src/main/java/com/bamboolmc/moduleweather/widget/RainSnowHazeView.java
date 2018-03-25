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
public class RainSnowHazeView extends BaseAnimView {
    private static final int RAIN_COUNT = 60;
    private ArrayList<BaseLine> rainLines;
    private Paint paint;
    private Type type = Type.RAIN;

    public RainSnowHazeView(Context context, Type type, int backColor) {
        super(context, backColor);
        this.type = type;
        init2();
    }


    protected void init2() {
        rainLines = new ArrayList<>();
        switch (type) {
            case RAIN_SNOW:
                break;
            case SNOW:
                break;
            case RAIN:
                for (int i = 0; i < RAIN_COUNT; i++) {
                    rainLines.add(new RainOrSnowLine(windowWidth, windowHeight));
                }
                break;
            case HAZE:
                for (int i = 0; i < RAIN_COUNT; i++) {
                    rainLines.add(new HazeLine(windowWidth, windowHeight));
                }
                break;
            default:
                for (int i = 0; i < RAIN_COUNT; i++) {
                    rainLines.add(new RainOrSnowLine(windowWidth, windowHeight));
                }
                break;
        }
        paint = new Paint();
        paint.setStrokeWidth(3);
        if (paint != null) {
            paint.setColor(Color.WHITE);
        }
    }

    @Override
    protected void drawSub(Canvas canvas) {
        paint.setShadowLayer(getFitSize(10), 0, 0, Color.WHITE);
        boolean rain = true;
        for (BaseLine rainLine : rainLines) {
            if (type == Type.HAZE) {
                paint.setAlpha(100);
                RectF rect1 = new RectF(rainLine.getStartX() - getFitSize(5), rainLine.getStartY() - getFitSize(5),
                        rainLine.getStartX() + getFitSize(5), rainLine.getStartY() + getFitSize(5));
                canvas.drawArc(rect1, 0, 360, false, paint);
            } else if (type == Type.SNOW) {
                RectF rect2 = new RectF(rainLine.getStartX() - getFitSize(8), rainLine.getStartY() - getFitSize(8),
                        rainLine.getStartX() + getFitSize(8), rainLine.getStartY() + getFitSize(8));
                canvas.drawArc(rect2, 0, 360, false, paint);
            } else {
                if (type == Type.RAIN_SNOW) {
                    rain = !rain;
                }
                if (rain) {
                    paint.setShadowLayer(0, 0, 0, Color.WHITE);
                    canvas.drawLine(rainLine.getStartX(), rainLine.getStartY(), rainLine.getStopX(), rainLine.getStopY() + getFitSize(8), paint);
                } else {
                    RectF rect3 = new RectF(rainLine.getStartX() - getFitSize(8), rainLine.getStartY() - getFitSize(8), rainLine.getStartX() + getFitSize(8), rainLine.getStartY() + getFitSize(5));
                    canvas.drawArc(rect3, 0, 360, false, paint);
                }
            }
        }

    }

    @Override
    protected void animLogic() {
        for (BaseLine rainLine : rainLines) {
            rainLine.rain();
        }

    }

    @Override
    public void run() {
        doLogic();
    }

    @Override
    protected int sleepTime() {
        return 3;
    }

    @Override
    protected void reset() {

    }

    public enum Type {
        RAIN, SNOW, RAIN_SNOW, HAZE
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
