package com.example.labsky.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(mappedBy = "cpf",cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Passageiro passageiro;

    private String assento;
}
