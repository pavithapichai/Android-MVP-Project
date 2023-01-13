package com.example.mvp;

public class LoginModel implements LoginActivityMVP.Model{
    private LoginRepository loginRepository;

    public LoginModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public void createUser(String fname, String lname) {
        loginRepository.saveUser(new User(fname,lname));
    }

    @Override
    public User getUser() {
        return loginRepository.getUser();
    }
}
