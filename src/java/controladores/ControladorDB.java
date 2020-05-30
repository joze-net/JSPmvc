/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author JOZE RODRIGUEZ
 */
@WebServlet(name = "ControladorDB", urlPatterns = {"/ControladorDB"})
public class ControladorDB extends HttpServlet {
     @Resource(name="jdbc/laboratoriosql")//Aqui hacemos referencia al nombre que le dimos al archivo xml en la etiqueta name
     private DataSource mipool;//con esta variable es con la que estableceremos la conexion a DDBB
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
            
             processRequest(request, response);
              response.setContentType("text/html;charset=UTF-8");
             PrintWriter escribir=response.getWriter();
              
             Connection conexion;
             Statement consultaSql;
             ResultSet rs;
             try {
                        
             conexion=mipool.getConnection();
             
             String consulta="Select * from compañia";
             consultaSql=conexion.createStatement();
             
             rs=consultaSql.executeQuery(consulta);
             
             while(rs.next()){
                 escribir.println(rs);
                 
             }
         } catch (SQLException ex) {
             Logger.getLogger(ControladorDB.class.getName()).log(Level.SEVERE, null, ex);
             escribir.print(ex.getCause());
             
             
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

}