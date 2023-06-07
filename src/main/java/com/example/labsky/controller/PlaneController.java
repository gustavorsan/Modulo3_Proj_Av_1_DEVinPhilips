package com.example.labsky.controller;

import com.example.labsky.Repository.PassageiroRepository;
import com.example.labsky.Repository.TicketRepository;
import com.example.labsky.model.Passageiro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlaneController {



    @GetMapping("/passageiros")
    public List<Passageiro> lista() {return passageiroRepository.findAll();}
}
