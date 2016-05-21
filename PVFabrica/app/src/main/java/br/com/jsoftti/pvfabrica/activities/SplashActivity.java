package br.com.jsoftti.pvfabrica.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.jsoftti.pvfabrica.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent it = new Intent(SplashActivity.this,PrincipalActivity.class);
                startActivity(it);
                finish();
            }
        },3000);
    }
}
