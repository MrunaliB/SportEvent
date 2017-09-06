package com.example.lenovo.sporteventexample.event;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.lenovo.sporteventexample.AppController;

import com.example.lenovo.sporteventexample.R;
import com.example.lenovo.sporteventexample.data.Event;
import com.example.lenovo.sporteventexample.data.source.EventDataSource;
import com.example.lenovo.sporteventexample.util.Constants;
import com.example.lenovo.sporteventexample.util.SharedPreference;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;

import java.util.List;


public class EventPresenter implements EventContract.Presenter,Validator.ValidationListener {

    public static final String TAG = "EventPresenter";
    EventContract.View view;
    Context context;
    AppController appController;
    private Validator validator;
    private String userId;
    private String formType;
    private String title;
    private String description;
    private String city;
    private String venue;
    private String startDate;
    private String endDate;
    private ProgressDialog progressDialog;



    public EventPresenter(EventContract.View view, Context context) {
        this.view = view;
        this.context = context;
        this.appController = (AppController) ((AppCompatActivity) context).getApplication();

    }
    @Override
    public void onActivityStarted(){

    }
    @Override
    public void getEventData() {
      /*  eventRemoteRepository.getEvent(userId, new EventDataSource.GetEventCallback() {
            @Override
            public void onEventLoaded(Event event) {
                appController.setEvent(event);
                SharedPreference.setStringSharedPreference(context, Constants.KEY_USER_DISPLAY_TITLE, event.getTitle());
                SharedPreference.setStringSharedPreference(context, Constants.KEY_USER_PROFILE_IMAGE, event.getProfilePicture());
                view.setEventData(event);
                view.setUserProfileImage(event.getProfilePicture());
            }

            @Override
            public void onDataNotAvailable() {
                Toast.makeText(context, context.getString(R.string.txt_no_data), Toast.LENGTH_SHORT).show();
            }

        });*/
    }


    @Override
    public void onActivityStopped(){

    }
     @Override
     public   void onUpdateButtonClicked(String title, String description, String venue, String city,String startDate,String endDate){
        this.title=title;
         this.description=description;
         this.venue=venue;
         this.city=city;
         this.startDate=startDate;
         this.endDate=endDate;

         validator.validate();
     }

   @Override
   public void setFormType(String formType){
     this.formType=formType;
   }

    @Override
    public void saveEventData(Event event) {


        }

        @Override
    public void start() {
        userId = SharedPreference.getStringSharedPreference((EventActivity) context, Constants.KEY_USER_ID);
        validator = new Validator(context);
        validator.setValidationListener(this);
        progressDialog = new ProgressDialog(context);

    }



    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        view.setUpdateButtonEnable(true);
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(context);
            switch (view.getId()) {
                case R.id.input_title:
                    this.view.setInputLayoutTitleError(message);
                    break;
                case R.id.input_description:
                    this.view.setInputLayoutDescriptionError(message);
                    break;
                case R.id.input_city:
                    this.view.setInputLayoutCityError(message);
                    break;
                case R.id.input_start_date:
                    this.view.setInputLayoutStartDateError(message);
                    break;
                case R.id.input_end_date:
                    this.view.setInputLayoutEndDateError(message);
                    break;
                case R.id.input_venue:
                    this.view.setInputLayoutVenueError(message);
                    break;


                default:
                    break;
            }
        }
    }

    private void launchMainActivity() {
        Intent intent = new Intent(context, EventActivity.class);
        ((AppCompatActivity) context).startActivity(intent);
    }


}