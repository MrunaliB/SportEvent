package com.example.lenovo.sporteventexample;

import android.app.Application;

import com.gilidanda.app.data.User;
import com.gilidanda.app.util.Constants;
import com.gilidanda.app.util.SharedPreference;
import com.parse.Parse;

/**
 * Created by root on 17/4/17.
 */

public class AppController extends Application {

    private User user;
    @Override
    public void onCreate() {
        super.onCreate();
        // Initialize Parse SDK
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(Constants.PARSE_APP_ID)
                .clientKey(Constants.PARSE_CLIENT_KEY)
                .server(Constants.PARSE_SERVER_URL)
                .enableLocalDataStore()
                .build());
        User user = User.getInstance();
        user.setUserId(SharedPreference.getStringSharedPreference(this, Constants.KEY_USER_ID));
        setUser(user);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
