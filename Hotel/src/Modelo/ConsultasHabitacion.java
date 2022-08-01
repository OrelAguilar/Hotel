/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Orel Aguilar
 */
public class ConsultasHabitacion extends Conexion {
        public boolean registrar(Habitacion hab)
    {
        PreparedStatement ps;
        Connection con = getConexion();
        
        String sql="INSERT INTO habitacion (cod_hab, tipo, num_hab, piso, costo, disponibilidad) values(?,?,?,?,?,?)";
        try
        {
            ps=(PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, hab.getCod_hab());
            ps.setString(2, hab.getTipo());
            ps.setInt(3, hab.getNum_hab());
            ps.setInt(4, hab.getPiso());
            ps.setFloat(5, hab.getCosto());
            ps.setString(6, hab.getDisponibilidad());
            ps.execute();
            return true;

        }
        catch(SQLException ex){
            System.err.println(ex);
            return false;
        }
        finally
        {
            try
            {
                con.close();
                System.out.println("Conexión cerrada.");
            }
            catch(SQLException e)
            {
                System.err.println(e);
            }
        }
    }
    
    public boolean modificar(Habitacion hab)
    {
        PreparedStatement ps;
        Connection con=getConexion();
        
        String sql="UPDATE habitacion SET cod_hab=?, tipo=?, num_hab=?, piso=?, costo=?, disponibilidad=? WHERE id_hab=?";
        try
        {
            ps=(PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, hab.getCod_hab());
            ps.setString(2, hab.getTipo());
            ps.setInt(3, hab.getNum_hab());
            ps.setInt(4, hab.getPiso());
            ps.setFloat(5, hab.getCosto());
            ps.setString(6, hab.getDisponibilidad());
            ps.setInt(7, hab.getId_hab());
            
                        
            ps.execute();

            return true;
        }
        catch(SQLException ex){
            System.err.println(ex);
            return false;
        }
        finally
        {
            try
            {
                con.close();
                System.out.println("Conexión cerrada.");
            }
            catch(SQLException ex)
            {
                System.err.println(ex);
            }
        }
    }
    public boolean eliminar(Habitacion hab)
    {
        PreparedStatement ps;
        Connection con=getConexion();
        
        String sql="DELETE FROM habitacion WHERE id_hab=?";
        try
        {
            ps=(PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, hab.getId_hab());
            ps.execute();
            return true;

        }
        catch(SQLException ex){
            System.err.println(ex);
            return false;
        }
        finally
        {
            try
            {
                con.close();
                System.out.println("Conexión cerrada.");
            }
            catch(SQLException ex)
            {
                System.err.println(ex);
            }
        }
    }
    public boolean buscar(Habitacion hab)
    {
        PreparedStatement ps;
        ResultSet rs;  
        Connection con=getConexion();
        
        String sql="SELECT * FROM habitacion WHERE cod_hab=?";
        try
        {
            ps=(PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, hab.getCod_hab());
            rs= (ResultSet) ps.executeQuery();
            if(rs.next()){
                hab.setId_hab(Integer.parseInt(rs.getString("id_hab")));
                hab.setCod_hab(Integer.parseInt(rs.getString("cod_hab")));
                hab.setTipo(rs.getString("tipo"));
                hab.setNum_hab(Integer.parseInt(rs.getString("num_hab")));
                hab.setPiso(Integer.parseInt(rs.getString("piso")));
                hab.setCosto(Float.parseFloat(rs.getString("costo")));                
                hab.setDisponibilidad(rs.getString("disponibilidad"));
                return true;
            }
            return false; 
        }
        catch(SQLException ex){
            System.err.println(ex);
            return false;
            
        } 
        finally
        {
            try
            {
                con.close();
                System.out.println("Conexión cerrada.");
            }
            catch(SQLException ex)
            {
                System.err.println(ex);
            }
        }
    }

    
}
