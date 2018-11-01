package com.example.josh.week2daily3_threads;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class ThreadTask extends AsyncTask<String, Integer, String> {

    ProgressBar pbCurrent;
    TextView tvCurrent;

    public ThreadTask(ProgressBar pbCurrent, TextView tvCurrent) {
        this.pbCurrent = pbCurrent;
        this.tvCurrent = tvCurrent;
    }

    public static final String TAG = "_TAG";


    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        pbCurrent.setProgress(values[0]);
        tvCurrent.setText("Loading");
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        tvCurrent.setText("Finished");

    }

    @Override
    protected String doInBackground(String... strings) {
        int time = getTime();
        Log.d(TAG, "doInBackground: " + time);
        for (int i = 0; i <= 100; i++) {
            publishProgress(i);
            try {
                Thread.sleep(time * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Finished Background";
    }
    public int getTime(){
        Random rand = new Random();
        return rand.nextInt(10) + 1;
    }


}
