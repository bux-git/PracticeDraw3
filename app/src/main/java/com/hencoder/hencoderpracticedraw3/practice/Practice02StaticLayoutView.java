package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

public class Practice02StaticLayoutView extends View {
    TextPaint textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
    String text = "Hello\nHenCoder";

    StaticLayout mLayout1;
    StaticLayout mLayout2;
    StaticLayout mLayout3;
    public Practice02StaticLayoutView(Context context) {
        super(context);
    }

    public Practice02StaticLayoutView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02StaticLayoutView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        textPaint.setTextSize(60);
        mLayout1 = new StaticLayout(text,textPaint,300, Layout.Alignment.ALIGN_NORMAL,1,0,true);
        mLayout2 = new StaticLayout(text,2,4,textPaint,300, Layout.Alignment.ALIGN_CENTER,1,0,true);
        mLayout3 = new StaticLayout(text,textPaint,100, Layout.Alignment.ALIGN_OPPOSITE,1,0,true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 StaticLayout 代替 Canvas.drawText() 来绘制文字，
        // 以绘制出带有换行的文字
       // canvas.drawText(text, 50, 100, textPaint);
        canvas.save();
        canvas.translate(50,50);
        mLayout1.draw(canvas);

        canvas.translate(0,150);
        mLayout2.draw(canvas);

        canvas.translate(0,150);
        mLayout3.draw(canvas);
        canvas.restore();
    }
}
