package com.example.labsky.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Assento{

    @Id
    private String assento;


    private String passageiro;


}
