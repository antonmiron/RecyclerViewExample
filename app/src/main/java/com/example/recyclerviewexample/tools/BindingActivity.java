package com.example.recyclerviewexample.tools;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;

public abstract class BindingActivity <B extends ViewDataBinding, VM extends BindingViewModel> extends AppCompatActivity {
    private B binding;
    private VM viewModel;

    public void bind(int layoutId, Class<VM> vmClass){
        binding = DataBindingUtil.setContentView(this,layoutId);
        viewModel = VMFactory.obtainViewModel(this,vmClass);
    }

    public B getBinding() {
        return binding;
    }
    public VM getViewModel() {
        return viewModel;
    }


    @Override
    protected void onStart() {
        super.onStart();
        viewModel.onStart();
    }
    @Override
    protected void onResume() {
        super.onResume();
        viewModel.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        viewModel.onPause();
    }
    @Override
    protected void onStop() {
        super.onStop();
        viewModel.onStop();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.onDestroy();
    }
}
