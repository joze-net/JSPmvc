/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


public class Profesor {
    
    private int codProfesor;
    private int docProfesor;
    private String nomProfesor;
    private String apeProfesor;
    private int cateProfesor;
    private double salarioProfesor;

    public int getCodProfesor() {
        return codProfesor;
    }

    public void setCodProfesor(int codProfesor) {
        this.codProfesor = codProfesor;
    }

    public Profesor(int codProfesor, int docProfesor, String nomProfesor, String apeProfesor, int cateProfesor, double salarioProfesor) {
        this.codProfesor = codProfesor;
        this.docProfesor = docProfesor;
        this.nomProfesor = nomProfesor;
        this.apeProfesor = apeProfesor;
        this.cateProfesor = cateProfesor;
        this.salarioProfesor = salarioProfesor;
    }

    public int getDocProfesor() {
        return docProfesor;
    }

    public void setDocProfesor(int docProfesor) {
        this.docProfesor = docProfesor;
    }

    public String getNomProfesor() {
        return nomProfesor;
    }

    public void setNomProfesor(String nomProfesor) {
        this.nomProfesor = nomProfesor;
    }

    public String getApeProfesor() {
        return apeProfesor;
    }

    public void setApeProfesor(String apeProfesor) {
        this.apeProfesor = apeProfesor;
    }

    public int getCateProfesor() {
        return cateProfesor;
    }

    public void setCateProfesor(int cateProfesor) {
        this.cateProfesor = cateProfesor;
    }

    public double getSalarioProfesor() {
        return salarioProfesor;
    }

    public void setSalarioProfesor(double salarioProfesor) {
        this.salarioProfesor = salarioProfesor;
    }
    
    public String toString(){
        return "Codigo: "+codProfesor+"Documento: "+docProfesor+"Nombre: "+nomProfesor+" Apellido: "+apeProfesor+" Categoria: "+cateProfesor+" Salario: "+salarioProfesor;
    }
    
}
