package com.irislu.administrator.drawingboard;

import android.app.Notification;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by Administrator on 2016-5-28.
 */
public class MyView extends SurfaceView implements SurfaceHolder.Callback,View.OnTouchListener {

    private Paint p = new Paint();//画笔
    private Path path = new Path();//画布
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getHolder().addCallback(this);
        p.setColor(Color.RED);
        p.setTextSize(30);
        p.setAntiAlias(true);
        p.setStyle(Paint.Style.STROKE);
        setOnTouchListener(this);
    }
    public void draw() {
        Canvas canvas = getHolder().lockCanvas();
        canvas.drawColor(Color.WHITE);
        canvas.drawPath(path, p);
        getHolder().unlockCanvasAndPost(canvas);
    }
    public void clear() {
        path.reset();
        draw();
    }

    public Paint getP() {
        return p;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        draw();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(event.getX(),event.getY());
                draw();
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(event.getX(),event.getY());
                draw();
                break;

        }
        return true;
    }
}
