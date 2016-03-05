package com.example.asynctask;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URLConnection;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import java.net.URL;

public class ImageText extends Activity{
	
	private ImageView imageView;
	private ProgressBar progressBar;
	private static String URL =
			"http://img5.duitang.com/uploads/item/201109/29/20110929214317_tKziz.jpg";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image);
		imageView = (ImageView) findViewById(R.id.image);
		progressBar = (ProgressBar) findViewById(R.id.pro_but);
		
	}
	class MyAsycTask extends AsyncTask<String, Void, Bitmap>{

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			progressBar.setVisibility(View.VISIBLE); //显示进度条
		}
		
		@Override
		protected void onPostExecute(Bitmap bitmap) {
			// TODO Auto-generated method stub
			super.onPostExecute(bitmap);
			imageView.setImageBitmap(bitmap);
			progressBar = (ProgressBar) findViewById(R.id.pro_but);
			//设置传递进去的参数
			new MyAsycTask().execute(URL);
		}
		
		@Override
		protected Bitmap doInBackground(String... params) {
			// TODO Auto-generated method stub
			String url = params[0];
			Bitmap bitmap = null;
			URLConnection connection;
			InputStream is;
			try {
				connection = new URL(url).openConnection();
				is = connection.getInputStream();
				BufferedInputStream bis = new BufferedInputStream(is);
				bitmap = BitmapFactory.decodeStream(bis);
				is.close();
				bis.close();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return bitmap;
		}
	}
}
