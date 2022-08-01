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
public class Habitacion {
    private int id_hab;
    private int cod_hab;
    private String tipo;
    private int num_hab;
    private int piso;
    private float costo;
    private String disponibilidad;

    public int getId_hab() {
        return id_hab;
    }

    public void setId_hab(int id_hab) {
        this.id_hab = id_hab;
    }

    public int getCod_hab() {
        return cod_hab;
    }

    public void setCod_hab(int cod_hab) {
        this.cod_hab = cod_hab;
    }
    

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }
    
    public String getDisponibilidad(){
        return this.disponibilidad;
    }
    
    public void setDisponibilidad(String disponibilidad){
        this.disponibilidad = disponibilidad;
    }

    public int getNum_hab() {
        return num_hab;
    }

    public void setNum_hab(int num_hab) {
        this.num_hab = num_hab;
    }
    
}
