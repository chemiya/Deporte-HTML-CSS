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
import modelo.Ejecuccion;
import modelo.Planificacion;

/**
 *
 * @author chemi
 */
public class PlanificacionDB {
   public static ArrayList<Planificacion> obtenerPlanificaciones(String idPlan){
        ConnectionPool pool = ConnectionPool.getInstance();
Connection connection = pool.getConnection();
PreparedStatement ps = null;
ResultSet rs = null;
ArrayList<Planificacion> planif=new ArrayList<Planificacion>();
int idMaterial=0;

String query = "SELECT * from Planificacion "+ "WHERE idPlan=?";


    try {
ps = connection.prepareStatement(query);
ps.setString(1, idPlan);

rs = ps.executeQuery();
while(rs.next()){
   
    Planificacion pla=new Planificacion();
    pla.setIdEntrenamiento(rs.getInt("idEntrenamiento"));
    pla.setDia(rs.getInt("dia"));
     planif.add(pla);
    
}
rs.close();
ps.close();
pool.freeConnection(connection);

} catch (SQLException e) {
e.printStackTrace();

}


return planif;
    }   
}
