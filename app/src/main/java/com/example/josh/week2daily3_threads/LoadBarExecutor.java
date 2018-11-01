package com.example.josh.week2daily3_threads;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class LoadBarExecutor extends ThreadPoolExecutor {
    public static final String TAG = "_TAG";
    BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(4);

    public LoadBarExecutor(BlockingQueue<Runnable> workQueue) {
        super(1, 6, 20, TimeUnit.MINUTES,workQueue);
    }


    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);

    }

    public void execute(ThreadTask threadTask) {
        threadTask.executeOnExecutor(this,"None");
    }
}
