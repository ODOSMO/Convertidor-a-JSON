package com.edu.mx.practica.uno.controlador;

import com.edu.mx.practica.uno.modelo.Empleado;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import javax.swing.*;

public class Convertidor {
    public String xmlToJson(String xml) {
        String resultado = "";
        try {
            JSONObject xmlConvertido = XML.toJSONObject(xml);
            resultado = xmlConvertido.toString(4);
            // Solo para verificar en Consola que si jala
            System.out.println(resultado);
        } catch (JSONException e) {
            // Solo para verificar en Consola que no jala
            System.out.println(e.toString());
            resultado = "error";
            JOptionPane.showMessageDialog(null,"Formato invalido, Porfavor asegurese de ingresar texto valido","ERROR", 0);
        }
        return resultado;
    }

    public String javaToGson(String javaF) {
        String resultado = "";
        try {
            //Se asignan valores a los atributos
            Empleado empleado = new Empleado();
            empleado.setNombre("Oscar");
            empleado.setApellido("Sanchez");
            empleado.setEdad(22);
            empleado.setSalario((float) 999);
            //instancia para crear un objeto a partir de la clase empleado
            ObjectMapper mapper = new ObjectMapper();
            resultado = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(empleado);
            // Solo para verificar en Consola que si jala
            System.out.println(resultado);
        } catch (JSONException e) {
            // Solo para verificar en Consola que no jala
            System.out.println(e.toString());
            resultado = "error";
            JOptionPane.showMessageDialog(null,"Formato invalido, Porfavor asegurese de ingresar texto valido","ERROR", 0);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return resultado;
    }
}
