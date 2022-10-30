package modelo;


import java.util.ArrayList;
import java.util.Date;
import javax.servlet.http.Part;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class Usuario {
    private String nombre;
    private String apellidos;
    private String username;
    private String password;
    private String email;
    private Date fechaNac;
    private float altura;
    private float peso;
    private Genero genero;
    private Frecuencia frecEjerc;
    private Motivo motivo;
    private Rol rol;
    private Sonido sonido;
    private Notificacion notificacion;
    private Part imagenPerfil;
    
    public void setImagenPerfil(Part imagenPerfil){
        this.imagenPerfil=imagenPerfil;
    }
    
    public Part getImagenPerfil(){
        return imagenPerfil;
    }

    public Usuario() {
    }
    
    
    
    //private ArrayList<RealizacionEntreno> realizEntreno;
    
   
    
    public String getNombre(){
        return nombre;
    }
    public String getApellidos(){
        return apellidos;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getEmail(){
        return email;
    }
    public Date getNacimiento(){
        return fechaNac;
    }
    public float getAltura(){
        return altura;
    }
    public float getPeso(){
        return peso;
    }
    public Genero getGenero(){
        return genero;
    }
    public Frecuencia getFrecuencia(){
        return frecEjerc;
    }
    public Motivo getMotivo(){
        return motivo;
    }
    public Rol getRol(){
        return rol;
    }
   
    /*public Arraylist<RealizacionEntreno> getRealizEntreno(){
        return realizEntreno;
    }*/
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setNacimiento(Date fechaNac){
        this.fechaNac = fechaNac;
    }
    public void setAltura(float altura){
        this.altura = altura;
    }
    public void setPeso(float peso){
        this.peso = peso;
    }
    public void setGenero(Genero genero){
        this.genero = genero;
    }
    public void setFrecEjerc(Frecuencia frecEjerc){
        this.frecEjerc = frecEjerc;
    }
    public void setMotivo(Motivo motivo){
        this.motivo = motivo;
    }
    public void setRol(Rol rol){
        this.rol = rol;
    }
   
    /*public void setRealizEntreno(ArrayList<RealizacionEntreno> realizEntreno){
        this.realizEntreno = realizEntreno;
    }*/
    
    
     
     
     public Usuario(String nombre, String apellidos,String username, String password, String email,Date fecha,float altura, float peso, Genero genero,Frecuencia frecuencia, Motivo motivo, Rol rol){
         this.nombre=nombre;
         this.apellidos=apellidos;
         this.username=username;
         this.password=password;
         this.email=email;
         this.fechaNac=fecha;
         this.altura=altura;
         this.peso=peso;
         this.genero=genero;
         this.frecEjerc=frecuencia;
         this.motivo=motivo;
         this.rol=rol;
     }
}
