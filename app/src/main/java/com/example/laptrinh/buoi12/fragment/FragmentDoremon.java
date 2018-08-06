package com.example.laptrinh.buoi12.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.laptrinh.buoi12.R;

/**
 * Created by Lap trinh on 4/23/2017.
 */

public class FragmentDoremon extends Fragment{
    private static final String TAG = "FragmentDoremon";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG,"onCreateView");
        return inflater.inflate(R.layout.fragment_doremon,container,false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"onDestroy");
    }
}
