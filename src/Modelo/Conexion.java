package Modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Orel Aguilar
 */
public class Conexion {
    private final String Driver="com.mysql.jdbc.Driver";
    private final String base="hotel";
    private final String user="root";
    private final String password="Orel50192";
    private final String url="jdbc:mysql://localhost:3306/"+base;
    private Connection conexion=null;
    
    public Connection getConexion()
    {
        try            
        {
            Class.forName(Driver);
            
            conexion= (Connection) DriverManager.getConnection(this.url, this.user, this.password);
            System.out.println("Conexion establecida");
        }
        catch(SQLException e)
        {
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conexion;
    }
    
}
