package com.maryana.starsdeck.dto;

import com.maryana.starsdeck.model.Event;
import com.maryana.starsdeck.model.enums.EventType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class EventDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private EventType eventType;
    private Date date;
    private String title;
    private String comment;

    public EventDTO(Event eventObj) {
        this.id = eventObj.getId();
        this.eventType = eventObj.getEventType();
        this.date = eventObj.getDate();
        this.title = eventObj.getTitle();
        this.comment = eventObj.getComment();
    }
}
