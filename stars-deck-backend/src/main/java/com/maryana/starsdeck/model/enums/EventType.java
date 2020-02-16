package com.maryana.starsdeck.model.enums;

public enum EventType {

    MEETING_PARTICIPATION("Participação de encontro", 1),
    DOJO_PARTICIPATION("Participação em dojo coding", 2),
    LECTURE_PRESENTATION("Apresentação de palestra", 3),
    OPEN_SOURCE_PR("PR em projeto open source", 3);

    private String description;
    private Integer points;

    EventType(String description, Integer points) {
        this.description = description;
        this.points = points;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPoints() {
        return points;
    }
}
