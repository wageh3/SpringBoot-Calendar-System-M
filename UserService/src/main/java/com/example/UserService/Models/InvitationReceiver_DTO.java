package com.example.UserService.Models;
import java.time.LocalDate;
import java.time.LocalTime;

public class InvitationReceiver_DTO {
    private Integer invitationReceived_id;
    private String Sender_name ;
    private String Sender_email ;
    private String event_title ;
    private LocalDate event_date;
    private LocalTime event_time;



    public InvitationReceiver_DTO(Integer invitationReceived_id, String sender_name, String sender_email, String event_title, LocalDate event_date, LocalTime event_time) {
        this.invitationReceived_id = invitationReceived_id;
        Sender_name = sender_name;
        Sender_email = sender_email;
        this.event_title = event_title;
        this.event_date = event_date;
        this.event_time = event_time;
    }

    public Integer getInvitationReceived_id() {
        return invitationReceived_id;
    }

    public void setInvitationReceived_id(Integer invitationReceived_id) {
        this.invitationReceived_id = invitationReceived_id;
    }

    public String getSender_name() {
        return Sender_name;
    }

    public void setSender_name(String sender_name) {
        Sender_name = sender_name;
    }

    public String getSender_email() {
        return Sender_email;
    }

    public void setSender_email(String sender_email) {
        Sender_email = sender_email;
    }

    public String getEvent_title() {
        return event_title;
    }

    public void setEvent_title(String event_title) {
        this.event_title = event_title;
    }

    public LocalDate getEvent_date() {
        return event_date;
    }

    public void setEvent_date(LocalDate event_date) {
        this.event_date = event_date;
    }

    public LocalTime getEvent_time() {
        return event_time;
    }

    public void setEvent_time(LocalTime event_time) {
        this.event_time = event_time;
    }
}
