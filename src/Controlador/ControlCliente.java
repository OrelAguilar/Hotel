package Controlador;

import Modelo.Cliente;
import Modelo.ConsultasCliente;
import Vista.FormCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Orel Aguilar
 */
public class ControlCliente implements ActionListener {

    private final Cliente cli;
    private final ConsultasCliente conscli;
    private final FormCliente formcli;

    //Constructor que recibe de parametros el modelo y la vista
    public ControlCliente(Cliente cli, ConsultasCliente conscli, FormCliente formcli) {
        this.cli = cli;
        this.conscli = conscli;
        this.formcli = formcli;
        this.formcli.btnLimpiarCliente.addActionListener(this);
        this.formcli.btnRegistrarCliente.addActionListener(this);
        this.formcli.btnModificarCliente.addActionListener(this);
        this.formcli.btnEliminarCliente.addActionListener(this);
        this.formcli.btnBuscarCliente.addActionListener(this);
    }

    public void iniciar() {
        formcli.setTitle("Clientes");
        formcli.setLocationRelativeTo(null);
        formcli.txtiId_cliente.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == formcli.btnRegistrarCliente) {
            cli.setNum_cliente(Integer.parseInt(formcli.txtnumCliente.getText()));
            cli.setNombre(formcli.txtNombre.getText());
            cli.setApellidoPaterno(formcli.txtApellidoPaterno.getText());
            cli.setApellidoMaterno(formcli.txtApellidoMaterno.getText());
            cli.setTelefono(formcli.txtTelefono.getText());

            if (conscli.registrar(cli)) {
                JOptionPane.showMessageDialog(null, "Se han registrado los datos.");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar los datos.");
                limpiar();
            }
        }
        if (e.getSource() == formcli.btnModificarCliente) {
            cli.setId_cliente(Integer.parseInt(formcli.txtiId_cliente.getText()));
            cli.setNum_cliente(Integer.parseInt(formcli.txtnumCliente.getText()));
            cli.setNombre(formcli.txtNombre.getText());
            cli.setApellidoPaterno(formcli.txtApellidoPaterno.getText());
            cli.setApellidoMaterno(formcli.txtApellidoMaterno.getText());
            cli.setTelefono(formcli.txtTelefono.getText());

            if (conscli.modificar(cli)) {
                JOptionPane.showMessageDialog(null, "Se han modificado los datos.");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar los datos.");
                limpiar();
            }
        }
        if (e.getSource() == formcli.btnEliminarCliente){
            cli.setId_cliente(Integer.parseInt(formcli.txtiId_cliente.getText()));
            if (conscli.eliminar(cli)) {
                JOptionPane.showMessageDialog(null, "Se han eliminado los datos.");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar los datos.");
                limpiar();
            }
        }
        if (e.getSource() == formcli.btnBuscarCliente){
            cli.setNum_cliente(Integer.parseInt(formcli.txtnumCliente.getText()));
            if (conscli.buscar(cli)) {  
                formcli.txtiId_cliente.setText(String.valueOf(cli.getId_cliente()));
                formcli.txtnumCliente.setText(String.valueOf(cli.getNum_cliente()));
                formcli.txtNombre.setText(cli.getNombre());
                formcli.txtApellidoPaterno.setText(cli.getApellidoPaterno());
                formcli.txtApellidoMaterno.setText(cli.getApellidoMaterno());
                formcli.txtTelefono.setText(cli.getTelefono());
            } else {
                JOptionPane.showMessageDialog(null, "No se han encontrado resultados.");
                limpiar();
            }
        }
        if (e.getSource()==formcli.btnLimpiarCliente){
            limpiar();
        }

    }
    public void limpiar(){
        formcli.txtNombre.setText(null);
        formcli.txtnumCliente.setText(null);
        formcli.txtApellidoPaterno.setText(null);
        formcli.txtApellidoMaterno.setText(null);
        formcli.txtTelefono.setText(null);
        formcli.txtiId_cliente .setText(null);
    }
}
