/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Work
 */
public class DBManager {
    private Connection con; 
    private Statement stm; 

    public DBManager() {
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Statement getStm() {
        return stm;
    }

    public void setStm(Statement stm) {
        this.stm = stm;
    }
    
    public void conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String conexion = "jdbc:mysql://localhost/Jugueton?user=JJosueFong&password=Submarino1994"; 
            con = DriverManager.getConnection(conexion); 
            stm = con.createStatement(); 
            System.out.println("Conexion exitosa");
        } catch (Exception e) {System.out.println("Error de conexion");} 
    } 
    
    public void insertar(String table, String values) {
        String insertar = "INSERT INTO "+table+" VALUES "+values;
        try { 
            Statement myStm = this.getStm(); 
            myStm.executeUpdate(insertar);
            System.out.println("Insercion exitosa en "+table);
        } catch (Exception e) {System.out.println("ERROR de inserción, en "+table);}
    }
    
    public void borrar(String table, String clave, String id) {
        String borrar = "DELETE FROM "+table+" WHERE "+clave+"='"+id+"';";
        try {
            Statement myStm = this.getStm(); 
            myStm.executeUpdate(borrar); 
            System.out.println("Eliminacion exitosa en "+table);
        } catch (Exception e) {System.out.println("Error al eliminar en "+table);}
    }
    
    public int getTableLength(String table) {
        int len = 0; 
        try {
            ResultSet rs = stm.executeQuery("SELECT * FROM "+table);
            while (rs.next()){
                len++; 
            }
        } catch (Exception e){}
        return len; 
    }
}
