/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultasReservacion;
import Modelo.Reserva;
import Vista.FormReservas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Orel Aguilar
 */
public class ControlReservacion implements ActionListener{

    private final Reserva res;
    private final ConsultasReservacion cons_res;
    private final FormReservas form_res;

    //Constructor que recibe de parametros el modelo y la vista
    public ControlReservacion (Reserva res, ConsultasReservacion cons_res, FormReservas form_res) {
        this.res = res;
        this.cons_res = cons_res;
        this.form_res = form_res;
        this.form_res.btnBuscarReserv.addActionListener(this);
        this.form_res.btnEliminarReserv.addActionListener(this);
        this.form_res.btnLimpiarReserv.addActionListener(this);
        this.form_res.btnModReserv.addActionListener(this);
        this.form_res.btnRegistrarRes.addActionListener(this);
    }


    public void iniciar() {
        form_res.setTitle("Reservaciones");
        form_res.setLocationRelativeTo(null);
        form_res.txtIdReserv.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == form_res.btnRegistrarRes) {
            res.setNumReservacion(Integer.parseInt(form_res.txtNumReserv.getText()));
            res.setFechaInicio(String.valueOf(form_res.txtFechaInicio.getText()));
            res.setFechaFin(form_res.txtFechaFin.getText());
            res.setNum_cliente(Integer.parseInt(form_res.txtNumCliente.getText()));
            res.setCod_hab(Integer.parseInt(form_res.txtNumHab.getText()));
            

            if (cons_res.registrar(res)) {
                JOptionPane.showMessageDialog(null, "Se han registrado los datos.");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar los datos.");
                limpiar();
            }
        }
        if (e.getSource() == form_res.btnModReserv) {
            res.setNumReservacion(Integer.parseInt(form_res.txtNumReserv.getText()));
            res.setFechaInicio(String.valueOf(form_res.txtFechaInicio.getText()));
            res.setFechaFin(String.valueOf(form_res.txtFechaFin.getText()));;
            res.setNum_cliente(Integer.parseInt(form_res.txtNumCliente.getText()));
            res.setCod_hab(Integer.parseInt(form_res.txtNumHab.getText()));
            res.setId_res(Integer.parseInt(form_res.txtIdReserv.getText()));

            if (cons_res.modificar(res)) {
                JOptionPane.showMessageDialog(null, "Se han modificado los datos.");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar los datos.");
                limpiar();
            }
        }
        if (e.getSource() == form_res.btnEliminarReserv) {
            res.setId_res(Integer.parseInt(form_res.txtIdReserv.getText()));
            if (cons_res.eliminar(res)) {
                JOptionPane.showMessageDialog(null, "Se han eliminado los datos.");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar los datos.");
                limpiar();
            }
        }
        if (e.getSource() == form_res.btnBuscarReserv) {
            res.setNumReservacion(Integer.parseInt(form_res.txtNumReserv.getText()));
            if (cons_res.buscar(res)) {
                form_res.txtIdReserv.setText(String.valueOf(res.getId_res()));
                form_res.txtNumReserv.setText(String.valueOf(res.getNumReservacion()));
                form_res.txtFechaInicio.setText(res.getFechaInicio());
                form_res.txtFechaFin.setText(res.getFechaFin());
                form_res.txtNumCliente.setText(String.valueOf(res.getNum_cliente()));
                form_res.txtNumHab.setText(String.valueOf(res.getCod_hab()));
            } else {
                JOptionPane.showMessageDialog(null, "No se han encontrado resultados.");
                limpiar();
            }
        }
        if (e.getSource() == form_res.btnLimpiarReserv) {
            limpiar();
        }


    }

    public void limpiar() {
        form_res.txtIdReserv.setText(null);
        form_res.txtNumReserv.setText(null);
        form_res.txtFechaInicio.setText(null);
        form_res.txtFechaFin.setText(null);
        form_res.txtNumCliente.setText(null);
        form_res.txtNumHab.setText(null);
    }
    
}
