/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Dificultad;
import modelo.Entrenamiento;
import modelo.PlanEntrenamientos;

/**
 *
 * @author chemi
 */
public class PlanEntrenamientoDB {
        public static ArrayList<PlanEntrenamientos> buscarSimilares(String palabra, String dias, String valoracion ) {
ConnectionPool pool = ConnectionPool.getInstance();
Connection connection = pool.getConnection();
PreparedStatement ps = null;
ResultSet rs = null;
ArrayList<PlanEntrenamientos> encontrados=new ArrayList<PlanEntrenamientos>();
float minPuntuacion=0;
float maxPuntuacion=0;

if(valoracion.equals("superior a 9")){
    minPuntuacion=9;
    maxPuntuacion=10;
}else if(valoracion.equals("entre 8 y 9")){
    minPuntuacion=8;
    maxPuntuacion=9;
}else{
    minPuntuacion=7;
    maxPuntuacion=8;
}

//String query = "SELECT idEntrenamiento,Nombre,duracion,dificultad FROM Entrenamiento "+ "WHERE dificultad=?";
//String query="select e.identrenamiento, e.nombre, e.duracion from entrenamiento e, areaentrenamiento ae, area a,materialentrenamiento me, material m where e.identrenamiento=ae.identrenamiento and ae.idarea=a.idarea and a.valor=? and e.dificultad=? and me.identrenamiento=e.identrenamiento and me.idmaterial=m.idmaterial and m.valor=? ane e.duracion=?;";
//String query="select * from entrenamiento e, areaentrenamiento ae, area a,materialentrenamiento me, material m where e.duracion=? and e.dificultad=? and e.identrenamiento=ae.identrenamiento and ae.idarea=a.idarea and a.valor=? and me.identrenamiento=e.identrenamiento and me.idmaterial=m.idmaterial and m.valor=?;";
//String query="select * from entrenamiento e, areaentrenamiento ae, area a,materialentrenamiento me, material m where";
String query="select * from PlanEntrenamientos where duracion=?";

try {
ps = connection.prepareStatement(query);


ps.setString(1, dias);




rs = ps.executeQuery();

while(rs.next()){
    PlanEntrenamientos cumple=new PlanEntrenamientos();
    String nombre=(rs.getString("nombre"));
    
    if(nombre.contains(palabra)){
        if(rs.getFloat("valoracionPlan")>minPuntuacion && rs.getFloat("valoracionPlan")<maxPuntuacion){
             cumple.setDuracion(rs.getInt("duracion"));
       cumple.setNombre(rs.getString("nombre"));
        cumple.setDescripcion(rs.getString("descripcion"));
        cumple.setValoracion(rs.getFloat("valoracionPlan"));
        cumple.setIdPlan(rs.getInt("idPlan"));
       encontrados.add(cumple);
        }
       
        
        
    }
        
    
    
    
    
    
     
    
}
rs.close();
ps.close();
pool.freeConnection(connection);

} catch (SQLException e) {
e.printStackTrace();

}
return encontrados;
}
        
        
        public static PlanEntrenamientos asociarDatos(int idPlan){
        ConnectionPool pool = ConnectionPool.getInstance();
Connection connection = pool.getConnection();
PreparedStatement ps = null;
ResultSet rs = null;
PlanEntrenamientos ent=new PlanEntrenamientos();

String query = "SELECT * from PlanEntrenamientos "+ "WHERE idPlan=?";


    try {
ps = connection.prepareStatement(query);
ps.setString(1, String.valueOf(idPlan));

rs = ps.executeQuery();
while(rs.next()){
   
    ent.setNombre(rs.getString("nombre"));
    ent.setIdPlan(rs.getInt("idPlan"));
    ent.setDuracion(rs.getInt("duracion"));
       
    
}
rs.close();
ps.close();
pool.freeConnection(connection);

} catch (SQLException e) {
e.printStackTrace();

}


return ent;
    }
}
