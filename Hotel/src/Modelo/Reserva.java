/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Orel Aguilar
 */
public class Reserva {
    private int id_res;
    private int numReservacion;
    private int num_cliente;    //id_res, numReservacion,fechaInicio, fechaFin, num_cliente, cod_hab
    private int cod_hab;
    private String fechaInicio;
    private String fechaFin;
    
    /*fechaInicio = jdcFecha calendario
    fechaFinal = jdcFecha calendario
    */
    

    
    
    public int getId_res() {
        return id_res;
    }

    public void setId_res(int id_res) {
        this.id_res = id_res;
    }

    public int getNumReservacion() {
        return numReservacion;
    }

    public void setNumReservacion(int numReservacion) {
        this.numReservacion = numReservacion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    

    public int getNum_cliente() {
        return num_cliente;
    }

    public void setNum_cliente(int num_cliente) {
        this.num_cliente = num_cliente;
    }

    public int getCod_hab() {
        return cod_hab;
    }

    public void setCod_hab(int cod_hab) {
        this.cod_hab = cod_hab;
    }
    
    
    
    
}
