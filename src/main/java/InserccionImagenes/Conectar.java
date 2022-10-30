/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InserccionImagenes;

import InserccionImagenes.Foto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chemi
 */
public class Conectar {
     public static void main(String[] args) throws FileNotFoundException, IOException {
           // TODO code application logic here
        //clave y contraseña
        String usuario="root";
        String clave="";
        //direcion de la base
        String url="jdbc:mysql://localhost:3306/definitiva1";
        Connection con;
        //statemente y perpared, tambien set para resultados
        Statement stmt;
        ResultSet rs;
        PreparedStatement prep;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            
            //creo la conexion
            con=DriverManager.getConnection(url,usuario,clave);
            //creo el statemente
            //stmt= con.createStatement();
            //stmt.executeUpdate("  insert into entrenamiento values(1,'adelgaza con tu peso corporal','ahora puedes perder peso utilizando tu propio peso, con estos ejercicios no tendras problemas para adelgazar',,9.4,30,'chemiya11','intenso');");
            
            //Comandos basicos-------------
            //hago  insertaccion con execute. todos con update menos select
            /*stmt.executeUpdate("INSERT INTO Usuario VALUES(null,'cm11','shdjfk',38384) ");
            //obtengo los resultados con execute. select con query
            rs= stmt.executeQuery("SELECT * FROM Usuario");
            rs.next();*/
            /*do{
                //imprimo cada columna
                System.out.println(rs.getString("id")+"  Nombre: "+rs.getString("nombre")+"  Contrasena: "+rs.getString("password")+"  Documento: "+rs.getString("documento"));
            }while(rs.next());*/
            //itero sobre los resultados
            
            //puedo actualizar o eliminar
           // stmt.executeUpdate("UPDATE Usuario SET password='chemiya' where nombre='cm11'");
            //stmt.executeUpdate("DELETE FROM Usuario where nombre='cm11'");
            
            
            //Prepared-----------------
            //tengo uno preparado con ?
            // C:\Users\chemi\OneDrive\INSTITUTO\NetBeansProjects\insertarFotos\fotos\flexiones.jpg
            String ruta_archivo="C:\\Users\\chemi\\OneDrive\\INSTITUTO\\NetBeansProjects\\SSWBUENA\\src\\main\\webapp\\fotos\\gimnasio.jpg";
            File ruta = new File(ruta_archivo);
          byte[] pdf = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(pdf);
         Foto user=new Foto();
         user.setFoto(pdf);
         //prep=con.prepareStatement("insert into usuario values('chema','lozoni olmedi','chemiyauva','pass1234','chemiyauva@gmail.com','2001-04-03',199,73,'HOMBRE','DIARIO','MEJORAR_FORMA','NORMAL','SONIDO1','OPCION1',?);");
           prep=con.prepareStatement("update entrenamiento set miniatura=? where idEntrenamiento=1");
            //prep=con.prepareStatement("insert into entrenamiento values(3,'dia basico en el gimnasio','un dia normal trabajando los brazos',?,8.7,40,'chemiya11','moderado');");
            //le pongo lo que corresponda
            prep.setBytes(1, user.getFoto());
            //lo ejecuto y lo recorro
          int res = prep.executeUpdate();
            /*while(rs.next()){
                System.out.println(rs.getString(2));
            }
            rs.close();*/
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     }
        
}
