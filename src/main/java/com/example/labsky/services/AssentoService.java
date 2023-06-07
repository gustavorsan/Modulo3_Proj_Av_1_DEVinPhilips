package com.example.labsky.services;

import com.example.labsky.Repository.AssentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssentoService {

    @Autowired
    private AssentoRepository assentoRepository;

    public List<String> obterAssentos(){
        String letras = "ABCDEF";
        List<String> lista = new ArrayList<>();

        for(int i = 1 ; i <= 10; i++){
            for(char letra : letras.toCharArray() ){
                lista.add(""+i+letra);
            }
        }

        return  lista;
    }

}
