package com.example.labsky.utils;

public class StringUtils {
    public static  String formataCpf(String cpf){
        String novoCpf = cpf.substring(0,3)+"."+cpf.substring(3,6)+"."+cpf.substring(6,9)+"-"+cpf.substring(9,11);
        return novoCpf;
    }
}
