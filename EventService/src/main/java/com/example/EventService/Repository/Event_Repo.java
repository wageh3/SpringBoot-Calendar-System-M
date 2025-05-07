package com.example.EventService.Repository;

import com.example.EventService.Models.Event;
import com.example.EventService.Models.EventDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Event_Repo extends JpaRepository<Event, Integer> {

    @Query("SELECT new com.example.EventService.Models.EventDTO(" +
            "e.id, e.date, e.description, e.eventstatus.id, e.time, e.title, e.reminder) " +
            "FROM Event e WHERE e.user.id = :userId")
    List<EventDTO> findEventByUserId(@Param("userId") Integer userId);

    @Query("SELECT e FROM Event e WHERE e.user.id = :userId AND e.eventstatus.id = :statusId")
    List<Event> findByUserIdAndEventstatusId(@Param("userId") Integer userId,
                                             @Param("statusId") Integer statusId);

    @Query("SELECT e FROM Event e WHERE e.id = :id AND e.user.id = :userId")
    Optional<Event> findByIdAndUserId(@Param("id") Integer id,
                                      @Param("userId") Integer userId);

    @Query("SELECT new com.example.EventService.Models.EventDTO(" +
            "e.id, e.date, e.description, e.eventstatus.id, e.time, e.title, e.reminder) " +
            "FROM Event e WHERE e.user.id = :userId AND e.date >= CURRENT_DATE " +
            "ORDER BY e.date ASC, e.time ASC")
    List<EventDTO> findUpcomingEventsByUserId(@Param("userId") Integer userId);

    @Query("SELECT new com.example.EventService.Models.EventDTO(" +
            "e.id, e.date, e.description, e.eventstatus.id, e.time, e.title, e.reminder) " +
            "FROM Event e WHERE e.user.id = :userId AND e.date < CURRENT_DATE " +
            "ORDER BY e.date DESC, e.time DESC")
    List<EventDTO> findPastEventsByUserId(@Param("userId") Integer userId);

    boolean existsByIdAndUserId(Integer id, Integer userId);
}