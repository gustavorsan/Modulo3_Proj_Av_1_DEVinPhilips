package com.example.labsky.Repository;


import com.example.labsky.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TicketRepository extends JpaRepository<Ticket, UUID> {
    @Query("SELECT a FROM Ticket a where assento = :numeroAssento")
    Optional<List<String>> findByAssento(String numeroAssento);
}
