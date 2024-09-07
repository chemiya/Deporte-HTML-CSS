/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author chemi
 */
public class ValoracionEntrenamiento {
    private String username;
    private int idEntrenamiento;
    private int calificacion;
    private String opinion;

    public ValoracionEntrenamiento() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIdEntrenamiento() {
        return idEntrenamiento;
    }

    public void setIdEntrenamiento(int idEntrenamiento) {
        this.idEntrenamiento = idEntrenamiento;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }
    
    
}
