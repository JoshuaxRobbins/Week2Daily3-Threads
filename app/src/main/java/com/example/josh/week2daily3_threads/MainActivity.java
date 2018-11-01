package com.example.josh.week2daily3_threads;

import android.media.tv.TvContract;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "_TAG";
    BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();

    private ProgressBar pbOne;
    private ProgressBar pbTwo;
    private ProgressBar pbThree;
    private ProgressBar pbFour;
    private TextView tvOne;
    private TextView tvTwo;
    private TextView tvThree;
    private TextView tvFour;
    int time = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        Log.d(TAG, "onCreate: " + Runtime.getRuntime().availableProcessors());

    }

    private void init() {
        pbOne = findViewById(R.id.pbOne);
        pbTwo = findViewById(R.id.pbTwo);
        pbThree = findViewById(R.id.pbThree);
        pbFour = findViewById(R.id.pbFour);
        tvOne = findViewById(R.id.tvOne);
        tvTwo = findViewById(R.id.tvTwo);
        tvThree = findViewById(R.id.tvThree);
        tvFour = findViewById(R.id.tvFour);
    }

    // super(4, 4, 20, TimeUnit.SECONDS, workQueue);
    public void startLoad(View view) {
        LoadBarExecutor loadBarExecutor = new LoadBarExecutor(workQueue);
        new ThreadTask(pbOne,tvOne).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        new ThreadTask(pbTwo,tvTwo).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        new ThreadTask(pbThree,tvThree).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        new ThreadTask(pbFour,tvFour).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        Log.d(TAG, "startLoad: ");
    }

}
