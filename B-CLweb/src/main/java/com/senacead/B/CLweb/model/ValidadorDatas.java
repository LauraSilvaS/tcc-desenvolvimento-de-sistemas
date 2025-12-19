
package com.senacead.B.CLweb.model;

import com.senacead.B.CLweb.repository.ValidadorDatasInterface;


public class ValidadorDatas implements ValidadorDatasInterface{

   
    @Override
    public boolean validarData(String data) {
        //sem date formatter
        String numeros = data.replaceAll("[^0-9]", "");

        if (numeros.length() == 8 || numeros.matches("\\d{4}[-]\\d{2}[-]\\d{2}")) {
            return true;
        } else {

            return false;
        }
    }

   
}
