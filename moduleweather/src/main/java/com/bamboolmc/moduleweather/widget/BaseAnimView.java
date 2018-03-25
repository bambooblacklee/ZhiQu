package com.bamboolmc.moduleweather.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by limc on 18/3/9.
 */
public abstract class BaseAnimView extends SurfaceView implements SurfaceHolder.Callback, Runnable {

    protected Thread thread;
    protected int backColor = 0;
    protected int windowWidth;
    protected int windowHeight;
    protected int sleepTime = 30;
    protected SurfaceHolder holder;

    public BaseAnimView(Context context, int backColor) {
        super(context);
        holder = getHolder();
        holder.addCallback(this);
        this.backColor = backColor;
        holder.setFormat(PixelFormat.TRANSLUCENT);
        init();
    }

    protected void init() {
        Rect rect = new Rect();
        getWindowVisibleDisplayFrame(rect);
        windowWidth = rect.width();
        windowHeight = rect.height();
    }

    protected float getFitSize(float size) {
        return size * windowWidth / 1080;
    }

    protected void startAnim() {
        if (thread != null) {
            thread = null;
        }
        thread = new Thread(this);
        thread.start();
    }

    protected void doLogic() {
        while (true) {
            Canvas canvas = null;
            synchronized (this) {
                try {
                    canvas = holder.lockCanvas();
                    if (canvas != null) {
                        canvas.drawColor(backColor);
                        drawSub(canvas);
                        animLogic();
                        holder.unlockCanvasAndPost(canvas);
                    }
                    Thread.sleep(sleepTime());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    protected abstract void drawSub(Canvas canvas);

    protected abstract void animLogic();

    protected abstract void reset();

    protected int sleepTime() {
        return sleepTime;
    }

}
