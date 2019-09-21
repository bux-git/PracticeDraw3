package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class Practice13GetTextBoundsView extends View {
    private static final String TAG = "Practice13GetTextBounds";
    Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
    String text1 = "A";
    String text2 = "a";
    String text3 = "J";
    String text4 = "j";
    String text5 = "Â";
    String text6 = "â";
    int top = 200;
    int bottom = 400;

    public Practice13GetTextBoundsView(Context context) {
        super(context);
    }

    public Practice13GetTextBoundsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice13GetTextBoundsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    float m1;
    float m2;
    float m3;
    float m4;
    float m5;
    float m6;
    float metricsAsHeight;
    float metricsTBHeight;
    {
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeWidth(20);
        paint1.setColor(Color.parseColor("#E91E63"));
        paint2.setTextSize(160);

        m1 = getCenterY(text1);
        m2 = getCenterY(text2);
        m3 = getCenterY(text3);
        m4 = getCenterY(text4);
        m5 = getCenterY(text5);
        m6 = getCenterY(text6);

        Paint.FontMetrics fontMetrics = new Paint.FontMetrics();
        paint2.getFontMetrics(fontMetrics);
         metricsAsHeight = (fontMetrics.ascent + fontMetrics.descent);
         metricsTBHeight = (fontMetrics.top + fontMetrics.bottom);
        Log.d(TAG, "高度 fontMetrics: as:" + metricsAsHeight + " tb:" + metricsTBHeight);

    }

    private float getCenterY(String text) {
        Rect rect1 = new Rect();
        paint2.getTextBounds(text, 0, 1, rect1);
        Log.d(TAG, "高度: " + (rect1.top+rect1.bottom) +" 宽度:"+(rect1.left+rect1.right));

        return -(rect1.bottom + rect1.top) / 2f
                + (bottom + top) / 2f;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(50, top, getWidth() - 50, bottom, paint1);

        // 使用 Paint.getTextBounds() 计算出文字的显示区域
        // 然后计算出文字的绘制位置，从而让文字上下居中
        // 这种居中算法的优点是，可以让文字精准地居中，分毫不差


        canvas.drawPoint(100, m1, paint1);
        canvas.drawText(text1, 100, m1, paint2);
        canvas.drawText(text2, 200, m2, paint2);
        canvas.drawText(text3, 300, m3, paint2);
        canvas.drawText(text4, 400, m4, paint2);
        canvas.drawText(text5, 500, m5, paint2);
        canvas.drawText(text6, 600, m6, paint2);

        canvas.drawRect(50,m4+250,250,m4+250-metricsTBHeight,paint1);
        canvas.drawText(text4,0,1,50,m4+250-metricsTBHeight,paint2);
    }
}