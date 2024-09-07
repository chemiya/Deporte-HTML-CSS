package modelo;

import javax.servlet.http.Part;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class Entrenamiento {
    private int idEntrenamiento;
     private String nombre;
    private String descripcion;
    private Dificultad dificultad;
    private float valoracionMedia;
private int duracion;
private String username;
    private Part miniatura;
    private String videoUrl;

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public int getIdEntrenamiento() {
        return idEntrenamiento;
    }

    public void setIdEntrenamiento(int idEntrenamiento) {
        this.idEntrenamiento = idEntrenamiento;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
   

    public Part getFotoUser() {
        return miniatura;
    }

    public void setFotoUser(Part fotoUser) {
        this.miniatura = fotoUser;
    }
    
    public Entrenamiento(){
        
    }
    
   
    
    public String getNombre(){
        return nombre;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public Dificultad getDificultad(){
        return dificultad;
    }
   
    public Part getMiniatura(){
        return miniatura;
    }
    public float getValoracionMedia(){
        return valoracionMedia;
    }
   
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public void setDificultad(Dificultad dificultad){
	this.dificultad = dificultad; 
    }
   
    public void setValoracionMedia(float valoracionMedia){
	this.valoracionMedia = valoracionMedia; 
    }
   
}
