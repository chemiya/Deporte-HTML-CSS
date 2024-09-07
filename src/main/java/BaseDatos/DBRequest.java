/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

/**
 *
 * @author chemi
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Frecuencia;
import modelo.Genero;
import modelo.Motivo;
import modelo.Rol;
import modelo.Usuario;

/**
 *
 * @author Usuario
 */
public class DBRequest {
    public DBRequest(){

    }
    public Usuario userLog(String usr, String pass) throws SQLException{
        Usuario user = null;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection(); //Establecer conexion con la DB
        Statement statement = connection.createStatement();
        ResultSet users = statement.executeQuery(
            "SELECT * FROM usuario");
        while (users.next()) {
            String usrname = users.getString("username");
            String usrpass = users.getString("password");
            if(usrname.equals(usr)){
                if(usrpass.equals(pass)){
                    user = new Usuario(users.getString("nombre"),users.getString("apellidos"),usrname,users.getString("password"),
                            users.getString("email"),users.getDate("fechaNac"),users.getFloat("altura"),users.getFloat("peso"),
                            Genero.valueOf(users.getString("genero")),Frecuencia.valueOf(users.getString("frecuencia")),
                            Motivo.valueOf(users.getString("motivo")),Rol.valueOf(users.getString("rol"))
                    );
                }
                else{
                    throw new IllegalArgumentException();  
                }
            }
        }
        return user;
    }
    public void userRegister(Usuario user) throws SQLException{
        //Subir el user a la DB
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection(); //Establecer conexion con la DB
        String query = "INSERT INTO usuario (nombre, apellidos, username, password, email, fechaNac, altura, peso, genero, frecuencia, motivo, rol) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 'NORMAL')";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, user.getNombre());
        ps.setString(2, user.getApellidos());
        ps.setString(3, user.getUsername());
        ps.setString(4, user.getPassword());
        ps.setString(5, user.getEmail());
        ps.setDate(6, new java.sql.Date(user.getNacimiento().getTime()));
        ps.setFloat(7, user.getAltura());
        ps.setFloat(8, user.getPeso());
        ps.setString(9, user.getGenero().name());
        ps.setString(10, user.getFrecuencia().name());
        ps.setString(11, user.getMotivo().name());
        int rowCount = ps.executeUpdate();
    }
    public boolean isInDatabase(String usr){
        boolean isInDB=false;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection(); //Establecer conexion con la DB
        try {
            Statement statement = connection.createStatement();
            ResultSet users = statement.executeQuery(
        "SELECT * FROM usuario");
            while (users.next()) {
                String usrname = users.getString("username");
                if(usrname.equals(usr)){
                    isInDB = true;
                }
            }
        } catch (SQLException e) {
            System.err.println("No se pudo acceder a la base de datos");
        }
        return isInDB;
    }
    public void updateUser(Usuario user, Usuario olduser) throws SQLException{
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection(); //Establecer conexion con la DB
        String query = "UPDATE usuario SET nombre = ?, apellidos = ?, username = ?, password = ?, email = ?, fechaNac = ?, altura = ?, peso = ?"+
            "WHERE username = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, user.getNombre());
        ps.setString(2, user.getApellidos());
        ps.setString(3, user.getUsername());
        ps.setString(4, user.getPassword());
        ps.setString(5, user.getEmail());
        ps.setDate(6, new java.sql.Date(user.getNacimiento().getTime()));
        ps.setFloat(7, user.getAltura());
        ps.setFloat(8, user.getPeso());
        ps.setString(9, olduser.getUsername());

        System.out.println(ps.toString());
        int rowCount = ps.executeUpdate();
    }
}

