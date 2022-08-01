package Modelo;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Orel Aguilar
 */
public class ConsultasCliente extends Conexion {
    public boolean registrar(Cliente cli)
    {
        PreparedStatement ps;
        com.mysql.jdbc.Connection con = getConexion();
        
        String sql="INSERT INTO cliente (num_cliente, nombre, apellidoPaterno, apellidoMaterno, telefono) values(?,?,?,?,?)";
        try
        {
            ps=con.prepareStatement(sql);
            ps.setInt(1, cli.getNum_cliente());
            ps.setString(2, cli.getNombre());
            ps.setString(3, cli.getApellidoPaterno());
            ps.setString(4, cli.getApellidoMaterno());
            ps.setString(5, cli.getTelefono());
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
    
    public boolean modificar(Cliente cli)
    {
        PreparedStatement ps;
        Connection con=getConexion();
        
        String sql="UPDATE cliente SET num_cliente=?, nombre=?, apellidoPaterno=?, apellidoMaterno=?, telefono=? WHERE id_cliente=?";
        try
        {
            ps=con.prepareStatement(sql);
            ps.setInt(1, cli.getNum_cliente());
            ps.setString(2, cli.getNombre());
            ps.setString(3, cli.getApellidoPaterno());
            ps.setString(4, cli.getApellidoMaterno());
            ps.setString(5, cli.getTelefono());
            ps.setInt (6, cli.getId_cliente());

            
                        
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
    public boolean eliminar(Cliente cli)
    {
        PreparedStatement ps;
        Connection con=getConexion();
        
        String sql="DELETE FROM cliente WHERE id_cliente=?";
        try
        {
            ps=con.prepareStatement(sql);
            ps.setInt(1, cli.getId_cliente());
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
    public boolean buscar(Cliente cli)
    {
        PreparedStatement ps;
        ResultSet rs;  
        Connection con=getConexion();
        
        String sql="SELECT * FROM cliente WHERE num_cliente=?";
        try
        {
            ps=con.prepareStatement(sql);
            ps.setInt(1, cli.getNum_cliente());
            rs= (ResultSet) ps.executeQuery();
            if(rs.next()){
                cli.setId_cliente(Integer.parseInt(rs.getString("id_cliente")));
                cli.setNum_cliente(Integer.parseInt(rs.getString("num_cliente")));
                cli.setNombre(rs.getString("nombre"));
                cli.setApellidoPaterno(rs.getString("apellidoPaterno"));
                cli.setApellidoMaterno(rs.getString("apellidoMaterno"));
                cli.setTelefono(rs.getString("telefono"));
                return true;
            }
            return false; 
        }
        catch(SQLException ex){
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
