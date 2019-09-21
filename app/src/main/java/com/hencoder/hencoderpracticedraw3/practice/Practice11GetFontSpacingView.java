package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class Practice11GetFontSpacingView extends View {
    private static final String TAG = "Practice11GetFontSpacin";
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    String text = "Hello HenCoder";
    float textHeight;
    public Practice11GetFontSpacingView(Context context) {
        super(context);
    }

    public Practice11GetFontSpacingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11GetFontSpacingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setTextSize(60);
        textHeight = paint.getFontSpacing();
        Log.d(TAG, "instance initializer: "+textHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 Paint.getFontSpacing() 来获取推荐的行距

       
        canvas.drawText(text, 50, 100, paint);

        canvas.drawText(text, 50, 100 +textHeight, paint);

        canvas.drawText(text, 50, 100  +textHeight*2, paint);
    }
}
