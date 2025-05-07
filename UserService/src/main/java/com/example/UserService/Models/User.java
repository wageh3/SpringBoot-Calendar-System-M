package com.example.UserService.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer id;

    @Column(name = "username", nullable = false, length = Integer.MAX_VALUE)
    private String username;

    @Column(name = "email", nullable = false, length = Integer.MAX_VALUE)
    private String email;

    @Column(name = "password", nullable = false, length = Integer.MAX_VALUE)
    private String password;

    @Column(name = "confirm_password", nullable = false, length = Integer.MAX_VALUE)
    private String confirmPassword;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Event> event = new LinkedHashSet<>();

    @OneToMany(mappedBy = "sender")
    private Set<Invitation> invitationsender = new LinkedHashSet<>();

    @OneToMany(mappedBy = "receiver")
    private Set<Invitation> invitationreceiver = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "participation",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    private Set<Event> participation = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Set<Event> getEvent() {
        return event;
    }

    public void setEvent(Set<Event> event) {
        this.event = event;
    }

    public Set<Invitation> getInvitationsender() {
        return invitationsender;
    }

    public void setInvitationsender(Set<Invitation> invitationsender) {
        this.invitationsender = invitationsender;
    }

    public Set<Invitation> getInvitationreceiver() {
        return invitationreceiver;
    }

    public void setInvitationreceiver(Set<Invitation> invitationreceiver) {
        this.invitationreceiver = invitationreceiver;
    }

    public Set<Event> getParticipation() {
        return participation;
    }

    public void setParticipation(Set<Event> participation) {
        this.participation = participation;
    }

}