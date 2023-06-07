package com.example.labsky.services;

import com.example.labsky.Repository.TicketRepository;
import com.example.labsky.model.Passageiro;
import com.example.labsky.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public Ticket salvar(Passageiro passageiro, String assento, Boolean malasDespachadas)throws Exception{

        //checa a fileira e se o Passageiro é menor de 18 anos ou se tem mala para despachar
        if((assento.substring(0,1) == "5" || assento.substring(0,1) == "6") &&
                (malasDespachadas || passageiro.getIdade() < 18)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalido para o assento\n");
        }

        try{
            Optional<List<String>>  assentoCheck = ticketRepository.findByAssento(assento);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Assento já Ocupado\n");
        }



        Ticket checkin = new Ticket();
        checkin.setPassageiro(passageiro);
        checkin.setAssento(assento);
        checkin.setMalasDespachadas(malasDespachadas);
        checkin.setDtHoraConfirmacao(LocalDateTime.now());

        System.out.println("Confirmação feita pelo passageiro de CPF  "+passageiro.getCpf() +"com e-ticket"+checkin.getETicket());

        return ticketRepository.save(checkin);
    }


}
