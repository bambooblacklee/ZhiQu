package com.bamboolmc.moduleweather.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;

import com.bamboolmc.moduleweather.module.forecast.WeatherMZEntity;
import com.bamboolmc.moduleweather.util.DateTimeUtil;
import com.bamboolmc.moduleweather.util.ScreenUtil;
import com.bamboolmc.moduleweather.util.WeatherIconUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by limc on 18/3/11.
 */
public class WeekForecastView extends View {

    private final static String TAG = "ForeCastView";
    private float height, width;
    private Paint paint = new Paint();
    private Context context;
    private float maxMinDelta;
    private int tempH, tempL;
    private float radius = 0;
    private float leftRight;
    private int lineType = 0;
    private List<PointF> mPointHs = new ArrayList<>();
    private List<PointF> mPointLs = new ArrayList<>();
    private List<PointF> mMidPoints = new ArrayList<>();
    private List<PointF> mMidMidPoints = new ArrayList<>();
    private List<PointF> mControlPoints = new ArrayList<>();
    private List<WeatherMZEntity.WeathersBean> foreCasts = new ArrayList<>();


    public WeekForecastView(Context context) {
        super(context);
        this.context = context;
    }

    public WeekForecastView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public WeekForecastView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        width = ScreenUtil.getScreenWidth(context);
        height = width - getFitSize(360);
        leftRight = getFitSize(30);
        radius = getFitSize(8);
        setMeasuredDimension((int) width, (int) height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (foreCasts.size() == 0) {
            return;
        }
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(0);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(ScreenUtil.getSp(context, 12));
        drawWeahterDetail(canvas);
    }

