package com.example.labsky.model;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;

@Entity
@Data
public class Passageiro {

    @Id
    private String cpf;
    private String nome;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    private String classificacao;
    private Integer milhas;

    private int idade;
}