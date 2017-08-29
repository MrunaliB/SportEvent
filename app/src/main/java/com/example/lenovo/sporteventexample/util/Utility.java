package com.example.lenovo.sporteventexample.util;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.gilidanda.app.R;
import com.soundcloud.android.crop.Crop;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Logger;

import static com.google.common.base.Preconditions.checkNotNull;


/**
 * Created by Mrunali on 8/29/17.
 */

public class Utility {
    private static final String TAG = "Utility";

    public static void addFragmentToActivity(@NonNull
                                                     FragmentManager fragmentManager,
                                             @NonNull
                                                     Fragment fragment, int frameId) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment);
        transaction.commit();
    }

    public static void setImage(Context context, final ImageView imageView, String url) {
        if (!((AppCompatActivity) context).isFinishing()) {
            Glide.with(context).load(url).listener(new RequestListener<String, GlideDrawable>() {
                @Override
                public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                    Log.d(TAG,
                            "onException() called with: e = [" + e + "], model = [" + model + "], target = [" + target + "], isFirstResource = [" + isFirstResource + "]");
                    return false;
                }

                @Override
                public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache,
                                               boolean isFirstResource) {
                    imageView.setImageDrawable(resource);
                    return false;
                }
            })

                    .diskCacheStrategy(
                            DiskCacheStrategy.ALL).placeholder(R.drawable.loading_stub).dontAnimate().into(imageView);
        }
    }

    public static String getUTC8601Timestamp() {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
        df.setTimeZone(tz);
        return df.format(new Date());
    }

    /**
     * This method converts dp unit to equivalent pixels, depending on device density.
     *
     * @param dp      A value in dp (density independent pixels) unit. Which we need to convert into pixels
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent px equivalent to dp depending on device density
     */
    public static float convertDpToPixel(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }

    /**
     * This method converts device specific pixels to density independent pixels.
     *
     * @param px      A value in px (pixels) unit. Which we need to convert into db
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent dp equivalent to px value
     */
    public static float convertPixelsToDp(float px, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float dp = px / ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return dp;
    }

    public static void beginSquareCrop(String id, Uri source, AppCompatActivity activity) {
        String filename = generateImageFilename(id, "");
        Logger.d(TAG, String.format("Filename %s", filename));
        if (filename != null) {
            Uri destination = Uri.fromFile(new File(activity.getCacheDir(), filename));
            Crop.of(source, destination).asSquare().start(activity);
        } else {
            Toast.makeText(activity, Constants.ERR_MSG_RETRIEVING_DATA, Toast.LENGTH_SHORT).show();
        }
    }

    public static String generateImageFilename(String id, String fileExtension) {
        if (id != null && fileExtension != null) {
            StringBuilder sb = new StringBuilder(id);
            sb.append(Constants.PROFILE_IMAGE)
                    .append(System.currentTimeMillis());
            if (fileExtension != null && fileExtension.length() > 0) {
                sb.append(".").append(fileExtension);
                return sb.toString();
            } else {
                return sb.toString();
            }
        } else {
            return null;
        }
    }

    public static boolean validatePhoneNumber(String number) {
        if (number.matches(Constants.REGEX_PHONE_INDIA)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validateDate(String dob) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date myDate;
        try {
            myDate = dateFormat.parse(dob);
            Date currentDate = Calendar.getInstance().getTime();

            if (myDate.after(currentDate)) {
                return false;
            }
            String myText = myDate.getDate() + "-" + (myDate.getMonth() + 1) + "-" + (1900 + myDate.getYear());
            Log.i(TAG, myText);
            return true;
        } catch (ParseException e) {
            Logger.e(TAG, e.getMessage(), e);
            return false;
        }
    }

    public static List<String> getStringList(List<Object> list) {
        if (list != null) {
            List<String> stringList = new ArrayList<String>();
            for (Object o : list
                    ) {
                stringList.add((String) o);
            }
            return stringList;
        }
        return null;
    }
}

