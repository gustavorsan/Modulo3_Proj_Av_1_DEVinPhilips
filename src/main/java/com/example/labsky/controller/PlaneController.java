package com.example.labsky.controller;

import com.example.labsky.model.Passageiro;
import com.example.labsky.model.Ticket;
import com.example.labsky.services.AssentoService;
import com.example.labsky.services.PassageiroService;
import com.example.labsky.services.TicketService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PlaneController {
    @Autowired
    private PassageiroService passageiroService;

    @Autowired
    private AssentoService assentoService;

    @Autowired
    private TicketService ticketService;

    private Hashtable<String,Passageiro> assentos = new Hashtable<String,Passageiro>();


    @GetMapping("/passageiros")
    public List<Passageiro> listar(){
        return  passageiroService.listaPassageiros();
    }

    @GetMapping("/passageiros/{cpf}")
    public Passageiro bucarPassageiro(@PathVariable("cpf") String cpf) throws Exception{
        try{
            return passageiroService.buscarCpf(cpf);
        }catch(Exception e){
            throw e;
        }
    }

    @GetMapping("/assentos")
    public List<String> listarAssento(){
        return assentoService.obterAssentos();
    }

    @PostMapping("/passageiros/confirmacao")
    public Ticket confirmar(@RequestBody Map<String, String> userMap) throws Exception{
        try {
            Passageiro passageiro = passageiroService.buscarCpf(userMap.get("cpf"));

            String assento = userMap.get("assento");

            if (!assentoService.assentoValido(assento)  ){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Assento não localizado\n");
            }
            boolean malas = userMap.get("malasDespachadas").toLowerCase() == "true";

            return ticketService.salvar(passageiro,userMap.get("assento"),malas);
        }catch (Exception e){
            throw  e;
        }

    }


}
