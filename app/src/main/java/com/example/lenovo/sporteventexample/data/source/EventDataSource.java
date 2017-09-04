package com.example.lenovo.sporteventexample.data.source;



import com.example.lenovo.sporteventexample.data.Event;

import java.util.List;

/**
 * Created by root on 11/6/17.
 */

public interface EventDataSource {


    void getAllEvents(LoadEventsCallback callback);

    void getEventsByCity(String city, LoadEventsCallback callback);

    void saveEvent(SaveEventCallback callback, Event event);

    void updateEvent(SaveEventCallback callback, Event event);

    void getEvent(String id, GetEventCallback callback);

    interface LoadEventsCallback {
        void onEventsLoaded(List<Event> events);

        void onDataNotAvailable();

        void onError(Throwable throwable);
    }

    interface GetEventCallback {
        void onEventLoaded(Event event);

        void onError(Throwable throwable);
    }

    interface SaveEventCallback {
        void onEventSaved();

        void onError(Throwable throwable);
    }
}
