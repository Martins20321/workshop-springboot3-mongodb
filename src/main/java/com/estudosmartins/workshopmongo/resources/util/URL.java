package com.estudosmartins.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

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

    public static Date convertDate(String textDate, Date defaultValue){//defaultValue para caso ocorra algum erro
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            return sdf.parse(textDate);
        }
        catch (ParseException e){
            return defaultValue;
        }
    }
}
