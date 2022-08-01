/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControlCliente;
import Modelo.Cliente;
import Modelo.Conexion;
import Modelo.ConsultasCliente;

/**
 *
 * @author Orel Aguilar
 */
public class Clientes extends javax.swing.JFrame {
    Conexion con;
    /**
     * Creates new form Clientes
     */
    public Clientes() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        rsscalelabel.RSScaleLabel.setScaleLabel(fondoClientes, "src/clientes.jpg");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblClientes = new javax.swing.JLabel();
        btnEntrarClientes = new javax.swing.JButton();
        btnRegDCliAPrin = new javax.swing.JButton();
        fondoClientes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblClientes.setFont(new java.awt.Font("Georgia", 1, 65)); // NOI18N
        lblClientes.setText("Clientes");
        getContentPane().add(lblClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 280, 60));

        btnEntrarClientes.setText("Entrar");
        btnEntrarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarClientesActionPerformed(evt);
            }
        });
        getContentPane().add(btnEntrarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 220, 90));

        btnRegDCliAPrin.setText("Inicio");
        btnRegDCliAPrin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegDCliAPrinActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegDCliAPrin, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 560, 90, -1));

        fondoClientes.setOpaque(true);
        getContentPane().add(fondoClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegDCliAPrinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegDCliAPrinActionPerformed
        // TODO add your handling code here:
        Bienvenido clienteABienv = new Bienvenido();
        clienteABienv.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegDCliAPrinActionPerformed

    private void btnEntrarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarClientesActionPerformed
        // TODO add your handling code here:
        Cliente cli = new Cliente();
        ConsultasCliente conscli = new ConsultasCliente();
        FormCliente formcli = new FormCliente();
        ControlCliente control = new ControlCliente(cli, conscli, formcli); //Solo llama al frame que se va a usar
        control.iniciar();
        formcli.setVisible(true);
        formcli.setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        
        
    }//GEN-LAST:event_btnEntrarClientesActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrarClientes;
    private javax.swing.JButton btnRegDCliAPrin;
    private javax.swing.JLabel fondoClientes;
    private javax.swing.JLabel lblClientes;
    // End of variables declaration//GEN-END:variables
}
