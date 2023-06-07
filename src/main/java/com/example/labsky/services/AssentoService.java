package com.example.labsky.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssentoService {

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

    public boolean assentoValido(String assento){
        List<String> lista = new ArrayList<>();
        lista.addAll(obterAssentos());

        return lista.contains(assento);
    }

}
