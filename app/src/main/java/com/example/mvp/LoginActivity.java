package com.example.mvp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.mvp.databinding.ActivityLoginBinding;

import com.example.mvp.root.MVPApp;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements LoginActivityMVP.View {
    @Inject
    LoginActivityMVP.Presenter presenter;
    ActivityLoginBinding binding;
    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);

        ((MVPApp) getApplication()).getApplicationComponent().inject(this);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.loginButtonClicked();
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        presenter.setView(this);
        presenter.getCurrentUser();
    }

    @Override
    public String getFirstName() {
        return binding.name.getText().toString();
    }

    @Override
    public String getLastName() {
        return binding.lname.getText().toString();
    }

    @Override
    public void setFirstName(String fname) {
        binding.name.setText(fname);
    }

    @Override
    public void setLastName(String lname) {
        binding.lname.setText(lname);

    }

    @Override
    public void showInputError() {
        Toast.makeText(this, "Firstname lastname cannot be empty", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUserNotAvailable() {
        Toast.makeText(this, "Error : User is not Available", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUserSavedMessage() {
        Toast.makeText(this , "User Saved!", Toast.LENGTH_SHORT).show();
    }
}
