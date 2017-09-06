package com.example.lenovo.sporteventexample.event;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.AutoCompleteTextView;

import com.example.lenovo.sporteventexample.AppController;

public class EventPresenter implements EventContract.Presenter {

    public static final String TAG = "EventPresenter";
    EventContract.View view;
    Context context;
    AppController appController;
    private AutoCompleteTextView.Validator validator;
    private String userId;
    private String formType;
    private String email;
    private String password;
    private String displayName;
    private String phone;
    private ProgressDialog progressDialog;


    public EventPresenter(EventContract.View view, Context context) {


    }
}