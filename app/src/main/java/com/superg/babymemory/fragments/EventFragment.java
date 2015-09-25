package com.superg.babymemory.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by rxy on 2015-09-24.
 */
public class EventFragment extends Fragment {

    private static final String TAG="EventFragment";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if(isVisibleToUser){
            Log.d(TAG,"It is already visible to user,you can load now.");
        }
        super.setUserVisibleHint(isVisibleToUser);
    }
}
