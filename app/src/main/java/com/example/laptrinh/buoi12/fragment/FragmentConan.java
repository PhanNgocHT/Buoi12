package com.example.laptrinh.buoi12.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.laptrinh.buoi12.R;

/**
 * Created by Lap trinh on 4/23/2017.
 */

public class FragmentConan extends Fragment implements View.OnClickListener,Runnable {
    private static final String TAG = "FragmentConan";
    private static final int WHAT_TIME = 1;
    private Button btnStart;
    private TextView tvTime;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG,"onCreateView");
        return inflater.inflate(R.layout.fragment_conan,container,false);
    }

    @Override
    public void onStart() {
        super.onStart();
        btnStart = (Button)getActivity().findViewById(R.id.btnStart);
        tvTime = (TextView)getActivity().findViewById(R.id.tvTime);
        btnStart.setOnClickListener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"onDestroy");
    }

    @Override
    public void onClick(View view) {
        Thread thread = new Thread(this);
        thread.start();
        btnStart.setClickable(false);
    }

    @Override
    public void run() {
        for (int i = 10;i>=0;i--){
            Message message = new Message();
            message.what = WHAT_TIME;
            message.arg1 = i;
            handler.sendMessage(message);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == WHAT_TIME) {
                int time = msg.arg1;
                tvTime.setText(time+"");
                if (time == 0){
                    btnStart.setClickable(true);
                }
            }
        }
    };
}
