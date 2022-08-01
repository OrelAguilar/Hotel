/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultasHabitacion;
import Modelo.Habitacion;
import Vista.FormHabitaciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Orel Aguilar
 */
public class ControlHabitacion implements ActionListener {

    private final Habitacion hab;
    private final ConsultasHabitacion cons_hab;
    private final FormHabitaciones form_hab;

    //Constructor que recibe de parametros el modelo y la vista
    public ControlHabitacion (Habitacion hab, ConsultasHabitacion cons_hab, FormHabitaciones form_hab) {
        this.hab = hab;
        this.cons_hab = cons_hab;
        this.form_hab = form_hab;
        this.form_hab.btnLimpiarHab.addActionListener(this);
        this.form_hab.btnRegistrarHab.addActionListener(this);
        this.form_hab.btnModHab.addActionListener(this);
        this.form_hab.btnEliminarHab.addActionListener(this);
        this.form_hab.btnBuscarHab.addActionListener(this);
        this.form_hab.btnMostrarHab.addActionListener(this);
    }


    public void iniciar() {
        form_hab.setTitle("Habitaciones");
        form_hab.setLocationRelativeTo(null);
        form_hab.txtId_hab.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == form_hab.btnRegistrarHab) {
            hab.setCod_hab(Integer.parseInt(form_hab.txtcod_hab.getText()));
            //hab.setTipo(form_hab.txtTipoHab.getText());
            hab.setTipo(String.valueOf(form_hab.cBoxTipoHab.getSelectedItem()));
            hab.setNum_hab(Integer.parseInt(form_hab.txtNumHab.getText()));
            hab.setPiso(Integer.parseInt(form_hab.txtPiso.getText()));
            hab.setCosto(Float.parseFloat(form_hab.Costo.getText()));
            hab.setDisponibilidad(String.valueOf(form_hab.cBoxDisponibilidad.getSelectedItem()));

            if (cons_hab.registrar(hab)) {
                JOptionPane.showMessageDialog(null, "Se han registrado los datos.");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar los datos.");
                limpiar();
            }
        }
        if (e.getSource() == form_hab.btnModHab) {
            hab.setCod_hab(Integer.parseInt(form_hab.txtcod_hab.getText()));
            hab.setTipo(String.valueOf(form_hab.cBoxTipoHab.getSelectedItem()));
            //hab.setTipo(form_hab.txtTipoHab.getText());
            hab.setNum_hab(Integer.parseInt(form_hab.txtNumHab.getText()));
            hab.setPiso(Integer.parseInt(form_hab.txtPiso.getText()));
            hab.setCosto(Float.parseFloat(form_hab.Costo.getText()));
            hab.setDisponibilidad(String.valueOf(form_hab.cBoxDisponibilidad.getSelectedItem()));;
            hab.setId_hab(Integer.parseInt(form_hab.txtId_hab.getText()));

            if (cons_hab.modificar(hab)) {
                JOptionPane.showMessageDialog(null, "Se han modificado los datos.");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar los datos.");
                limpiar();
            }
        }
        if (e.getSource() == form_hab.btnEliminarHab) {
            hab.setId_hab(Integer.parseInt(form_hab.txtId_hab.getText()));
            if (cons_hab.eliminar(hab)) {
                JOptionPane.showMessageDialog(null, "Se han eliminado los datos.");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar los datos.");
                limpiar();
            }
        }
        if (e.getSource() == form_hab.btnBuscarHab) {
            hab.setCod_hab(Integer.parseInt(form_hab.txtcod_hab.getText()));
            if (cons_hab.buscar(hab)) {
                form_hab.txtId_hab.setText(String.valueOf(hab.getId_hab()));
                form_hab.txtcod_hab.setText(String.valueOf(hab.getCod_hab()));
                form_hab.cBoxTipoHab.setSelectedItem(String.valueOf(hab.getTipo()));
                //form_hab.txtTipoHab.setText(hab.getTipo());
                form_hab.txtNumHab.setText(String.valueOf(hab.getNum_hab()));
                form_hab.txtPiso.setText(String.valueOf(hab.getPiso()));
                form_hab.Costo.setText(String.valueOf(hab.getCosto()));
                form_hab.cBoxDisponibilidad.setSelectedItem(String.valueOf(hab.getDisponibilidad()));
            } else {
                JOptionPane.showMessageDialog(null, "No se han encontrado resultados.");
                limpiar();
            }
        }
        if (e.getSource() == form_hab.btnLimpiarHab) {
            limpiar();
        }


    }

    public void limpiar() {
        form_hab.Costo.setText(null);
        form_hab.cBoxTipoHab.setSelectedItem(null);
        form_hab.cBoxDisponibilidad.setSelectedItem(null);
        form_hab.txtId_hab.setText(null);
        form_hab.txtNumHab.setText(null);
        form_hab.txtPiso.setText(null);
        form_hab.txtcod_hab.setText(null);

    }

}
