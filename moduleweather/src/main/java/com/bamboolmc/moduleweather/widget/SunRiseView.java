package com.bamboolmc.moduleweather.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

import com.bamboolmc.moduleweather.R;
import com.bamboolmc.moduleweather.util.ScreenUtil;

import java.util.Calendar;

/**
 * Created by limc on 18/3/9.
 */
public class SunRiseView extends View {
    private int height, width;
    private float progress = 0.0f;
    private Paint paint = new Paint();
    private String sunRise;
    private String sunDown;
    private Context context;

    public SunRiseView(Context context) {
        super(context);
        this.context = context;
    }

    public SunRiseView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public SunRiseView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = ScreenUtil.getScreenWidth(context);
        height = getFitSize(550);
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth((float) 5.0);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAlpha(160);

        int center = width / 2;
        int radius = height - getFitSize(120);
        RectF rect = new RectF(center - radius, center - radius, center + radius, center + radius);
        canvas.translate(0, (height - radius - (center - radius)));

        //太阳轨迹
        int angel = 3;
        DashPathEffect dashPathEffect = new DashPathEffect(new float[]{25, 25}, 5);
        paint.setPathEffect(dashPathEffect);
        canvas.drawArc(rect, 180, 180, false, paint);
        paint.setPathEffect(null);

        //绘制太阳
        paint.setStrokeWidth((float) 4.0);
        paint.setAlpha(255);
        Double pointX = 0.0;
        Double pointY = 0.0;
        angel = 90 - (int) (180 * progress);
        if (angel < 0) {
            angel = 180 - (int) (180 * progress);
            pointX = center + radius * Math.cos((angel / 180f) * Math.PI);
            pointY = height - radius * Math.sin((angel / 180f) * Math.PI) - (height - radius - (center - radius));
        } else {
            pointX = center - radius * Math.sin((angel / 180f) * Math.PI);
            pointY = height - radius * Math.cos((angel / 180f) * Math.PI) - (height - radius - (center - radius));
        }
        canvas.drawCircle(pointX.floatValue(), pointY.floatValue(), getFitSize(30), paint);

        //扫过的阴影
        Path path = new Path();
        path.arcTo(rect, 180, 180 * progress);
        path.lineTo(pointX.floatValue(), pointY.floatValue() + radius);
        paint.setAlpha(60);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPath(path, paint);

        //日出日落时间
        paint.setStyle(Paint.Style.FILL);
        paint.setAlpha(255);
        paint.setTextSize(ScreenUtil.getSp(context, 12));
        paint.setStrokeWidth((float) 1.0);
        paint.setTextAlign(Paint.Align.CENTER);

        canvas.drawText(String.format(context.getString(R.string.custom_sun_view_str_sunrise), sunRise)
                , center - radius + getFitSize(125), height - (height - radius - (center - radius)) - getFitSize(15), paint);
        canvas.drawText(String.format(context.getString(R.string.custom_sun_view_str_sunset), sunDown)
                , center + radius - getFitSize(125), height - (height - radius - (center - radius)) - getFitSize(15), paint);

    }

    public void refreshView() {
        if (TextUtils.isEmpty(sunDown) || TextUtils.isEmpty(sunRise)) {
            return;
        }
        int sunRiseH = Integer.parseInt(sunRise.split(":")[0]);
        int sunRiseM = Integer.parseInt(sunRise.split(":")[1]);
        int sunDownH = Integer.parseInt(sunDown.split(":")[0]);
        int sunDownM = Integer.parseInt(sunDown.split(":")[1]);
        Calendar calendar = Calendar.getInstance();
        long now = calendar.getTimeInMillis();
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.HOUR_OF_DAY, sunRiseH);
        calendar.set(Calendar.MINUTE, sunRiseM);
        long start = calendar.getTimeInMillis();
        calendar.set(Calendar.HOUR_OF_DAY, sunDownH);
        calendar.set(Calendar.MINUTE, sunDownM);
        long end = calendar.getTimeInMillis();

        if (now > end) {
            progress = 1;
        } else if (now < start) {
            progress = 0;
        } else {
            progress = (now - start) * 1.00f / (end - start);
        }
        this.invalidate();
    }

    public void setProgress(float progress) {
        this.progress = progress;
        this.invalidate();
    }

    public void setSunRiseDowmTime(String sunRise, String sunDown) {
        this.sunRise = sunRise;
        this.sunDown = sunDown;
        refreshView();
    }


    private int getFitSize(int orgSize) {
        return orgSize * width / 1080;
    }
}
