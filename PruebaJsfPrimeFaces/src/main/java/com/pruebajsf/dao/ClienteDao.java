/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebajsf.dao;

import com.pruebajsf.modelo.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author FamEscar
 */
public class ClienteDao extends Conexion {

    private String sql;
    private PreparedStatement ejecutar;
    private String respuesta;

    //Agregar un nuevo Cliente, Los procesos de eliminar y actualizar son similares
    public String registrarCliente(Cliente datos) {
        respuesta = null;
        try {
            this.Conectar();
            sql = "insert into cliente values(?,?,?,?)";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            ejecutar.setInt(1, datos.getId());
            ejecutar.setString(2, datos.getNombre());
            ejecutar.setString(3, datos.getApellido());
            ejecutar.setString(4, datos.getNit());

            ejecutar.executeUpdate();

            respuesta = "Registro Almacenado con Exito";
        } catch (SQLException ex) {
            System.out.println("Error en Statement" + ex);
            respuesta = "No se pudo almacenar el registro";
        } finally {
            this.cerrarConex();
        }
        return respuesta;
    }

    //BUSCAR DATOS
    public ArrayList<Cliente> listaClientes() {
        ArrayList<Cliente> lista = null;
        ResultSet resultado;
        try {
            this.Conectar();
            sql = "select * from cliente";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            resultado = ejecutar.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Cliente clienten = new Cliente();
                clienten.setId(resultado.getInt("id"));
                clienten.setNombre(resultado.getString("nombre"));
                clienten.setApellido(resultado.getString("apellido"));
                clienten.setNit(resultado.getString("nit"));

                lista.add(clienten);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            this.cerrarConex();
        }
        return lista;
    }

    public String eliminarCliente(int codigo) {
        try {
            this.Conectar();
            sql = "delete from cliente where id=?";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            ejecutar.setInt(1, codigo);
            ejecutar.executeUpdate();
            respuesta = "Registro Eliminado";

        } catch (SQLException ex) {
            //Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en Conexion: " + ex);
            respuesta = "Error, no se puede eliminar el registro";
        }
        return respuesta;
    }

    public String modificarCliente(Cliente datos) {
        try {
            this.Conectar();
            sql = "update cliente set nombre=?, apellido=? where id=?";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            ejecutar.setString(1, datos.getNombre());
            ejecutar.setString(2, datos.getApellido());
            ejecutar.setInt(3, datos.getId());
            ejecutar.executeUpdate();
            respuesta = "datos modificados con exito";

        } catch (SQLException ex) {
            //Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en conexion: " + ex);
            respuesta = "No se puede modificar";
        }
        return respuesta;
    }

    //BUSCAR DATOS
    public Cliente mostrarCliente(Cliente datos) {
        Cliente micliente = new Cliente();
        ResultSet resultado;
        try {
            this.Conectar();
            sql = "select * from cliente where id=?";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            ejecutar.setInt(1, datos.getId());
            resultado = ejecutar.executeQuery();

            resultado.next();
            
            micliente.setId(resultado.getInt("id"));
            micliente.setNombre(resultado.getString("nombre"));
            micliente.setApellido(resultado.getString("apellido"));
            micliente.setNit(resultado.getString("nit"));

        } catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            this.cerrarConex();
        }
        return micliente;
    }
}
