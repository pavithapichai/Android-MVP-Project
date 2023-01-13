package com.example.mvp;

public class MemoryRepository implements LoginRepository{
    User user;
    @Override
    public User getUser() {
        if (user == null) {
        User user = new User ("Default","DefaultLast");
        user.setId(0);
        return user;

        }else {
            return user;
        }

    }

    @Override
    public void saveUser(User user) {
        if(user==null){
            user = getUser();
        }
        this.user = user;
    }
}
