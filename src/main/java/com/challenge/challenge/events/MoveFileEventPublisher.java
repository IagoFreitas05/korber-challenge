package com.challenge.challenge.events;

import com.challenge.challenge.entities.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class MoveFileEventPublisher {
    private final ApplicationEventPublisher applicationEventPublisher;
    @Autowired
    public MoveFileEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
    public void publishCustomEvent(final Type type) {
        System.out.println("Iniciando leitura do arquivo do tipo:"+ type);
        MoveFileEvent customSpringEvent = new MoveFileEvent(this, type);
        applicationEventPublisher.publishEvent(customSpringEvent);
    }
}
