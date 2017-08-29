package com.example.lenovo.sporteventexample.data.source.remote;


import android.provider.SyncStateContract;

import com.example.lenovo.sporteventexample.data.Event;
import com.example.lenovo.sporteventexample.data.source.EventDataSource;
import com.example.lenovo.sporteventexample.util.Constants;
import com.example.lenovo.sporteventexample.util.Utility;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;



import java.util.ArrayList;
import java.util.List;

/**
 * Created by LENOVO on 8/29/2017.
 */

public class EventRemoteRepository implements EventDataSource {

    public static Event parseEvent(ParseObject object) {
        Event event = new Event();
        if (object != null) {
            event.setId(object.getObjectId());
            event.setCity(String.valueOf(object.get(Event.CITY)));
            event.setTitle(String.valueOf(object.get(event.TITLE)));
            event.setDescription(String.valueOf(object.get(event.DESCRIPTION)));
            event.setStartDate(String.valueOf(object.get(Event.START_DATE)));
            event.setEndDate(String.valueOf(object.get(Event.END_DATE)));
            event.setCoverImage(String.valueOf(object.get(Event.COVER_IMAGE)));
            event.setImages(Utility.getStringList((object.getList(Event.IMAGES))));
            event.setVenue(String.valueOf(object.get(Event.VENUE)));
            event.setLatitude(String.valueOf(object.get(Event.LATITUDE)));
            event.setLongitude(String.valueOf(object.get(Event.LONGITUDE)));
            event.setUserId(String.valueOf(object.get(Event.USER_ID)));
            event.setUserName(String.valueOf(object.get(Event.USER_NAME)));
            event.setEnabled(object.getBoolean(Event.IS_ENABLED));
            event.setVerified(object.getBoolean(Event.IS_VERIFIED));
            return event;
        }
        return null;
    }

    @Override
    public void getAllEvents(final EventDataSource.LoadEventsCallback callback) {
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(Constants.PARSE_EVENT);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                if (e == null) {
                    if (list != null) {
                        if (list.size() > 0) {
                            List<Event> events = new ArrayList<Event>();
                            for (ParseObject object : list) {
                                events.add(parseEvent(object));
                            }
                            callback.onEventsLoaded(events);
                        } else {
                            callback.onDataNotAvailable();
                        }
                    }
                } else {
                    callback.onError(e);
                }
            }
        });
    }

    @Override
    public void getEventsByCity(String city, final LoadEventsCallback callback) {
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(Constants.PARSE_EVENT);
        query.whereEqualTo(Event.CITY, city);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                if (e == null) {
                    if (list != null) {
                        if (list.size() > 0) {
                            List<Event> events = new ArrayList<Event>();
                            for (ParseObject object : list) {
                                events.add(parseEvent(object));
                            }
                            callback.onEventsLoaded(events);
                        } else {
                            callback.onDataNotAvailable();
                        }
                    }
                } else {
                    callback.onError(e);
                }
            }
        });
    }

    @Override
    public void saveEvent(final SaveEventCallback callback, Event event) {
        ParseObject object = new ParseObject(Constants.PARSE_EVENT);
        object.put(Event.TITLE, event.getTitle());
        object.put(Event.CITY, event.getCity());
        object.put(Event.DESCRIPTION, event.getDescription());
        object.put(Event.START_DATE, event.getStartDate());
        object.put(Event.END_DATE, event.getEndDate());
        object.put(Event.COVER_IMAGE, event.getCoverImage());
        object.put(Event.IMAGES, event.getImages());
        object.put(Event.VENUE, event.getVenue());
        object.put(Event.LONGITUDE, event.getLongitude());
        object.put(Event.LATITUDE, event.getLatitude());
        object.put(Event.USER_ID, event.getUserId());
        object.put(Event.USER_NAME, event.getUserName());
        object.put(Event.IS_ENABLED, event.isEnabled());
        object.put(Event.IS_VERIFIED, event.isVerified());

        object.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    callback.onEventSaved();
                } else {
                    callback.onError(e);
                }
            }
        });

    }

    @Override
    public void updateEvent(final SaveEventCallback callback, final Event event) {
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(Constants.PARSE_EVENT);
        query.getInBackground(event.getId(), new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject parseObject, ParseException e) {
                if (e == null) {
                    parseObject.put(Event.TITLE, event.getTitle());
                    parseObject.put(Event.CITY, event.getCity());
                    parseObject.put(Event.DESCRIPTION, event.getDescription());
                    parseObject.put(Event.START_DATE, event.getStartDate());
                    parseObject.put(Event.END_DATE, event.getEndDate());
                    parseObject.put(Event.COVER_IMAGE, event.getCoverImage());
                    parseObject.put(Event.IMAGES, event.getImages());
                    parseObject.put(Event.VENUE, event.getVenue());
                    parseObject.put(Event.LONGITUDE, event.getLongitude());
                    parseObject.put(Event.LATITUDE, event.getLatitude());
                    parseObject.put(Event.USER_ID, event.getUserId());
                    parseObject.put(Event.USER_NAME, event.getUserName());
                    parseObject.put(Event.IS_ENABLED, event.isEnabled());
                    parseObject.put(Event.IS_VERIFIED, event.isVerified());

                    parseObject.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                callback.onEventSaved();
                            } else {
                                callback.onError(e);
                            }
                        }
                    });
                }
            }
        });
    }

    @Override
    public void getEvent(String id, final GetEventCallback callback) {
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(Constants.PARSE_EVENT);
        query.getInBackground(id, new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject parseObject, ParseException e) {
                if (e == null) {
                    callback.onEventLoaded(parseEvent(parseObject));
                } else {
                    callback.onError(e);
                }
            }
        });
    }
}

