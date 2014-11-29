package pl.nataliajablonska.viewtouch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Malgorzata Jablonska on 2014-11-29.
 */
public class SingleTouchEventView extends View {

    private Path path = new Path();
    private Paint paint = new Paint();

    public SingleTouchEventView(Context context, AttributeSet attrs) {
        super(context, attrs);

       paint.setAntiAlias(true);
       paint.setStrokeWidth(6F);
       paint.setColor(Color.BLACK);
       paint.setStyle(Paint.Style.STROKE);
       paint.setStrokeJoin(Paint.Join.ROUND);



    }
    @Override
    protected void onDraw(Canvas canvas){
        canvas.drawPath(path,paint);

    }
    @Override
    public boolean onTouchEvent (MotionEvent event){
        float eventX = event.getX();
        float eventY = event.getY();
        int action = event.getAction();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(eventX,eventY);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(eventX,eventY);
                invalidate();
                return true;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                return true;

            default:
                return true;
        }

    }
}
