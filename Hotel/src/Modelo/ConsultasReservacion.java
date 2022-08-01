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
public class ConsultasReservacion extends Conexion {
    Conexion conn = new Conexion();
        public boolean registrar(Reserva res)
    {
        PreparedStatement ps;
        Connection con = getConexion();
        
        String sql="INSERT INTO reservacion (numReservacion,fechaInicio, fechaFin, num_cliente, cod_hab) values(?,?,?,?,?)";
        try
        {
            ps=(PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, res.getNumReservacion());
            ps.setString(2,res.getFechaInicio());
            ps.setString(3, res.getFechaFin());
            ps.setInt(4, res.getNum_cliente());
            ps.setInt(5, res.getCod_hab());
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
    
    public boolean modificar(Reserva res)
    {
        PreparedStatement ps;
        Connection con=getConexion();
        
        String sql="UPDATE reservacion SET numReservacion=?, fechaInicio=?, fechaFin=?, num_cliente=?, cod_hab=? WHERE id_res=?";
        try
        {
            ps=(PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, res.getNumReservacion());
            ps.setString(2, res.getFechaInicio());
            ps.setString(3, res.getFechaFin());
            ps.setInt(4, res.getNum_cliente());
            ps.setInt(5, res.getCod_hab());
            ps.setInt(6, res.getId_res());                          
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
    public boolean eliminar(Reserva res)
    {
        PreparedStatement ps;
        Connection con=getConexion();
        
        String sql="DELETE FROM reservacion WHERE id_res=?";
        try
        {
            ps=(PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, res.getId_res());
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
    public boolean buscar(Reserva res)
    {
        PreparedStatement ps;
        ResultSet rs;  
        Connection con=getConexion();
        
        String sql="SELECT * FROM reservacion WHERE numReservacion=?";
        try
        {
            ps=(PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, res.getNumReservacion());
            rs= (ResultSet) ps.executeQuery();
            if(rs.next()){
                res.setId_res(Integer.parseInt(rs.getString("id_res")));
                res.setFechaInicio(rs.getString("fechaInicio"));
                res.setFechaFin(rs.getString("fechaFin"));
                res.setNumReservacion(Integer.parseInt(rs.getString("numReservacion")));
                res.setNum_cliente(Integer.parseInt(rs.getString("num_cliente")));
                res.setCod_hab(Integer.parseInt(rs.getString("cod_hab")));
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
