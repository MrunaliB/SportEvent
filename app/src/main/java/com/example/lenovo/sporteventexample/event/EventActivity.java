package com.example.lenovo.sporteventexample.event;


import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.lenovo.sporteventexample.R;
import com.example.lenovo.sporteventexample.data.Event;
import com.example.lenovo.sporteventexample.util.Constants;
import com.example.lenovo.sporteventexample.util.Logger;
import com.example.lenovo.sporteventexample.util.SharedPreference;
import com.example.lenovo.sporteventexample.util.Utility;

import butterknife.Bind;
import butterknife.ButterKnife;


public class EventActivity extends AppCompatActivity implements EventContract.View, View.OnClickListener {

    public static final String TAG = "EventActivity";
    @Bind(R.id.user_appbar_layout)
    AppBarLayout appBarLayout;
    @Bind(R.id.collapsingLayout)
    CollapsingToolbarLayout collapsingLayout;
    @Bind(R.id.img_profile_image)
    ImageView profileImage;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.ll_container_layout)
    LinearLayout containerLayout;
    @Bind(R.id.input_layout_event_title)
    TextInputLayout inputLayoutEventTitle;
    @Bind(R.id.input_layout_primary_id)
    TextInputLayout inputLayoutPrimaryId;
    @Bind(R.id.input_event_title)
    TextInputEditText inputEventTitle;
    @Bind(R.id.input_primary_id)
    TextInputEditText inputPrimaryId;
    @Bind(R.id.input_layout_title)
    TextInputLayout inputLayoutTitle;
    @Bind(R.id.input_title)
    TextInputEditText inputTitle;
    @Bind(R.id.input_layout_description)
    TextInputLayout inputLayoutDescription;
    @Bind(R.id.input_description)
    TextInputEditText inputDescription;
    @Bind(R.id.crd_address_detail)
    CardView crdAddressDetail;
    @Bind(R.id.input_layout_city)
    TextInputLayout inputLayoutCity;
    @Bind(R.id.input_city)
    TextInputEditText inputCity;
    @Bind(R.id.input_layout_venue)
    TextInputLayout inputLayoutVenue;
    @Bind(R.id.input_venue)
    TextInputEditText inputVenue;
    @Bind(R.id.crd_date_detail)
    CardView crdDateDetail;
    @Bind(R.id.input_layout_start_date)
    TextInputLayout inputLayoutStartDate;
    @Bind(R.id.input_start_date)
    TextInputEditText inputStartDate;
    @Bind(R.id.input_layout_end_date)
    TextInputLayout inputLayoutEndDate;
    @Bind(R.id.input_end_date)
    TextInputEditText inputEndDate;
    @Bind(R.id.btn_update)
    Button btnUpdate;

    private String formType;
    private String userId;
    private Event event;
    private EventPresenter presenter;
    private String userRole;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        ButterKnife.bind(this);
        Bundle bundle = getIntent().getBundleExtra(Constants.KEY_BUNDLE);
        if (bundle != null) {
            if (bundle.containsKey(Constants.KEY_FORM_TYPE)) {
                formType = bundle.getString(Constants.KEY_FORM_TYPE);
            }
        }
        presenter = new EventPresenter(this, this);
        presenter.setFormType(formType);
        presenter.start();

         /*Check if the user is existing or new*/
        if (TextUtils.isEmpty(formType)) {
            Logger.d(TAG, "existing user");
            inputLayoutPrimaryId.setVisibility(View.GONE);
            /*get UserId if already exists*/
            userId = SharedPreference.getStringSharedPreference(EventActivity.this, Constants.KEY_USER_ID);
            userRole = SharedPreference.getStringSharedPreference(EventActivity.this, Constants.KEY_USER_ROLE);
            if (!TextUtils.isEmpty(userId)) {
                inputTitle.setEnabled(false);

                presenter.getEventData();
                appBarLayout.setExpanded(true, true);
            }
            if (userRole != null && !TextUtils.isEmpty(userRole)) {
                if (userRole.equals(Constants.ROLE_USER)) {

                    Event  event= new Event();
                    crdAddressDetail.setVisibility(View.VISIBLE);
                    crdDateDetail.setVisibility(View.VISIBLE);
                    presenter.getEventData();
                }
            }
        }

        btnUpdate.setOnClickListener(this);
    }



    @Override
    public void setInputLayoutTitleError(String message) {
        inputLayoutTitle.setError(message);
    }

    @Override
    public void setInputLayoutDescriptionError(String message) {
        inputLayoutDescription.setError(message);
    }


    @Override
    public void setInputLayoutCityError(String message) {
        inputLayoutCity.setError(message);
    }

    @Override
    public void setInputLayoutVenueError(String message) {
        inputLayoutVenue.setError(message);
    }

    @Override
    public void setInputLayoutStartDateError(String message) {
        inputLayoutStartDate.setError(message);
    }
    @Override
    public void setInputLayoutEndDateError(String message) {
        inputLayoutEndDate.setError(message);
    }
    @Override
    public void setUserProfileImage(String url) {
        Utility.setImage(this, profileImage, url);
    }


    @Override
    public void setEventData(Event event) {
        if (event != null) {
            inputTitle.setText(event.getTitle());
            inputDescription.setText(event.getDescription());
            inputVenue.setText(event.getVenue());
            inputCity.setText(event.getCity());
            inputStartDate.setText(event.getStartDate());
            inputEndDate.setText(event.getEndDate());

            if (event.getProfilePicture() != null) {
                Utility.setImage(EventActivity.this, profileImage, event.getProfilePicture());
                SharedPreference.setStringSharedPreference(EventActivity.this, Constants.KEY_USER_PROFILE_IMAGE, event.getProfilePicture());
            }
        }

    }

    @Override
    public void setPresenter(Object presenter) {

    }


    @Override
    protected void onStart() {
        super.onStart();
        presenter.onActivityStarted();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onActivityStopped();
    }

    public void resetErrors() {
        inputLayoutTitle.setError(null);
        inputLayoutDescription.setError(null);
        inputLayoutCity.setError(null);
        inputLayoutVenue.setError(null);
        inputLayoutStartDate.setError(null);
        inputLayoutEndDate.setError(null);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_update:
                resetErrors();
                presenter.onUpdateButtonClicked(inputTitle.getText().toString(), inputDescription.getText().toString(), inputCity.getText().toString(),
                        inputVenue.getText().toString(),inputStartDate.getText().toString(),inputEndDate.getText().toString());
            default:
                break;
        }
    }

    @Override
    public void setUpdateButtonEnable(boolean enable) {
        btnUpdate.setEnabled(enable);
    }
}




























