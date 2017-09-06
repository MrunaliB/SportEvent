package com.example.lenovo.sporteventexample.event;

import com.example.lenovo.sporteventexample.BasePresenter;
import com.example.lenovo.sporteventexample.BaseView;
import com.example.lenovo.sporteventexample.data.Event;

/**
 * Created by LENOVO on 9/6/2017.
 */

public interface EventContract {

    interface View extends BaseView {

        void setUpdateButtonEnable(boolean enable);
        void setInputLayoutTitleError(String message);
        void setInputLayoutDescriptionError(String message);
        void setInputLayoutCityError(String message);
        void setInputLayoutVenueError(String message);
        void setInputLayoutStartDateError(String message);
        void setInputLayoutEndDateError(String message);
        void setUserProfileImage(String url);
        void setEventData(Event event);

    }





    interface Presenter extends BasePresenter {
        void onActivityStarted();
        void getEventData();
        void onActivityStopped();
        void onUpdateButtonClicked(String email, String password, String displayName, String phone);
        void setFormType(String formType);

    }

}