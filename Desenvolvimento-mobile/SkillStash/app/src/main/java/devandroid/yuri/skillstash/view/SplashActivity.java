package devandroid.yuri.skillstash.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import devandroid.yuri.skillstash.R;

public class SplashActivity extends AppCompatActivity {

    public static final int TIME_OUT_SPLASH = 5000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TelaSpash();

    }

    private void TelaSpash(){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                Intent telaPrincipal = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(telaPrincipal);
                finish();

            }
        },TIME_OUT_SPLASH);

    }


}