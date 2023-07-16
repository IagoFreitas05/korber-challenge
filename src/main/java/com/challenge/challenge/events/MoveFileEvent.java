package com.challenge.challenge.events;

import com.challenge.challenge.entities.Type;
import org.springframework.context.ApplicationEvent;

public class MoveFileEvent extends ApplicationEvent {
    private Type type;

    public MoveFileEvent(Object source, Type type) {
        super(source);
        this.type = type;
    }
    public Type getType() {
        return type;
    }
}