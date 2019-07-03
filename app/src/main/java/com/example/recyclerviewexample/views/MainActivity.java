package com.example.recyclerviewexample.views;

import android.os.Bundle;

import com.example.recyclerviewexample.R;
import com.example.recyclerviewexample.tools.BindingActivity;
import com.example.recyclerviewexample.viewmodels.PersonViewModel;
import com.example.recyclerviewexample.databinding.ActivityMainBinding;

public class MainActivity extends BindingActivity<ActivityMainBinding, PersonViewModel> {
    private PersonViewModel personVM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind(R.layout.activity_main,PersonViewModel.class);

        ActivityMainBinding binding = getBinding();
        personVM = getViewModel();

        personVM.setActivityType(this);
        binding.setPersonVM(personVM);
    }
}
