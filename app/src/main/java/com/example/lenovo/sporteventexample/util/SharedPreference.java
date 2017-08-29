package com.example.lenovo.sporteventexample.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.logging.Logger;


/**
 * Created by Mrunali on 8/29/17.
 */


public class SharedPreference {

    private static Context ctx;

    public static void setStringSharedPreference(Context ctx, String Key, String Value) {
        SharedPreferences pref = ctx.getSharedPreferences(Constants.APP_SHARED_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(Key, Value);
        editor.commit();
    }


    public static void setBooleanSharedPreference(Context ctx, String key, boolean value) {
        SharedPreferences pref = ctx.getSharedPreferences(Constants.APP_SHARED_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static void setIntSharedPreference(Context ctx, String key, int value) {
        SharedPreferences pref = ctx.getSharedPreferences(Constants.APP_SHARED_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(key, value);
        editor.commit();
    }


    public static String getStringSharedPreference(Context ctx, String Key) {
        SharedPreferences pref = ctx.getSharedPreferences(Constants.APP_SHARED_PREFERENCE, Context.MODE_PRIVATE);

        if (pref.contains(Key)) {

            return pref.getString(Key, null);
        } else
            return null;
    }

    public static void DeleteSharedPreference(Context ctx, String Key) {
        SharedPreferences pref = ctx.getSharedPreferences(Constants.APP_SHARED_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        if (pref.contains(Key)) {
            editor.remove(Key);
            editor.commit();
        }
    }


    public static boolean getBooleanSharedPreference(Context ctx, String Key, Boolean defaultValue) {
        SharedPreferences pref = ctx.getSharedPreferences(Constants.APP_SHARED_PREFERENCE, Context.MODE_PRIVATE);
        Logger.i("key", ":" + Key);
        if (pref.contains(Key)) {
            Logger.i("Print id  s", ":" + pref.getBoolean(Key, defaultValue));
            return pref.getBoolean(Key, defaultValue);
        } else
            return defaultValue;
    }

    public static int getIntSharedPreference(Context ctx, String Key, int defaultValue) {
        SharedPreferences pref = ctx.getSharedPreferences(Constants.APP_SHARED_PREFERENCE, Context.MODE_PRIVATE);
        Logger.i("key", ":" + Key);
        if (pref.contains(Key)) {
            Logger.i("Print id  s", ":" + pref.getInt(Key, defaultValue));
            return pref.getInt(Key, defaultValue);
        } else
            return defaultValue;
    }


    public static void setLongSharedPreference(Context ctx, String key, long value) {
        SharedPreferences pref = ctx.getSharedPreferences(Constants.APP_SHARED_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putLong(key, value);
        editor.commit();
    }

    public static long getLongSharedPreference(Context ctx, String Key) {
        if (null == ctx) {
            return 0;
        }
        SharedPreferences pref = ctx.getSharedPreferences(Constants.APP_SHARED_PREFERENCE, Context.MODE_PRIVATE);
        return pref.getLong(Key, 0l);
    }

    /*public static boolean saveUserData(Context ctx, UserProfileModel model) {
        try {
            SharedPreferences mPrefs = ctx.getSharedPreferences(Constants.APP_SHARED_PREFERENCE, Context.MODE_PRIVATE);
            SharedPreferences.Editor prefsEditor = mPrefs.edit();
            Gson gson = new Gson();
            String json = gson.toJson(model);

            prefsEditor.putString(Constants.LOGIN_OBJECT, json);
            prefsEditor.commit();
            Logger.e("Saved String ", json);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }


    public static boolean deleteUserData(Context ctx) {
        try {
            SharedPreferences mPrefs = ctx.getSharedPreferences(Constants.APP_SHARED_PREFERENCE, Context.MODE_PRIVATE);
            SharedPreferences.Editor prefsEditor = mPrefs.edit();
            prefsEditor.putString(Constants.LOGIN_OBJECT, "");
            prefsEditor.commit();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }


   @Nullable public static UserProfileModel getUserData(Context ctx) {

        try {
            SharedPreferences pref = ctx.getSharedPreferences(Constants.APP_SHARED_PREFERENCE, Context.MODE_PRIVATE);
            Gson gson = new Gson();
            String json = pref.getString(Constants.LOGIN_OBJECT, "");
            Logger.e(Constants.TAG, json);
            UserProfileModel obj = gson.fromJson(json, UserProfileModel.class);
            return (obj != null) ? obj : new UserProfileModel();
        }
        catch (Exception e)
        {
            Logger.e("Error ", e.toString());
            return  new UserProfileModel();
        }
    }
*/

}
