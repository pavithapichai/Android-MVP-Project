package com.example.mvp;

public interface LoginActivityMVP {
    interface View{
        String getFirstName();
        String getLastName();

        void setFirstName(String fname);
        void setLastName(String lname);

        void showInputError();
        void showUserNotAvailable();
        void showUserSavedMessage();

    }
    interface Presenter{
        void setView(LoginActivityMVP.View view);
        void loginButtonClicked();
        void getCurrentUser();
    }
    interface Model{
        void createUser(String fname,String lname);
        User getUser();
    }
}
