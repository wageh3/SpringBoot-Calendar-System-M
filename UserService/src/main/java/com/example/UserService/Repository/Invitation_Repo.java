package com.example.UserService.Repository;

import com.example.UserService.Models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Invitation_Repo extends JpaRepository<Invitation,Integer> {
    @Query("SELECT new com.example.InvitationService.Models.InvitationDTO(" +
            "e.id, e.status, e.sender.id, e.receiver.id, e.event.id) " +
            "FROM Invitation e WHERE e.sender.id = :userId")
    List<InvitationDTO> findInvitationsBySenderId(@Param("userId") Integer userId);

    @Query("SELECT new com.example.InvitationService.Models.InvitationDTO(" +
            "e.id, e.status, e.sender.id, e.receiver.id, e.event.id) " +
            "FROM Invitation e WHERE e.receiver.id = :userId")
    List<InvitationDTO> findInvitationsByReceiverId(@Param("userId") Integer userId);

    Optional<Invitation> findById(Integer id);

}

