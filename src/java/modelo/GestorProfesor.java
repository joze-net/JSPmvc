
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
    private Connection conexion;
    private PreparedStatement sentencia;
    private DataSource mipool;
    
    
    public GestorProfesor(DataSource mipool){
        this.mipool=mipool;
    }
    
    public List<Profesor> getListaProfesor() {
        
        this.listaProfesor=new ArrayList();
        
        try {
            
            Connection conexion=this.mipool.getConnection();//este es el metodo que nos devuelve la conexion
            Statement sentencia=conexion.createStatement();
            String consulta="Select * from profesor";
            
            ResultSet rs=sentencia.executeQuery(consulta);
            
            while(rs.next()){
                listaProfesor.add(new Profesor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getDouble(6)));
                
            }//en este while lo que hacemos es rellenar el arraylist con los resulyados obtenidos d la base de datos
            sentencia.close();
            conexion.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(GestorProfesor.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return listaProfesor;
    }
    
    public void agregarNuevoProfesor(Profesor nuevoprofesor) throws SQLException{
        
         Connection conexion=this.mipool.getConnection();//este es el metodo que nos devuelve la conexion
         String consulta="insert into profesor (doc_prof,nom_prof,ape_prof,cate_prof,sal_prof)values(?,?,?,?,?);";
         PreparedStatement sentencia=conexion.prepareStatement(consulta);
         
         sentencia.setString(1,nuevoprofesor.getDocProfesor());
         sentencia.setString(2,nuevoprofesor.getNomProfesor());
         sentencia.setString(3,nuevoprofesor.getApeProfesor());
         sentencia.setInt(4,nuevoprofesor.getCateProfesor());
         sentencia.setDouble(5,nuevoprofesor.getSalarioProfesor());
         
         sentencia.execute();
         sentencia.close();
         conexion.close();
    }
    
    public Profesor consultarProfesorPorCodigo(int CodigoProfesor){
         Profesor profesorConsultar=null;
         try {
            
            Connection conexion=this.mipool.getConnection();//este es el metodo que nos devuelve la conexion
            String consulta="Select * from profesor where codProfesor="+CodigoProfesor;
            Statement sentencia=conexion.createStatement();
            
            ResultSet rs=sentencia.executeQuery(consulta);
            
            while(rs.next()){
              profesorConsultar=new Profesor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getDouble(6));
                
            }//en este while lo que hacemos es rellenar el arraylist con los resulyados obtenidos d la base de datos
            sentencia.close();
            conexion.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(GestorProfesor.class.getName()).log(Level.SEVERE, null, ex);
            
        }
       
        
     
        
        return profesorConsultar;
        
        
        
    }

    public void actualizarProfesor(Profesor profesorActualizar) throws SQLException {
        
         Connection conexion=this.mipool.getConnection();//este es el metodo que nos devuelve la conexion
         String consulta="update profesor set doc_prof=?, nom_prof=?, ape_prof=?,cate_prof=?,sal_prof=? where codProfesor=?";
         PreparedStatement sentencia=conexion.prepareStatement(consulta);
         
         sentencia.setString(1,profesorActualizar.getDocProfesor());
         sentencia.setString(2,profesorActualizar.getNomProfesor());
         sentencia.setString(3,profesorActualizar.getApeProfesor());
         sentencia.setInt(4,profesorActualizar.getCateProfesor());
         sentencia.setDouble(5,profesorActualizar.getSalarioProfesor());
         sentencia.setInt(6,profesorActualizar.getCodProfesor());
         sentencia.execute();
         conexion.close();
         sentencia.close();
        
    }

    public void eliminarProfesor(int codigoProfesorEliminar) throws SQLException {
        
        try{
        this.conexion=this.mipool.getConnection();
        String consulta = "delete from profesor where codProfesor=?";
        this.sentencia=this.conexion.prepareStatement(consulta);
        this.sentencia.setInt(1, codigoProfesorEliminar);
        this.sentencia.execute();
        
        }finally{
            this.conexion.close();
            this.sentencia.close();
        }
    }
    
    
    
    
    
    
}
