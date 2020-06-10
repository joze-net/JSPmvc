
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import javax.swing.JOptionPane;



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
                listaProfesor.add(new Profesor(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getDouble(6)));
                
            }//en este while lo que hacemos es rellenar el arraylist con los resulyados obtenidos d la base de datos
            
            conexion.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(GestorProfesor.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return listaProfesor;
    }
    
    public void agregarNuevoProfesor(Profesor nuevoprofesor,DataSource mipool) throws SQLException{
        
         Connection conexion=mipool.getConnection();//este es el metodo que nos devuelve la conexion
         String consulta="insert into profesor (doc_prof,nom_prof,ape_prof,cate_prof,sal_prof)values(?,?,?,?,?);";
         PreparedStatement sentencia=conexion.prepareStatement(consulta);
         
         sentencia.setString(1,Integer.toString(nuevoprofesor.getDocProfesor()));
         sentencia.setString(2,nuevoprofesor.getNomProfesor());
         sentencia.setString(3,nuevoprofesor.getApeProfesor());
         sentencia.setInt(4,nuevoprofesor.getCateProfesor());
         sentencia.setDouble(5,nuevoprofesor.getSalarioProfesor());
         
         sentencia.execute();
         conexion.close();
    }
    
    public Profesor consultarProfesorPorCodigo(int CodigoProfesor,DataSource mipool){
         Profesor profesorConsultar=null;
         try {
            
            Connection conexion=mipool.getConnection();//este es el metodo que nos devuelve la conexion
            String consulta="Select * from profesor where codProfesor="+CodigoProfesor;
            Statement sentencia=conexion.createStatement();
            
            ResultSet rs=sentencia.executeQuery(consulta);
            
            while(rs.next()){
              profesorConsultar=new Profesor(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getDouble(6));
                
            }//en este while lo que hacemos es rellenar el arraylist con los resulyados obtenidos d la base de datos
            
            conexion.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(GestorProfesor.class.getName()).log(Level.SEVERE, null, ex);
            
        }
       
        
     
        
        return profesorConsultar;
        
        
        
    }

    public void actualizarProfesor(Profesor profesorActualizar,DataSource mipool) throws SQLException {
        
         Connection conexion=mipool.getConnection();//este es el metodo que nos devuelve la conexion
         String consulta="update profesor set doc_prof=?, nom_prof=?, ape_prof=?,cate_prof=?,sal_prof=? where codProfesor=?";
         PreparedStatement sentencia=conexion.prepareStatement(consulta);
         
         sentencia.setString(1,Integer.toString(profesorActualizar.getDocProfesor()));
         sentencia.setString(2,profesorActualizar.getNomProfesor());
         sentencia.setString(3,profesorActualizar.getApeProfesor());
         sentencia.setInt(4,profesorActualizar.getCateProfesor());
         sentencia.setDouble(5,profesorActualizar.getSalarioProfesor());
         sentencia.setInt(6,profesorActualizar.getCodProfesor());
         sentencia.execute();
         conexion.close();
        
    }

    public void eliminarProfesor(int codigoProfesorEliminar, DataSource mipool) throws SQLException {
        
        Connection conexion=mipool.getConnection();
        String consulta = "delete from profesor where codProfesor=?";
        PreparedStatement sentencia=conexion.prepareStatement(consulta);
        sentencia.setInt(1, codigoProfesorEliminar);
        sentencia.execute();
        conexion.close();
    }
    
    
    
    
    
    
}
