package com.challenge.challenge.events;

import com.challenge.challenge.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class MoveFileEventListener implements ApplicationListener<MoveFileEvent> {

    final
    TripService tripService;
    @Autowired
    public MoveFileEventListener(TripService tripService) {
        this.tripService = tripService;
    }

    @Override
    public void onApplicationEvent(MoveFileEvent event) {
        try {
            tripService.saveCSVData(event.getType());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}