package d.tony.test2;

import android.content.Intent;
import android.gesture.Gesture;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    private GestureDetectorCompat gestureObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gestureObject = new GestureDetectorCompat(this, new LearnGesture());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureObject.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class LearnGesture extends GestureDetector.SimpleOnGestureListener {
        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            boolean result = false;
            try {
                float diffY = e2.getY() - e1.getY();
                float diffX = e2.getX() - e1.getX();
                if (Math.abs(diffX) > Math.abs(diffY)) {
                    if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) { //onSwipeRight
                /////////////////////////////////////////////////////////////////////////////////////
                            Intent intent = new Intent(
                                    MainActivity.this,Main2Activity.class);
                            finish();
                            startActivity(intent);
                 /////////////////////////////////////////////////////////////////////////////:
                        } else {  //onSwipeLeft
            ///////////////////////////////////////////////////////////////////////////////////////////
                            Intent intent = new Intent(
                                    MainActivity.this,Main3Activity.class);
                            finish();
                            startActivity(intent);
              ///////////////////////////////////////////////////////////////////////////////////////////
                        }
                        result = true;
                    }
                }
                else if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffY > 0) { //onSwipeBottom
           ////////////////////////////////////////////////////////////////////////////////////////////////////////:
                        Intent intent = new Intent(
                                MainActivity.this,Main4Activity.class);
                        finish();
                        startActivity(intent);
            ////////////////////////////////////////////////////////////////////////////////////////////////////:
                    } else {//onSwipeTop
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////::
                        Intent intent = new Intent(
                                MainActivity.this,Main5Activity.class);
                        finish();
                        startActivity(intent);
     ///////////////////////////////////////////////////////////////////////////////////////////////////////////////::::
                    }
                    result = true;
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return result;
        }
    }
}


