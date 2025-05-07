package com.example.EventService.Models;

import java.time.LocalDate;
import java.time.LocalTime;

public class EventDTO {

    private Integer event_id;
    private LocalDate date;
    private String description;
    private Integer eventstatus_id;
    private LocalTime time;
    private String title;
    private LocalTime reminder;



    public EventDTO(Integer event_id, LocalDate date, String description, Integer eventstatus_id, LocalTime time, String title, LocalTime reminder) {
        this.event_id = event_id;
        this.date = date;
        this.description = description;
        this.eventstatus_id = eventstatus_id;
        this.time = time;
        this.title = title;
        this.reminder = reminder;
    }

    public Integer getEventId() {
        return event_id;
    }

    public void setEventId(Integer eventId) {
        this.event_id = eventId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getEventStatusId() {
        return eventstatus_id;
    }

    public void setEventStatusId(Integer eventstatus_id) {
        this.eventstatus_id = eventstatus_id;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public LocalTime getReminder() {
        return reminder;
    }

    public void setReminder(LocalTime reminder) {
        this.reminder = reminder;
    }

    @Override
    public String toString() {
        return "EventDTO{" +
                "title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
