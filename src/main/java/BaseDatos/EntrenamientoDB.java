/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import BaseDatos.ConnectionPool;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Dificultad;
import modelo.Entrenamiento;
import modelo.RealizacionEntrenamiento;

/**
 *
 * @author chemi
 */
public class EntrenamientoDB {
    
    public static Entrenamiento asociarDatos(int idEntrenamiento){
        ConnectionPool pool = ConnectionPool.getInstance();
Connection connection = pool.getConnection();
PreparedStatement ps = null;
ResultSet rs = null;
Entrenamiento ent=new Entrenamiento();

String query = "SELECT nombre,duracion,descripcion,dificultad FROM Entrenamiento "+ "WHERE idEntrenamiento=?";


    try {
ps = connection.prepareStatement(query);
ps.setString(1, String.valueOf(idEntrenamiento));

rs = ps.executeQuery();
while(rs.next()){
   
    ent.setDuracion(rs.getInt("duracion"));
    ent.setNombre(rs.getString("nombre"));
     ent.setIdEntrenamiento(idEntrenamiento);
      ent.setDescripcion(rs.getString("descripcion"));
      if(rs.getString("dificultad").equals("MODERADO")){
          ent.setDificultad(Dificultad.MODERADO);
      }else if(rs.getString("dificultad").equals("INTENSO")){
          ent.setDificultad(Dificultad.INTENSO);
      }else{
          ent.setDificultad(Dificultad.SUAVE);
      }
       
    
}
rs.close();
ps.close();
pool.freeConnection(connection);

} catch (SQLException e) {
e.printStackTrace();

}


return ent;
    }
    
    public static ArrayList<Entrenamiento> obtenerRecomendados(){
        ConnectionPool pool = ConnectionPool.getInstance();
Connection connection = pool.getConnection();
PreparedStatement ps = null;
ResultSet rs = null;
ArrayList<Entrenamiento> encontrados=new ArrayList<Entrenamiento>();
String query="select * from entrenamiento";
try {
ps = connection.prepareStatement(query);






rs = ps.executeQuery();

while(rs.next()){
    Entrenamiento cumple=new Entrenamiento();
    cumple.setNombre(rs.getString("nombre"));
    cumple.setIdEntrenamiento(rs.getInt("idEntrenamiento"));
   cumple.setDuracion(rs.getInt("duracion"));
    
   
    
    if(rs.getString("dificultad").equals("intenso")){
        cumple.setDificultad(Dificultad.INTENSO);
    }else if(rs.getString("dificultad").equals("moderado")){
        cumple.setDificultad(Dificultad.MODERADO);
    }else{
         cumple.setDificultad(Dificultad.SUAVE);
    }
    
    
    
    
     
    encontrados.add(cumple);
}
rs.close();
ps.close();
pool.freeConnection(connection);

} catch (SQLException e) {
e.printStackTrace();

}
return encontrados;
    }
    
          public static ArrayList<Entrenamiento> buscarSimilares(String area, String minutos, String material, String dificultad) {
ConnectionPool pool = ConnectionPool.getInstance();
Connection connection = pool.getConnection();
PreparedStatement ps = null;
ResultSet rs = null;
ArrayList<Entrenamiento> encontrados=new ArrayList<Entrenamiento>();


//String query = "SELECT idEntrenamiento,Nombre,duracion,dificultad FROM Entrenamiento "+ "WHERE dificultad=?";
//String query="select e.identrenamiento, e.nombre, e.duracion from entrenamiento e, areaentrenamiento ae, area a,materialentrenamiento me, material m where e.identrenamiento=ae.identrenamiento and ae.idarea=a.idarea and a.valor=? and e.dificultad=? and me.identrenamiento=e.identrenamiento and me.idmaterial=m.idmaterial and m.valor=? ane e.duracion=?;";
String query="select * from entrenamiento e, areaentrenamiento ae, area a,materialentrenamiento me, material m where e.duracion=? and e.dificultad=? and e.identrenamiento=ae.identrenamiento and ae.idarea=a.idarea and a.valor=? and me.identrenamiento=e.identrenamiento and me.idmaterial=m.idmaterial and m.valor=?;";
//String query="select * from entrenamiento e, areaentrenamiento ae, area a,materialentrenamiento me, material m where";
try {
ps = connection.prepareStatement(query);

ps.setString(3, area);
ps.setString(2, dificultad);
ps.setString(4, material);
ps.setString(1, minutos);




rs = ps.executeQuery();

while(rs.next()){
    Entrenamiento cumple=new Entrenamiento();
    cumple.setNombre(rs.getString("nombre"));
    cumple.setIdEntrenamiento(rs.getInt("idEntrenamiento"));
   cumple.setDuracion(rs.getInt("duracion"));
    
   
    
    if(rs.getString("dificultad").equals("intenso")){
        cumple.setDificultad(Dificultad.INTENSO);
    }else if(rs.getString("dificultad").equals("moderado")){
        cumple.setDificultad(Dificultad.MODERADO);
    }else{
         cumple.setDificultad(Dificultad.SUAVE);
    }
    
    
    
    
     
    encontrados.add(cumple);
}
rs.close();
ps.close();
pool.freeConnection(connection);

} catch (SQLException e) {
e.printStackTrace();

}
return encontrados;
}
       
       public static void getMiniatura(String nombre, OutputStream respuesta) {
try {
ConnectionPool pool = ConnectionPool.getInstance();
Connection connection = pool.getConnection();
PreparedStatement statement = null;
statement = connection.prepareStatement(
"SELECT miniatura FROM entrenamiento WHERE nombre=? ");
statement.setString(1, nombre);
ResultSet result = statement.executeQuery();
if (result.next()) {
Blob blob = result.getBlob("miniatura");
if (!result.wasNull() && blob.length() > 1) {
InputStream imagen = blob.getBinaryStream();
byte[] buffer = new byte[1000];
int len = imagen.read(buffer);
while (len != -1) {
respuesta.write(buffer, 0, len);
len = imagen.read(buffer);
}
imagen.close();
} }
pool.freeConnection(connection);
} catch (Exception e) {
e.printStackTrace();
} } 
       
       
       
       public static int insert(Entrenamiento ent) {
ConnectionPool pool = ConnectionPool.getInstance();
Connection connection = pool.getConnection();
PreparedStatement ps = null;
String query = "INSERT INTO entrenamiento (nombre,descripcion,miniatura,valoracionMedia,duracion,username,dificultad,videoUrl) VALUES (?, ?, null,null,null,?,?,?)";
try {
ps = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
ps.setString(1, ent.getNombre());
ps.setString(2, ent.getDescripcion());
ps.setString(3, ent.getUsername());
if(ent.getDificultad().equals("INTENSO")){
   ps.setString(4, "intenso"); 
}else if(ent.getDificultad().equals("MODERADO")){
     ps.setString(4, "moderado"); 
}else{
     ps.setString(4, "suave"); 
}
ps.setString(5, ent.getVideoUrl());
int res = 0;
ps.executeUpdate();
ResultSet rs = ps.getGeneratedKeys();
if (rs.next()) {
res = rs.getInt(1);
} 

ps.close();
pool.freeConnection(connection);
return res;
} catch (SQLException e) {
e.printStackTrace();
return 0;
}
}
       
    
}
