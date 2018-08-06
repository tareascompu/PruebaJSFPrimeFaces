/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebajsf.controlador;

import com.pruebajsf.dao.ClienteDao;
import com.pruebajsf.modelo.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author FamEscar
 */
@ManagedBean
@ViewScoped

public class BeanCliente{
    Cliente datos = new Cliente();
    ArrayList<Cliente> lstCliente;
    ClienteDao clientedao;
    
    public Cliente getDatos() {
        return datos;
    }

    public void setDatos(Cliente datos) {
        this.datos = datos;
    }

    public List<Cliente> getLstCliente() {
        return lstCliente;
    }

    public void setLstCliente(List<Cliente> lstCliente) {
        this.lstCliente = (ArrayList<Cliente>) lstCliente;
    }
    
    public void guardar(){
        clientedao.registrarCliente(datos);
    }
    public void listar(){
        
        try {
            clientedao = new ClienteDao();
            lstCliente = clientedao.listaClientes();
            
        } catch (Exception e) {
            System.out.println("Error en Bean Cliente: " + e);
        }
    }
    
    public void buscarCliente(Cliente datoBuscar){
        Cliente localizado = new Cliente();
        System.out.println("Datos buscar: " + datoBuscar.getId());
        try {
            clientedao = new ClienteDao();
            localizado = clientedao.mostrarCliente(datoBuscar);
            this.datos = localizado;
            
            System.out.println("Nombre" + this.datos.getNombre());
            
        } catch (Exception e) {
            System.out.println("Error en Bean Cliente: " + e);
        }
    }
    
    
    
    
}