    private void drawWeahterDetail(Canvas canvas) {
        float weekPaddingBottom = getFitSize(200);
        float weekInfoPaddingBottom = getFitSize(40);
        float linePaddingBottom = getFitSize(330);
        float tempPaddingTop = getFitSize(20);
        float tempPaddingBottom = getFitSize(45);

        //每天天气所占空间
        float lineHigh = getFitSize(320);
        float widthAvg = (width - leftRight) / foreCasts.size();
        float heightAvg = lineHigh / maxMinDelta;

        Matrix matrix = new Matrix();
        matrix.postScale(0.45f, 0.45f);

        Path pathTempHigh = new Path();
        Path pathTempLow = new Path();

        mPointHs.clear();
        mPointLs.clear();

        float paddingLeft = 0;
        int i = 1;
        for (WeatherMZEntity.WeathersBean forecast : foreCasts) {
            paddingLeft = leftRight / 2 + (i - 1 + 0.5f) * widthAvg;
            if (lineType == 0) {
                if (i == 1) {
                    pathTempHigh.moveTo(paddingLeft, height - (linePaddingBottom + (Integer.parseInt(forecast.getTemp_day_c()) - tempL) * heightAvg));
                    pathTempLow.moveTo(paddingLeft, height - (linePaddingBottom + (Integer.parseInt(forecast.getTemp_night_c()) - tempL) * heightAvg));
                } else {
                    pathTempHigh.lineTo(paddingLeft, height - (linePaddingBottom + (Integer.parseInt(forecast.getTemp_day_c()) - tempL) * heightAvg));
                    pathTempLow.lineTo(paddingLeft, height - (linePaddingBottom + (Integer.parseInt(forecast.getTemp_night_c()) - tempL) * heightAvg));
                }
                paint.setStyle(Paint.Style.FILL);
                paint.setStrokeWidth(getFitSize(2));
                canvas.drawCircle(paddingLeft, height - (linePaddingBottom + (Integer.parseInt(forecast.getTemp_day_c()) - tempL) * heightAvg), radius, paint);
                canvas.drawCircle(paddingLeft, height - (linePaddingBottom + (Integer.parseInt(forecast.getTemp_night_c()) - tempL) * heightAvg), radius, paint);
            } else {
                PointF pointFH = new PointF(paddingLeft, height - (linePaddingBottom + (Integer.parseInt(forecast.getTemp_day_c()) - tempL) * heightAvg));
                mPointHs.add(pointFH);
                PointF pointFL = new PointF(paddingLeft, height - (linePaddingBottom + (Integer.parseInt(forecast.getTemp_night_c()) - tempL) * heightAvg));
                mPointLs.add(pointFL);
            }
            //温度数
            paint.setStrokeWidth(0);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawText(forecast.getTemp_day_c() + "°", paddingLeft, height - (linePaddingBottom + tempPaddingTop + (Integer.parseInt(forecast.getTemp_day_c()) - tempL) * heightAvg), paint);
            canvas.drawText(forecast.getTemp_night_c() + "°", paddingLeft, height - (linePaddingBottom - tempPaddingBottom + (Integer.parseInt(forecast.getTemp_night_c()) - tempL) * heightAvg), paint);

            //星期
            canvas.drawText(DateTimeUtil.getWeekOfDate(forecast.getDate()), paddingLeft, height - (weekPaddingBottom), paint);
            //天气图标
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), WeatherIconUtil.getWeatherIconID(forecast.getWeather()));
            Bitmap bitmapDisplay = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);

            canvas.drawBitmap(bitmapDisplay,
                    paddingLeft - bitmapDisplay.getWidth() / 2, height - getFitSize(8) - ((weekPaddingBottom - weekInfoPaddingBottom) / 2 + weekInfoPaddingBottom) - bitmapDisplay.getHeight() / 2, paint);

            bitmap.recycle();
            bitmapDisplay.recycle();

            //天气描述
            canvas.drawText(forecast.getWeather(), paddingLeft, height - (weekInfoPaddingBottom), paint);
            i++;
        }
        paint.setStrokeWidth(getFitSize(3));
        paint.setStyle(Paint.Style.STROKE);
        if (lineType == 0) {
            canvas.drawPath(pathTempHigh, paint);
            canvas.drawPath(pathTempLow, paint);
        } else {
            resetMidPoints(this.mPointHs);
            resetMidMidPoints();
            resetControlPoints(this.mPointHs);
            drawBezier(canvas, pathTempHigh, mPointHs);

            resetMidPoints(this.mPointLs);
            resetMidMidPoints();
            resetControlPoints(this.mPointLs);
            drawBezier(canvas, pathTempLow, mPointLs);
        }

    }

    private int getMaxMinDelta() {
        if (foreCasts.size() > 0) {
            tempH = Integer.parseInt(foreCasts.get(0).getTemp_day_c());
            tempL = Integer.parseInt(foreCasts.get(0).getTemp_night_c());
            for (WeatherMZEntity.WeathersBean weekForeCast : foreCasts) {
                if (Integer.parseInt(weekForeCast.getTemp_day_c()) > tempH) {
                    tempH = Integer.parseInt(weekForeCast.getTemp_day_c());
                }
                if (Integer.parseInt(weekForeCast.getTemp_night_c()) < tempL) {
                    tempL = Integer.parseInt(weekForeCast.getTemp_night_c());
                }
            }
            return tempH - tempL;
        }
        return 0;
    }

    public void setForeCasts(List<WeatherMZEntity.WeathersBean> foreCasts) {
        this.foreCasts.clear();
        this.foreCasts.addAll(foreCasts);
        maxMinDelta = getMaxMinDelta();
        this.invalidate();
    }

    private float getFitSize(float orgSize) {
        return orgSize * width * 1.0f / 1080;
    }

    /**
     * 画贝塞尔曲线
     */
    private void drawBezier(Canvas canvas, Path path, List<PointF> points) {
        path.reset();
        for (int i = 0; i < points.size(); i++) {
            if (i == 0) {// 第一条为二阶贝塞尔
                path.moveTo(points.get(i).x, points.get(i).y);// 起点
                path.quadTo(mControlPoints.get(i).x, mControlPoints.get(i).y,// 控制点
                        points.get(i + 1).x, points.get(i + 1).y);
            } else if (i < points.size() - 2) {// 三阶贝塞尔
                path.cubicTo(mControlPoints.get(2 * i - 1).x, mControlPoints.get(2 * i - 1).y,// 控制点
                        mControlPoints.get(2 * i).x, mControlPoints.get(2 * i).y,// 控制点
                        points.get(i + 1).x, points.get(i + 1).y);// 终点
            } else if (i == points.size() - 2) {// 最后一条为二阶贝塞尔
                path.moveTo(points.get(i).x, points.get(i).y);// 起点
                path.quadTo(mControlPoints.get(mControlPoints.size() - 1).x, mControlPoints.get(mControlPoints.size() - 1).y,
                        points.get(i + 1).x, points.get(i + 1).y);// 终点
            }
        }
        canvas.drawPath(path, paint);
    }

    /**
     * 初始化中点集合
     */
    private void resetMidPoints(List<PointF> points) {
        mMidPoints.clear();
        for (int i = 0; i < points.size() - 1; i++) {
            PointF midPoint = new PointF((points.get(i).x + points.get(i + 1).x) / 2, (points.get(i).y + points.get(i + 1).y) / 2);
            mMidPoints.add(midPoint);
        }
    }

    /**
     * 初始化中点的中点集合
     */
    private void resetMidMidPoints() {
        mMidMidPoints.clear();
        for (int i = 0; i < mMidPoints.size() - 1; i++) {
            PointF midMidPoint = new PointF((mMidPoints.get(i).x + mMidPoints.get(i + 1).x) / 2, (mMidPoints.get(i).y + mMidPoints.get(i + 1).y) / 2);
            mMidMidPoints.add(midMidPoint);
        }
    }

    /**
     * 初始化控制点集合
     */
    private void resetControlPoints(List<PointF> points) {
        mControlPoints.clear();
        for (int i = 1; i < points.size() - 1; i++) {
            PointF before = new PointF();
            PointF after = new PointF();
            before.x = mMidPoints.get(i - 1).x;
            before.y = mMidPoints.get(i - 1).y + points.get(i).y - mMidMidPoints.get(i - 1).y;
            after.x = mMidPoints.get(i).x;
            after.y = mMidPoints.get(i).y + points.get(i).y - mMidMidPoints.get(i - 1).y;
            mControlPoints.add(before);
            mControlPoints.add(after);
        }
    }
}
