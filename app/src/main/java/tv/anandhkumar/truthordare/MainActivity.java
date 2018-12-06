package tv.anandhkumar.truthordare;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private ImageView imageView;
    private Random random = new Random();
    private int lastDirection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void spin(View view) {

        button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);

        int newDirection = random.nextInt(3600)+360;
        float pivotX = imageView.getWidth()/2;
        float pivotY = imageView.getHeight()/2;

        Animation rotate = new RotateAnimation(lastDirection,newDirection,pivotX,pivotY);
        rotate.setDuration(2000);
        rotate.setFillAfter(true);

        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                button.setEnabled(false);
                button.setBackgroundResource(R.drawable.button_disable);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                button.setEnabled(true);
                button.setBackgroundResource(R.drawable.cudtom_button);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        //lastDirection = newDirection;
        imageView.startAnimation(rotate);

    }
}
