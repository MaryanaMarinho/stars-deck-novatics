package com.maryana.starsdeck.model;

import com.maryana.starsdeck.model.enums.EventType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private EventType eventType;
    private Date date;
    private String title;
    private String comment;

    public Event(EventType eventType, Date date, String title, String comment) {
        this.eventType = eventType;
        this.date = date;
        this.title = title;
        this.comment = comment;
    }
}
