package com.example.EventService.controllers;

import com.example.EventService.Models.Event;
import com.example.EventService.Models.EventDTO;
import com.example.EventService.Models.Eventstatus;
import com.example.EventService.Repository.EventStatus_Repo;
import com.example.EventService.Repository.Event_Repo;
import com.example.EventService.services.Event_Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Event_Controller {
    final private Event_Service event_service ;
    final private User_Repo user_repo ;
    final private EventStatus_Repo eventstatus_repo ;
    private final Event_Repo event_Repo;
    public Object getTitle;

    public Event_Controller(Event_Service event_service , User_Repo user_repo , EventStatus_Repo eventstatus_repo, Event_Repo event_Repo) {
        this.event_service = event_service;
        this.user_repo = user_repo;
        this.eventstatus_repo = eventstatus_repo;
        this.event_Repo = event_Repo;
    }

    @PostMapping("/Add_Event")
    public ResponseEntity<String> Add_Event(@RequestBody Event eventsended, @CookieValue(value = "userId", required = false) String userId) {
        Event event = new Event();
        event.setTitle(eventsended.getTitle());
        event.setDescription(eventsended.getDescription());
        event.setDate(eventsended.getDate());
        event.setTime(eventsended.getTime());
        event.setReminder(eventsended.getReminder());

        Optional<User> user = user_repo.findById(Integer.parseInt(userId));
        event.setUser(user.get());

        LocalDate eventDate = event.getDate();
        LocalTime eventTime = event.getTime();
        LocalDateTime eventDateTime = LocalDateTime.of(eventDate, eventTime);
        LocalDateTime now = LocalDateTime.now();

        if (eventDateTime.isBefore(now)) {
            Eventstatus eventstatus = eventstatus_repo.findById(1);
            event.setEventstatus(eventstatus);
        }
        else {
            Eventstatus eventstatus = eventstatus_repo.findById(2);
            event.setEventstatus(eventstatus);
        }
        event_Repo.save(event);
        return ResponseEntity.ok("SUCCESS");
    }


    @GetMapping("/GetAllEvents")
    public ResponseEntity<List<EventDTO>> getAllEvents(@CookieValue(value = "userId", required = false) String userId) {
        List<EventDTO> eventsDTO = event_Repo.findEventByUserId(Integer.parseInt(userId));
        return ResponseEntity.ok(eventsDTO);
    }


    @PutMapping("/Edit_Event/{id}")
    public ResponseEntity<String> Edit_Event(
            @PathVariable Integer id,
            @RequestBody Event updatedEvent) {

        Event event = event_Repo.findById(id).get();
        event.setTitle(updatedEvent.getTitle());
        event.setDescription(updatedEvent.getDescription());
        event.setDate(updatedEvent.getDate());
        event.setTime(updatedEvent.getTime());
        event_Repo.save(event);
        return ResponseEntity.ok("SUCCESS");
    }


    @DeleteMapping("/Delete_Event/{id}")
    public ResponseEntity<String> Delete_Event(@PathVariable Integer id){
        Event event = event_Repo.findById(id).get();
        event_Repo.delete(event);
        return ResponseEntity.ok("SUCCESS");
    }




}