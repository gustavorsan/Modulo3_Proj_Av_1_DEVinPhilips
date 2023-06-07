package com.example.labsky.controller;

import com.example.labsky.Repository.PassageiroRepository;
import com.example.labsky.Repository.TicketRepository;
import com.example.labsky.model.Assento;
import com.example.labsky.model.Passageiro;
import com.example.labsky.services.AssentoService;
import com.example.labsky.services.PassageiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Hashtable;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PlaneController {
    @Autowired
    private PassageiroService passageiroService;

    @Autowired
    private AssentoService assentoService;

    private Hashtable<String,Passageiro> assentos = new Hashtable<String,Passageiro>();


    @GetMapping("/passageiros")
    public List<Passageiro> listar(){
        return  passageiroService.listaPassageiros();
    }

    @GetMapping("/passageiros/{cpf}")
    public Passageiro bucarPassageiro(@PathVariable("cpf") String cpf){
        try{
            return passageiroService.buscarCpf(cpf);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não localizado\n");
        }
    }

    @GetMapping("/assentos")
    public List<String> listarAssento(){
        return assentoService.obterAssentos();
    }


}
