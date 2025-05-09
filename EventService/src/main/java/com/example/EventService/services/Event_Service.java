//package com.example.EventService.services;
//
//import com.example.EventService.Event.Event_Repo;
//import com.example.EventService.EventStatus.EventStatus_Repo;
//import com.example.EventService.Models.Event;
//import com.example.EventService.Models.EventDTO;
//import com.example.EventService.Models.Eventstatus;
//import com.example.EventService.Models.User;
//import com.example.EventService.User.User_Repo;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class Event_Service {
//
//    private final Event_Repo eventRepo;
//    private final User_Repo userRepo;
//    private final EventStatus_Repo eventStatusRepo;
//
//    public Event_Service(Event_Repo eventRepo, User_Repo userRepo, EventStatus_Repo eventStatusRepo) {
//        this.eventRepo = eventRepo;
//        this.userRepo = userRepo;
//        this.eventStatusRepo = eventStatusRepo;
//    }
//
//    // Create a new event
//    public Event createEvent(Event event, Integer userId) {
//        Optional<User> user = userRepo.findById(userId);
//        if (user.isEmpty()) {
//            throw new RuntimeException("User not found with id: " + userId);
//        }
//
//        event.setUser(user.get());
//        setEventStatusBasedOnDateTime(event);
//        return eventRepo.save(event);
//    }
//
//    // Get all events for a user
//    public List<EventDTO> getAllEventsForUser(Integer userId) {
//        return eventRepo.findEventByUserId(userId);
//    }
//
//    // Get a single event by ID
//    public Optional<Event> getEventById(Integer id) {
//        return eventRepo.findById(id);
//    }
//
//    // Update an existing event
//    public Event updateEvent(Integer id, Event updatedEvent) {
//        return eventRepo.findById(id)
//                .map(event -> {
//                    event.setTitle(updatedEvent.getTitle());
//                    event.setDescription(updatedEvent.getDescription());
//                    event.setDate(updatedEvent.getDate());
//                    event.setTime(updatedEvent.getTime());
//                    event.setReminder(updatedEvent.getReminder());
//                    setEventStatusBasedOnDateTime(event);
//                    return eventRepo.save(event);
//                })
//                .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));
//    }
//
//    // Delete an event
//    public void deleteEvent(Integer id) {
//        if (!eventRepo.existsById(id)) {
//            throw new RuntimeException("Event not found with id: " + id);
//        }
//        eventRepo.deleteById(id);
//    }
//
//    // Helper method to set event status based on date/time
//    private void setEventStatusBasedOnDateTime(Event event) {
//        LocalDate eventDate = event.getDate();
//        LocalTime eventTime = event.getTime();
//        LocalDateTime eventDateTime = LocalDateTime.of(eventDate, eventTime);
//        LocalDateTime now = LocalDateTime.now();
//
//        Eventstatus status = eventDateTime.isBefore(now)
//                ? eventStatusRepo.findById(1)  // Past event status
//                : eventStatusRepo.findById(2); // Upcoming event status
//
//        event.setEventstatus(status);
//    }
//
//    // Additional business logic methods can be added here
//    // For example:
//    public List<Event> getUpcomingEvents(Integer userId) {
//        return eventRepo.findByUserIdAndEventstatusId(userId, 2); // 2 for upcoming
//    }
//
//    public List<Event> getPastEvents(Integer userId) {
//        return eventRepo.findByUserIdAndEventstatusId(userId, 1); // 1 for past
//    }
//}