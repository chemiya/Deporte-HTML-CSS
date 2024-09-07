/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import BaseDatos.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.PlanEntrenamientos;
import modelo.ValoracionEntrenamiento;

/**
 *
 * @author chemi
 */
public class ValoracionEntrenamientoDB {
    public static void insert(ValoracionEntrenamiento val) {
ConnectionPool pool = ConnectionPool.getInstance();
Connection connection = pool.getConnection();
PreparedStatement ps = null;
String query="INSERT INTO ValoracionEntrenamiento VALUES (?,?,?,?)";
try {
ps = connection.prepareStatement(query);
ps.setString(1, val.getUsername());
ps.setString(2, String.valueOf(val.getIdEntrenamiento()));
ps.setString(3, String.valueOf(val.getCalificacion()));
ps.setString(4, val.getOpinion());
ps.executeUpdate();
ps.close();
pool.freeConnection(connection);

} catch (SQLException e) {
e.printStackTrace();

}
} 
    
    
      public static ArrayList<ValoracionEntrenamiento> buscar(String idEntrenamiento ) {
ConnectionPool pool = ConnectionPool.getInstance();
Connection connection = pool.getConnection();
PreparedStatement ps = null;
ResultSet rs = null;
ArrayList<ValoracionEntrenamiento> encontrados=new ArrayList<ValoracionEntrenamiento>();
float minPuntuacion=0;
float maxPuntuacion=0;



//String query = "SELECT idEntrenamiento,Nombre,duracion,dificultad FROM Entrenamiento "+ "WHERE dificultad=?";
//String query="select e.identrenamiento, e.nombre, e.duracion from entrenamiento e, areaentrenamiento ae, area a,materialentrenamiento me, material m where e.identrenamiento=ae.identrenamiento and ae.idarea=a.idarea and a.valor=? and e.dificultad=? and me.identrenamiento=e.identrenamiento and me.idmaterial=m.idmaterial and m.valor=? ane e.duracion=?;";
//String query="select * from entrenamiento e, areaentrenamiento ae, area a,materialentrenamiento me, material m where e.duracion=? and e.dificultad=? and e.identrenamiento=ae.identrenamiento and ae.idarea=a.idarea and a.valor=? and me.identrenamiento=e.identrenamiento and me.idmaterial=m.idmaterial and m.valor=?;";
//String query="select * from entrenamiento e, areaentrenamiento ae, area a,materialentrenamiento me, material m where";
String query="select * from ValoracionEntrenamiento where idEntrenamiento=?";

try {
ps = connection.prepareStatement(query);


ps.setString(1, idEntrenamiento);




rs = ps.executeQuery();

while(rs.next()){
    ValoracionEntrenamiento cumple=new ValoracionEntrenamiento();
    cumple.setUsername(rs.getString("username"));
    cumple.setOpinion(rs.getString("opinion"));
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
    
}
