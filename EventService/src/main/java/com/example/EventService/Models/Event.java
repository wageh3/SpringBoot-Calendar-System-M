//package com.example.EventService.Models;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import jakarta.persistence.*;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.LinkedHashSet;
//import java.util.Set;
//
//@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//@Table(name = "event")
//public class Event {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "event_id", nullable = false)
//    private Integer id;
//
//    @Column(name = "title", nullable = false, length = Integer.MAX_VALUE)
//    private String title;
//
//    @Column(name = "description", nullable = false, length = Integer.MAX_VALUE)
//    private String description;
//
//    @Column(name = "date", nullable = false)
//    private LocalDate date;
//
//    @Column(name = "reminder", nullable = true)
//    private LocalTime reminder;
//
//    @Column(name = "\"time\"", nullable = false)
//    private LocalTime time;
//
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "user_id", nullable = false)
//    @JsonIgnore
//    private User user;
//
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "eventstatus_id", nullable = false)
//    @JsonIgnore
//    private Eventstatus eventstatus;
//
//    @OneToMany(mappedBy = "event")
//    @JsonIgnore
//    private Set<Invitation> invitations = new LinkedHashSet<>();
//
//    @ManyToMany
//    @JsonIgnore
//    @JoinTable(name = "participation",
//            joinColumns = @JoinColumn(name = "event_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id"))
//    private Set<User> users = new LinkedHashSet<>();
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public LocalTime getReminder() {
//        return reminder;
//    }
//
//    public void setReminder(LocalTime reminder) {
//        this.reminder = reminder;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public LocalDate getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDate date) {
//        this.date = date;
//    }
//
//    public LocalTime getTime() {
//        return time;
//    }
//
//    public void setTime(LocalTime time) {
//        this.time = time;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public Eventstatus getEventstatus() {
//        return eventstatus;
//    }
//
//    public void setEventstatus(Eventstatus eventstatus) {
//        this.eventstatus = eventstatus;
//    }
//
//    public Set<Invitation> getInvitations() {
//        return invitations;
//    }
//
//    public void setInvitations(Set<Invitation> invitations) {
//        this.invitations = invitations;
//    }
//
//    public Set<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }
//
//}