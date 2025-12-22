package com.estudosmartins.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {
    //Classe feita para decodificar o parâmetro da URL, pois o JS encodifica este parâmetro com caracteres especiais

    public static String decodeParam(String text){
        try {
            return URLDecoder.decode(text, "UTF-8");
        }
        catch(UnsupportedEncodingException e){
            return ""; //Retorne vazio
        }
    }
}
