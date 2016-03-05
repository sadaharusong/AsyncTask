package com.example.asynctask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		MyAsyncTask task = new MyAsyncTask();
		task.execute();
	}
	
	public void loadImage(View view)
	{
		startActivity(new Intent(this,ImageText.class));
	}
	
}
