package com.example.labsky.services;

import com.example.labsky.Repository.PassageiroRepository;
import com.example.labsky.model.Passageiro;
import com.example.labsky.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PassageiroService {
    @Autowired
    private PassageiroRepository passageiroRepository;

    public List<Passageiro> listaPassageiros(){
        return  passageiroRepository.findAll();
    }

    public Passageiro buscarCpf (String cpf) throws Exception{
        String novoCpf = StringUtils.formataCpf(cpf.replaceAll("[^0-9]+",""));
        Optional<Passageiro> passageiro = passageiroRepository.findById(novoCpf);
        if (passageiro.isPresent()){
            return passageiro.get();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
    }

    public void atualizarMilhas(String cpf){
        Optional<Passageiro> passageiro = passageiroRepository.findById(cpf);

        int milhas = passageiro.get().getMilhas();
        milhas += retornaPontos(passageiro.get().getClassificacao());

        passageiro.get().setMilhas(milhas);

        passageiroRepository.save(passageiro.get());
    }

    private int retornaPontos(String classificacao){
        int pontos = 0;
        switch(classificacao){
            case "VIP":
                 pontos = 100;
                 break;
            case "OURO":
                pontos = 80;
                break;
            case "PRATA":
                pontos = 50;
                break;
            case "BRONZE":
                pontos = 30;
                break;
            case "ASSOCIADO":
                pontos = 10;
                break;
        }

        return pontos;
    }

}
