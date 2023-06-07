package com.example.labsky.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID eTicket;

    @ManyToOne
    @JoinColumn(name = "cpf")
    private Passageiro Passageiro;

    private String assento;

    private boolean malasDespachadas;

    private LocalDateTime dtHoraConfirmacao;
}
