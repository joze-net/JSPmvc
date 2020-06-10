/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import modelo.GestorProfesor;
import modelo.Profesor;
/**
 *
 * @author JOZE RODRIGUEZ
 */
@WebServlet(name = "ControladorDB", urlPatterns = {"/ControladorDB"})
public class ControladorDB extends HttpServlet {
     @Resource(name="jdbc/laboratoriosql")
   DataSource mipool;
     private GestorProfesor gestorprofesor;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            
            String btnRegistrarProfesor=request.getParameter("instruccion");
            
            if(btnRegistrarProfesor!=null){
            
            switch (btnRegistrarProfesor){
                
                case "RegistrarProfesor" : 
                    
                    //rellenamo slas variables que crearan al nuevo profesor apartir de lo ue ingresa el usuario
                        int doc_prof=Integer.parseInt(request.getParameter("documento"));
                        String nom_prof=request.getParameter("nombre");
                        String ape_prof=request.getParameter("apellido");
                        int cate_prof=Integer.parseInt(request.getParameter("categoria"));
                        double sal_prof=Double.parseDouble(request.getParameter("salario"));
                        Profesor nuevoProfesor= new Profesor(doc_prof, nom_prof, ape_prof, cate_prof, sal_prof);

                        agregarProfesor(nuevoProfesor);
                        listarProfesor(request,response);
                        break;
                case "CargarDatos":
                        int codigoProfesor=Integer.parseInt(request.getParameter("codigoProfesor"));
                        cargarDatos(request,response,codigoProfesor); //este metodo se encargara de consultar el profesor segun el codigo
                
                case "ActualizarProfesor":
                        //rellenamo slas variables que crearan al nuevo profesor apartir de lo ue ingresa el usuario
                        int codigoProfe=Integer.parseInt(request.getParameter("CodigoProfesor"));
                        int doc_actualizar=Integer.parseInt(request.getParameter("documento"));
                        String nom_actualizar=request.getParameter("nombre");
                        String ape_actualizar=request.getParameter("apellido");
                        int cate_actualizar=Integer.parseInt(request.getParameter("categoria"));
                        double sal_actualizar=Double.parseDouble(request.getParameter("salario"));
                        Profesor profesorActualizar= new Profesor(codigoProfe,doc_actualizar, nom_actualizar, ape_actualizar, cate_actualizar, sal_actualizar);
                        actualizarProfesor(profesorActualizar);
                        listarProfesor(request,response);
                        break;
                        
                case "Eliminar":
                        int codigoProfesorEliminar=Integer.parseInt(request.getParameter("codigoProfesor"));
                        eliminarProfesor(request,response,codigoProfesorEliminar);
                        listarProfesor(request,response);
                        break;
                default: 
                     //   listarProfesor(request,response);
                
                
                
            }
            }else{
                listarProfesor(request,response);
            }
            
            
             
          
       
       
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void listarProfesor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         response.setContentType("text/html");
             
             
             List<Profesor> listaprofesor=this.gestorprofesor.getListaProfesor();
             
             request.setAttribute("profesores",listaprofesor);
             RequestDispatcher rutaServlet=request.getRequestDispatcher("vista/Index.jsp");
             rutaServlet.forward(request, response);
            
    }
    
    private void agregarProfesor(Profesor nuevoProfesor){
        
         try {
             this.gestorprofesor.agregarNuevoProfesor(nuevoProfesor);
         } catch (SQLException ex) {
             Logger.getLogger(ControladorDB.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    private void cargarDatos(HttpServletRequest request, HttpServletResponse response,int cod) throws ServletException, IOException {
        
        Profesor profesorCargarDatos=this.gestorprofesor.consultarProfesorPorCodigo(cod);
        
        request.setAttribute("profesor",profesorCargarDatos);
        RequestDispatcher rutaServlet1=request.getRequestDispatcher("vista/Actualizar.jsp");
        rutaServlet1.forward(request, response);
    }

    private void actualizarProfesor(Profesor profesorActualizar) {
        
         try {
             this.gestorprofesor.actualizarProfesor(profesorActualizar);
         } catch (SQLException ex) {
             Logger.getLogger(ControladorDB.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
        
    }

    private void eliminarProfesor(HttpServletRequest request, HttpServletResponse response, int codigoProfesorEliminar) {
       
         try {
             this.gestorprofesor.eliminarProfesor(codigoProfesorEliminar);
         } catch (SQLException ex) {
             Logger.getLogger(ControladorDB.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @Override
    public void init() throws ServletException {
        super.init(); 
         this.gestorprofesor=new GestorProfesor(mipool);
    }

}
