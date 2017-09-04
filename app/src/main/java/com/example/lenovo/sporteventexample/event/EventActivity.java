package com.example.lenovo.sporteventexample.event;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.SyncStateContract;
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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.lenovo.sporteventexample.R;
import com.example.lenovo.sporteventexample.data.Event;
import com.example.lenovo.sporteventexample.util.Constants;

import java.util.logging.Logger;

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
    @Bind(R.id.input_layout_name)
    TextInputLayout inputLayoutName;
    @Bind(R.id.input_layout_primary_id)
    TextInputLayout inputLayoutPrimaryId;
    @Bind(R.id.input_name)
    TextInputEditText inputName;
    @Bind(R.id.input_primary_id)
    TextInputEditText inputPrimaryId;
    @Bind(R.id.input_layout_title)
    TextInputEditText inputLayoutTitle;
    @Bind(R.id.input_title)
    TextInputEditText inputTitle;
    @Bind(R.id.input_layout_discription)
    TextInputEditText inputLayoutDiscription;
    @Bind(R.id.input_discription)
    TextInputEditText inputDiscription;
    @Bind(R.id.crd_address_detail)
    CardView crdAddressDetail;
    @Bind(R.id.input_layout_city)
    TextInputEditText inputLayoutCity;
    @Bind(R.id.input_city)
    TextInputEditText inputCity;
    @Bind(R.id.input_layout_venue)
    TextInputEditText inputLayoutVenue;
    @Bind(R.id.input_venue)
    TextInputEditText inputVenue;
    @Bind(R.id.crd_date_detail)
    CardView crdDateDetail;
    @Bind(R.id.input_layout_start_date)
    TextInputEditText inputLayoutStartDate;
    @Bind(R.id.input_start_date)
    TextInputEditText inputStartDate;
    @Bind(R.id.input_layout_end_date)
    TextInputEditText inputLayoutEndDate;
    @Bind(R.id.input_end_date)
    TextInputEditText inputEndDate;
    @Bind(R.id.btn_save)
    Button btnSave;
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
    }
}






























