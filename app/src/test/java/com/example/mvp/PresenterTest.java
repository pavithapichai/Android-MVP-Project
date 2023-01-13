package com.example.mvp;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import androidx.constraintlayout.utils.widget.MockView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;


public class PresenterTest {

    LoginActivityMVP.Model model;
    LoginActivityMVP.Presenter presenter;
    LoginActivityMVP.View view;
    User user;
    @Before
    public void setUp(){
       model = mock(LoginActivityMVP.Model.class);
        //user = new User("testFirstNAme","testLastNAme");
       when(model.getUser()).thenReturn(user);
       view =   mock(LoginActivityMVP.View.class);
       presenter =new  LoginActivityPresenter(model);

       presenter.setView(view);
    }
    @Test
    public void noInteractionView(){
       // presenter.getCurrentUser();
        verifyNoInteractions(view);
    }
}
