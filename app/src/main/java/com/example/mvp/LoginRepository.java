package com.example.mvp;

public interface LoginRepository {
    User getUser();
    void saveUser(User user);
}
