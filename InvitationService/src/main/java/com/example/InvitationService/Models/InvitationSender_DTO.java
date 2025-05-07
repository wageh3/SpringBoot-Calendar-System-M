package com.example.InvitationService.Models;

public class InvitationSender_DTO {
    private String receiver_name ;
    private String receiver_email ;
    private String event_title ;
    private String status ;

    public InvitationSender_DTO(String receiver_name, String receiver_email, String event_title, String status) {
        this.receiver_name = receiver_name;
        this.receiver_email = receiver_email;
        this.event_title = event_title;
        this.status = status;
    }

    public String getReceiver_name() {
        return receiver_name;
    }

    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name;
    }

    public String getReceiver_email() {
        return receiver_email;
    }

    public void setReceiver_email(String receiver_email) {
        this.receiver_email = receiver_email;
    }

    public String getEvent_title() {
        return event_title;
    }

    public void setEvent_title(String event_title) {
        this.event_title = event_title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
