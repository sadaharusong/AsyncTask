package com.example.asynctask;

import android.os.AsyncTask;
import android.util.Log;

public class MyAsyncTask extends AsyncTask<Void	, Void	, Void>{

	@Override
	protected Void doInBackground(Void... params) {
		// TODO Auto-generated method stub
		Log.i("tag", "doInBackground");
		publishProgress(); 
		return null;
	}

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		Log.i("tag", "onPreExecute()");
		super.onPreExecute();
	}
	
	@Override
	protected void onPostExecute(Void result) {
		// TODO Auto-generated method stub
		Log.i("tag", "onPostExecute(Void result)");
		super.onPostExecute(result);
	}
	
	@Override
	protected void onProgressUpdate(Void... values) {
		// TODO Auto-generated method stub
		Log.i("tag", "onProgressUpdate");
		super.onProgressUpdate(values);
	}
}
