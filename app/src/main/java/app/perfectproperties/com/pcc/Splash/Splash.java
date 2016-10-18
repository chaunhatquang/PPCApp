package app.perfectproperties.com.pcc.Splash;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import app.perfectproperties.com.pcc.Main.HomePage;
import app.perfectproperties.com.pcc.R;

public class Splash extends AppCompatActivity {
    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        timer = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                Intent activity1Intent = new Intent(Splash.this,HomePage.class);
                startActivity(activity1Intent);
            }
        }.start();
    }
}
