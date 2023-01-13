package com.example.mvp;

import androidx.annotation.Nullable;

import java.util.Objects;

public class LoginActivityPresenter implements LoginActivityMVP.Presenter {

    @Nullable
    private  LoginActivityMVP.View view;
    private LoginActivityMVP.Model model;
    public LoginActivityPresenter() {
    }
    public LoginActivityPresenter(LoginActivityMVP.Model model){
      this.model = model ;
    }

    @Override
    public void setView(LoginActivityMVP.View view) {
        this.view = view;
    }

    @Override
    public void loginButtonClicked() {
        if(view!=null){
            if(Objects.equals(view.getFirstName().trim(), "") ||Objects.equals(view.getLastName().trim(), "") ){
                view.showInputError();
            }else {
                model.createUser(view.getFirstName(),view.getLastName());
                view.showUserSavedMessage();
            }
        }
    }

    @Override
    public void getCurrentUser() {
        User user = model.getUser();
        if(user == null){
            if(view!=null){
                view.showUserNotAvailable();
            }
        }else {
            if(view!=null){
                view.setFirstName(user.getFname());
                view.setLastName(user.getLname());
            }
        }
    }
}
