package com.example.recyclerviewexample.tools;

import android.app.Activity;
import android.arch.lifecycle.ViewModel;

public abstract class BindingViewModel extends ViewModel {

    public void setActivityType(Activity activity){}
    /*Lifecycle*/
    public void onStart() {}
    public void onResume(){}
    public void onPause(){}
    public void onStop() {}
    public void onDestroy() {}
}
