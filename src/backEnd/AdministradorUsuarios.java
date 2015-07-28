/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backEnd;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Work
 */
public class AdministradorUsuarios implements Administrador.Administrador3{
    DBManager db = new DBManager(); 
    
    public AdministradorUsuarios() {
        db.conectar(); 
    }
    @Override
    public void insertar(Usuario jgt) {
        String values = "('"+jgt.getCodigo()+"','"+jgt.getNombre()+"','"+jgt.getContraseña()+"','"+jgt.getRol()+"')"; 
        db.insertar("Usuarios", values);
    }

    @Override
    public void modificar(Usuario jgt) {
        this.eliminar(jgt);
        this.insertar(jgt);
    }

    @Override
    public void eliminar(Usuario jgt) {
        String id = "Codigo";
        String clave = String.valueOf(jgt.getCodigo());
        db.borrar("Usuarios", id, clave);
    }

    @Override
    public int generarNuevoCodigo() {
        int newcod = db.getTableLength("Usuarios");
        while (buscarCodigo(newcod)){
            newcod++; 
        }
        return newcod;
    }

    @Override
    public boolean buscarCodigo(int cod) {
        boolean flag = false;
        Statement myStm = db.getStm(); 
        try {
            ResultSet rs = myStm.executeQuery("SELECT * FROM Usuarios WHERE Codigo='"+cod+"'");
            if (rs.next()) {
                flag = true; 
            }
        } catch (Exception e) {}
        return flag;
    }

    @Override
    public Usuario[] getListado() {
        int lim = db.getTableLength("Usuarios");
        Usuario[] listado = new Usuario[lim]; 
        Statement myStm = db.getStm(); 
        try {
            ResultSet rs = myStm.executeQuery("SELECT * FROM Usuarios"); 
            int i = 0; 
            while (rs.next()) {
                Usuario temp = new Usuario();
                temp.setCodigo(Integer.parseInt(rs.getString(1)));
                temp.setNombre(rs.getString(2));
                temp.setContraseña(rs.getString(3));
                temp.setRol(Integer.parseInt(rs.getString(4)));
                listado[i] = temp; 
                i++; 
            }
        } catch (Exception e) {
            System.out.print("No se pudo recuperar el listado de usuarios disponibles");
        }
        return listado;
    }
    @Override 
    public Usuario[] sort(Usuario[] list) {
        Usuario temp = new Usuario(); 
        int lim = list.length; 
        for(int i=0; i<lim; i++) {
            for(int j=(lim-1); j>i;j--) {
                int c1 = list[j].getCodigo(); 
                int c2 = list[j-1].getCodigo(); 
                if (c1 < c2) {
                    temp = list[j];
                    list[j] = list[j-1];
                    list[j-1] = temp;
                }
            }
        }
        return list; 
    }
    
    public boolean verificar(int codigo, String contraseña){
        boolean flag = false; 
        Statement myStm = db.getStm(); 
        try{
            ResultSet rs = myStm.executeQuery("SElECT * FROM Usuarios WHERE Codigo='"+codigo+"';");
            if(rs.next()){
                String pw = rs.getString(3);
                if (pw.equals(contraseña)) {
                    flag = true; 
                    System.out.print("Contraseña aceptada");
                } else {
                    System.out.print("Contraseña no valida");
                }
            }
        } catch (Exception e) {
            System.out.print("No se pudo verificar la cotraseña");
        }
        return flag; 
    }
    
    public Usuario getUsuario(int codigo){
        Statement myStm = db.getStm();
        Usuario temp = new Usuario(); 
        try{
            ResultSet rs = myStm.executeQuery("SElECT * FROM Usuarios WHERE Codigo='"+codigo+"';");
            if(rs.next()){
                temp.setCodigo(Integer.parseInt(rs.getString(1)));
                temp.setNombre(rs.getString(2));
                temp.setContraseña(rs.getString(3));
                temp.setRol(Integer.parseInt(rs.getString(4)));
            }
        } catch (Exception e) {
            System.out.print("No se pudo recuperar el usuario "+codigo);
        }
        return temp;
    }
}
