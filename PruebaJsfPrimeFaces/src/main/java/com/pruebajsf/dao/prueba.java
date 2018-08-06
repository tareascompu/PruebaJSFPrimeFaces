/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebajsf.dao;

import com.pruebajsf.modelo.Cliente;

/**
 *
 * @author FamEscar
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ClienteDao cliente = new ClienteDao();
       Cliente datos = new Cliente();
       datos.setId(12);
       datos.setNombre("inventado");
       datos.setApellido("nuevo");
       datos.setNit("123");
       String mensaje=cliente.registrarCliente(datos);
        System.out.println(mensaje);
    }
    
}
