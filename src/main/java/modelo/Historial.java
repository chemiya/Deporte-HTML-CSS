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
public class Historial {
    private String username;
    private int entrenamientosCompletos;
    private int planesCompletos;
    private float tiempoEntrenamiento;
    private int opiniones;
    private int entrenamientosCreados;

    public Historial() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getEntrenamientosCompletos() {
        return entrenamientosCompletos;
    }

    public void setEntrenamientosCompletos(int entrenamientosCompletos) {
        this.entrenamientosCompletos = entrenamientosCompletos;
    }

    public int getPlanesCompletos() {
        return planesCompletos;
    }

    public void setPlanesCompletos(int planesCompletos) {
        this.planesCompletos = planesCompletos;
    }

    public float getTiempoEntrenamiento() {
        return tiempoEntrenamiento;
    }

    public void setTiempoEntrenamiento(float tiempoEntrenamiento) {
        this.tiempoEntrenamiento = tiempoEntrenamiento;
    }

    public int getOpiniones() {
        return opiniones;
    }

    public void setOpiniones(int opiniones) {
        this.opiniones = opiniones;
    }

    public int getEntrenamientosCreados() {
        return entrenamientosCreados;
    }

    public void setEntrenamientosCreados(int entrenamientosCreados) {
        this.entrenamientosCreados = entrenamientosCreados;
    }
    
    
}
