package com.example.chef_app;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.ProgressBar;

public class SplashScreen extends Activity {
	private static int DELAY_MILLI_SECONDS = 4000;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				Intent i = new Intent(SplashScreen.this, MenuScreen.class);
				startActivity(i);
				finish();
			}
		}, DELAY_MILLI_SECONDS);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash_screen, menu);
		return true;
	}

}
