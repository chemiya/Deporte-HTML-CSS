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
import modelo.Historial;
import modelo.PlanEntrenamientos;
import modelo.Usuario;

/**
 *
 * @author chemi
 */
public class UsuarioDB {
     public static boolean comprobacion(Usuario user) {
ConnectionPool pool = ConnectionPool.getInstance();
Connection connection = pool.getConnection();
PreparedStatement ps = null;
ResultSet rs = null;
String query = "SELECT * FROM Usuario "+ "WHERE username = ? and password=?";
try {
ps = connection.prepareStatement(query);
ps.setString(1, user.getUsername());
ps.setString(2, user.getPassword());
rs = ps.executeQuery();
boolean res = rs.next();
rs.close();
ps.close();
pool.freeConnection(connection);
return res;
} catch (SQLException e) {
e.printStackTrace();
return false;
}
} 
   
    public static void actualizarPeso(String usuario, String peso){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "update usuario set peso=?" + "WHERE username = ?";
        
        try {
ps = connection.prepareStatement(query);
ps.setString(1, peso);
ps.setString(2, usuario);
ps.executeUpdate();


ps.close();
pool.freeConnection(connection);

} catch (SQLException e) {
e.printStackTrace();

}
        
        
    } 
     
     
    public static Historial actualizarHistorial(Usuario user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean res = false;
        Historial hist = new Historial();
        int duracionAcumulada=0;
         int entrenamientosCompletados = 0;
         int opiniones=0;
         int entrenamientosCreados=0;
        
        
        String query = "SELECT * FROM realizacionentrenamiento " + "WHERE username = ?";
       
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getUsername());
            rs = ps.executeQuery();
            while (rs.next()) {
                entrenamientosCompletados++;
                
            }
            
          hist.setEntrenamientosCompletos(entrenamientosCompletados);
          
            
            query = "SELECT duracion FROM entrenamiento e, realizacionentrenamiento re WHERE re.username = ? and re.idEntrenamiento=e.idEntrenamiento";
         try{
              ps = connection.prepareStatement(query);
            ps.setString(1, user.getUsername());
            rs = ps.executeQuery();
            while (rs.next()) {
                duracionAcumulada+=rs.getInt("duracion");
                
            }
          hist.setTiempoEntrenamiento(duracionAcumulada);   
             
             
         }catch (SQLException e) {
            e.printStackTrace();

        }
         
         
         
             query = "SELECT * FROM valoracionEntrenamiento where username=?;";
         
          try{
              ps = connection.prepareStatement(query);
            ps.setString(1, user.getUsername());
            rs = ps.executeQuery();
            while (rs.next()) {
                opiniones++;
                
            }
          hist.setOpiniones(opiniones);   
             
             
         }catch (SQLException e) {
            e.printStackTrace();

        }
          
          
          
             query = "SELECT * FROM entrenamiento where username=?;";
         
          try{
              ps = connection.prepareStatement(query);
            ps.setString(1, user.getUsername());
            rs = ps.executeQuery();
            while (rs.next()) {
                entrenamientosCreados++;
                
            }
          hist.setEntrenamientosCreados(entrenamientosCreados);   
             
             
         }catch (SQLException e) {
            e.printStackTrace();

        }
          
          
           query = "SELECT * FROM valoracionEntrenamiento where username=?;";
         
          try{
              ps = connection.prepareStatement(query);
            ps.setString(1, user.getUsername());
            rs = ps.executeQuery();
            while (rs.next()) {
                opiniones++;
                
            }
          hist.setOpiniones(opiniones);   
             
             
         }catch (SQLException e) {
            e.printStackTrace();

        }

            

            
            
            
            
            query = "SELECT * FROM historial " + "WHERE username = ?";
            try {
                ps = connection.prepareStatement(query);
                ps.setString(1, user.getUsername());
                rs = ps.executeQuery();
                res = rs.next();
            } catch (Exception e) {

            }

            if (res) {
                query = "update historial set entrenamientosCompletos=? where username=?";
                try {
                    ps = connection.prepareStatement(query);
                    ps.setString(1, String.valueOf(entrenamientosCompletados));
                    ps.setString(2, user.getUsername());
                    ps.executeUpdate();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                query = "update historial set tiempoEntrenamiento=? where username=?";
                try {
                    ps = connection.prepareStatement(query);
                    ps.setString(1, String.valueOf(duracionAcumulada));
                    ps.setString(2, user.getUsername());
                    ps.executeUpdate();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                 query = "update historial set opiniones=? where username=?";
                try {
                    ps = connection.prepareStatement(query);
                    ps.setString(1, String.valueOf(opiniones));
                    ps.setString(2, user.getUsername());
                    ps.executeUpdate();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                query = "update historial set entrenamientosCreados=? where username=?";
                try {
                    ps = connection.prepareStatement(query);
                    ps.setString(1, String.valueOf(entrenamientosCreados));
                    ps.setString(2, user.getUsername());
                    ps.executeUpdate();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                query = "INSERT INTO historial VALUES (?, ?,0,?,?,?)";
                try {
                    ps = connection.prepareStatement(query);
                    ps.setString(1, user.getUsername());
                    ps.setString(2, String.valueOf(entrenamientosCompletados));
                     ps.setString(3, String.valueOf(duracionAcumulada));
                      ps.setString(4, String.valueOf(opiniones));
                      ps.setString(5, String.valueOf(entrenamientosCreados));

                    int res1 = ps.executeUpdate();
                    ps.close();
                    pool.freeConnection(connection);

                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }

            rs.close();
            ps.close();
            pool.freeConnection(connection);  

        } catch (SQLException e) {
            e.printStackTrace();

        }
        
        return hist;

    }
     
     
     public static void getImagen(String username, OutputStream respuesta) {
try {
ConnectionPool pool = ConnectionPool.getInstance();
Connection connection = pool.getConnection();
PreparedStatement statement = null;
statement = connection.prepareStatement(
"SELECT imagenPerfil FROM usuario WHERE username=? ");
statement.setString(1, username);
ResultSet result = statement.executeQuery();
if (result.next()) {
Blob blob = result.getBlob("imagenPerfil");
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
     
     
     
     
     
       public static int esAdmin(String username){
        ConnectionPool pool = ConnectionPool.getInstance();
Connection connection = pool.getConnection();
PreparedStatement ps = null;
ResultSet rs = null;
int admin=0;

String query = "SELECT * from usuario "+ "WHERE username=?";


    try {
ps = connection.prepareStatement(query);
ps.setString(1, username);

rs = ps.executeQuery();
while(rs.next()){
   String rol=rs.getString("rol");
   if(rol.equals("ADMIN")){
       admin=1;
   }
   
       
    
}
rs.close();
ps.close();
pool.freeConnection(connection);

} catch (SQLException e) {
e.printStackTrace();

}


return admin;
    }


}
