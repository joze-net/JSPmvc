
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;



public class GestorProfesor {
    
   
    
    private List<Profesor> listaProfesor;

    public List<Profesor> getListaProfesor(DataSource mipool) {
        
        this.listaProfesor=new ArrayList();
        
        try {
            
            Connection conexion=mipool.getConnection();//este es el metodo que nos devuelve la conexion
            Statement sentencia=conexion.createStatement();
            String consulta="Select * from profesor";
            
            ResultSet rs=sentencia.executeQuery(consulta);
            
            while(rs.next()){
                listaProfesor.add(new Profesor(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6)));
                
            }//en este while lo que hacemos es rellenar el arraylist con los resulyados obtenidos d la base de datos
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(GestorProfesor.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return listaProfesor;
    }
    
    
    
    
    
    
}
