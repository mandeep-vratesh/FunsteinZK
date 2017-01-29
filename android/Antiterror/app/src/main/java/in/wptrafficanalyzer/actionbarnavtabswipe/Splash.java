package in.wptrafficanalyzer.actionbarnavtabswipe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Mandeep on 28/1/2017.
 */
public class Splash extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.splash);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        ImageView imageView3 = (ImageView) findViewById(R.id.imageView3);
        TextView be_alert = (TextView) findViewById(R.id.be_alert);
        TextView be_safe = (TextView) findViewById(R.id.be_safe);
        TextView be_safe_u = (TextView) findViewById(R.id.be_safe_u);
        TextView be_alert_u = (TextView) findViewById(R.id.be_alert_u);

        //TextView textView = (TextView) findViewById(R.id.textView);
        Animation an = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim_appear);
        imageView.startAnimation(an);
        Animation an2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim_appear2);
        imageView2.startAnimation(an2);
        Animation an3 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim_appear3);
        imageView3.startAnimation(an3);
        Animation an4 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translate_from_left);
        be_alert.startAnimation(an4);
        Animation an5 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translate_from_right);
        be_safe.startAnimation(an5);
        Animation an6 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translate_from_left_u);
        be_alert_u.startAnimation(an6);
        Animation an7 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translate_from_right_u);
        be_safe_u.startAnimation(an7);

        an7.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                finish();
                Intent i = new Intent(getBaseContext(),MainActivity.class);
                startActivity(i);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
