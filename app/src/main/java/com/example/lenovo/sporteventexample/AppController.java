package com.example.lenovo.sporteventexample;

import android.app.Application;

import com.example.lenovo.sporteventexample.data.Event;
import com.example.lenovo.sporteventexample.util.Constants;
import com.example.lenovo.sporteventexample.util.SharedPreference;


/**
 * Created by root on 17/4/17.
 */

public class AppController extends Application {
    private Event event;

    @Override
    public void onCreate() {
        super.onCreate();
        Event event = Event.getInstance();
        event.setUserId(SharedPreference.getStringSharedPreference(this, Constants.KEY_USER_ID));
        setEvent(event);
    }


    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}


