package com.example.lenovo.sporteventexample.event;

import android.net.Uri;

import com.example.lenovo.sporteventexample.BasePresenter;
import com.example.lenovo.sporteventexample.BaseView;


/**
 * Created by root on 29/3/17.
 */

public interface EventContract {

    interface View extends BaseView {
        void setInputLayoutEmailError(String message);
        void setInputLayoutPasswordError(String message);
        void setInputLayoutUsernameError(String message);
        void setInputLayoutPrimaryContactError(String message);
        void setInputLayoutDobError(String message);
        void setUserProfileImage(String url);
        void setUpdateButtonEnable(boolean enable);


    }

    interface Presenter extends BasePresenter {
        void onActivityStarted();
        void getUserData();
        void getStudentData();
        void onActivityStopped();
        void onUpdateButtonClicked(String email, String password, String displayName, String phone);
        void setFormType(String formType);

    }
}

