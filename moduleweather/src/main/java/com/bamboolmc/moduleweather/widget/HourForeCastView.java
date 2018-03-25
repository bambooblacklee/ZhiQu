package com.bamboolmc.moduleweather.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import com.bamboolmc.moduleweather.module.forecast.WeatherMZEntity;
import com.bamboolmc.moduleweather.util.ScreenUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by limc on 18/3/11.
 */
public class HourForeCastView extends View {
    private final static String TAG = "HourForeCastView";
    Paint paint = new Paint();
    float widthAvg;
    private float height, width;
    private List<WeatherMZEntity.WeatherDetailsInfoBean.Weather24HoursDetailsInfosBean> hourForeCasts = new ArrayList<>();
    private int tempH, tempL;
    private Context context;
    private float radius = 0;
    private float leftRight = 0;

    public HourForeCastView(Context context) {
        super(context);
        this.context = context;
    }

    public HourForeCastView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public HourForeCastView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        width = ScreenUtil.getScreenWidth(context);
        height = width / 2 - getFitSize(20);
        widthAvg = getFitSize(200);
        radius = getFitSize(8);
        setMeasuredDimension((int) leftRight + (int) widthAvg * 25, (int) height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (hourForeCasts.size() == 0) {
            return;
        }
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(0);
        paint.setTextSize(ScreenUtil.getSp(context, 13));
        paint.setTextAlign(Paint.Align.CENTER);

        float weatherDetailPadding = getFitSize(50);
        float weatherTimePadding = getFitSize(100);
        float linePaddingBottom = getFitSize(200);
        float lineHeight = getFitSize(180);

        float lineAvg = lineHeight / getMaxMinDelta();

        float paddingLeft = 0;
        //解决path多大无法绘制,分三段
        Path tempPath = new Path();
        Path tempPath2 = new Path();
        Path tempPath3 = new Path();

        int i = 1;
        for (WeatherMZEntity.WeatherDetailsInfoBean.Weather24HoursDetailsInfosBean forecast : hourForeCasts) {
            paddingLeft = leftRight / 2 + (i - 1 + 0.5f) * widthAvg;
            if (i == 1) {
                tempPath.moveTo(paddingLeft, height - (linePaddingBottom + (Integer.parseInt(forecast.getHighestTemperature()) - tempL) * lineAvg));
            } else if (i > 1 && i <= 10) {
                tempPath.lineTo(paddingLeft, height - (linePaddingBottom + (Integer.parseInt((forecast.getHighestTemperature())) - tempL) * lineAvg));
                tempPath2.moveTo(paddingLeft, height - (linePaddingBottom + (Integer.parseInt(forecast.getHighestTemperature()) - tempL) * lineAvg));
            } else if (i > 10 && i <= 20) {
                tempPath2.lineTo(paddingLeft, height - (linePaddingBottom + (Integer.parseInt(forecast.getHighestTemperature()) - tempL) * lineAvg));
                tempPath3.moveTo(paddingLeft, height - (linePaddingBottom + (Integer.parseInt(forecast.getHighestTemperature()) - tempL) * lineAvg));
            } else {
                tempPath3.lineTo(paddingLeft, height - (linePaddingBottom + (Integer.parseInt(forecast.getHighestTemperature()) - tempL) * lineAvg));
            }
            paint.setStyle(Paint.Style.FILL);
            paint.setStrokeWidth(getFitSize(2));
            canvas.drawCircle(paddingLeft, height - (linePaddingBottom + (Integer.parseInt(forecast.getHighestTemperature()) - tempL) * lineAvg), radius, paint);
            paint.setStrokeWidth(0);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawText(Integer.parseInt(forecast.getHighestTemperature()) + "°", paddingLeft, height - (getFitSize(20) + linePaddingBottom + (Integer.parseInt(forecast.getHighestTemperature()) - tempL) * lineAvg), paint);

            //文字
            canvas.drawText(forecast.getWeather(), paddingLeft, height - weatherDetailPadding, paint);
            canvas.drawText(forecast.getStartTime().split(" ")[1].substring(0, 5), paddingLeft, height - weatherTimePadding, paint);
            i++;
        }
        paint.setStrokeWidth(getFitSize(3));
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(tempPath, paint);
        canvas.drawPath(tempPath2, paint);
        canvas.drawPath(tempPath3, paint);
    }


    private int getMaxMinDelta() {
        if (hourForeCasts.size() > 0) {
            tempL = Integer.parseInt(hourForeCasts.get(0).getLowerestTemperature());
            tempH = Integer.parseInt(hourForeCasts.get(0).getHighestTemperature());
            for (WeatherMZEntity.WeatherDetailsInfoBean.Weather24HoursDetailsInfosBean hourForeCast : hourForeCasts) {
                if (Integer.parseInt(hourForeCast.getHighestTemperature()) > tempH) {
                    tempH = Integer.parseInt(hourForeCast.getHighestTemperature());
                }
                if (Integer.parseInt(hourForeCast.getHighestTemperature()) < tempL) {
                    tempL = Integer.parseInt(hourForeCast.getHighestTemperature());
                }
            }
            return tempH - tempL;
        }
        return 0;
    }

    public void setHourForeCasts(List<WeatherMZEntity.WeatherDetailsInfoBean.Weather24HoursDetailsInfosBean> hourForeCasts){
        this.hourForeCasts.clear();
        this.hourForeCasts.addAll(hourForeCasts);
        this.invalidate();
    }

    private float getFitSize(float orgSize) {
        return orgSize * width * 1.0f / 1080;
    }
}
