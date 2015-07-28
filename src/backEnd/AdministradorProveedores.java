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
public class AdministradorProveedores implements Administrador.Administrador2{
    DBManager db = new DBManager();
    
    public AdministradorProveedores(){
        db.conectar();
    }

    @Override
    public void insertar(Proveedor jgt){
        String values = "('"+jgt.getCodigo()+"','"+jgt.getNombre()+"','"+jgt.getCant_juguetes()+"')";
        db.insertar("Proveedores", values);
    } 
    @Override
    public void modificar(Proveedor jgt){
        eliminar(jgt);
        insertar(jgt);
    } 
    @Override
    public void eliminar(Proveedor jgt){
        String id = "Codigo";
        String clave = String.valueOf(jgt.getCodigo());
        db.borrar("Proveedores", id, clave);
    }
    @Override
    public int generarNuevoCodigo(){
        int newcod = db.getTableLength("Proveedores");
        while (buscarCodigo(newcod)){
            newcod++; 
        }
        return newcod;
    } 
    @Override
    public boolean buscarCodigo(int cod){
        boolean flag = false;
        Statement myStm = db.getStm(); 
        try {
            ResultSet rs = myStm.executeQuery("SELECT * FROM Proveedores WHERE Codigo='"+cod+"'");
            if (rs.next()) {
                flag = true; 
            }
        } catch (Exception e) {
            
        }
        return flag;
    }
    @Override
    public Proveedor[] getListado(){
        int lim = db.getTableLength("Proveedores");
        Proveedor[] listado = new Proveedor[lim]; 
        Statement myStm = db.getStm(); 
        try {
            ResultSet rs = myStm.executeQuery("SELECT * FROM Proveedores"); 
            int i = 0; 
            while (rs.next()) {
                Proveedor temp = new Proveedor();
                temp.setCodigo(Integer.parseInt(rs.getString(1)));
                temp.setNombre(rs.getString(2)); 
                temp.setCant_juguetes(Integer.parseInt(rs.getString(3)));
                listado[i] = temp; 
                i++; 
            }
        } catch (Exception e) {
            System.out.print("No se pudo recuperar el listado de proveedores disponibles");
        }
        return listado;
    }
    
    public int getCodigo(String Nombre){
        int cod = 0;
        Statement myStm = db.getStm(); 
        try {
            ResultSet rs = myStm.executeQuery("SELECT * FROM Proveedores WHERE Nombre='"+Nombre+"'"); 
            if (rs.next()) {
                cod = Integer.parseInt(rs.getString(1)); 
            }
        } catch (Exception e) {
            System.out.print("No se pudo recuperar el codigo de "+Nombre);
        }
        return cod; 
    }
    @Override 
    public Proveedor[] sort(Proveedor[] list) {
        Proveedor temp;
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
    
    public void nuevoJuguete(int codigo,int valor){
        Statement myStm = db.getStm(); 
        try {
            ResultSet rs = myStm.executeQuery("SELECT * FROM Proveedores WHERE Codigo='"+codigo+"';"); 
            if (rs.next()){
                Proveedor temp = new Proveedor(); 
                temp.setCodigo(codigo);
                temp.setNombre(rs.getString(2));
                int cant = Integer.parseInt(rs.getString(3)) + valor;
                temp.setCant_juguetes(cant);
                this.modificar(temp);
            }
        } catch (Exception e){}
    }
    
    public Proveedor[] mayoresProveedores(){
        Statement myStm = db.getStm(); 
        Proveedor[] lista = new Proveedor[0]; 
        try {
            ResultSet rs = myStm.executeQuery("SELECT * FROM Proveedores"); 
            int c  = 0; 
            while (rs.next()) {
                Proveedor temp = new Proveedor(); 
                temp.setCant_juguetes(Integer.parseInt(rs.getString(3)));
                if (temp.getCant_juguetes()>9) {
                    c++; 
                }
            }
            rs = myStm.executeQuery("SELECT * FROM Proveedores"); 
            lista = new Proveedor[c]; 
            int i = 0; 
            while (rs.next()) {
                Proveedor temp = new Proveedor(); 
                temp.setCodigo(Integer.parseInt(rs.getString(1)));
                temp.setNombre(rs.getString(2));
                temp.setCant_juguetes(Integer.parseInt(rs.getString(3)));
                if (temp.getCant_juguetes()>9) {
                    lista[i] = temp;
                    i++;
                }
            }
        } catch (Exception e){}
        return lista; 
    }
    
    public Proveedor getProveedor(int cod){
        Statement myStm = db.getStm();
        Proveedor temp = new Proveedor();
        try{
            ResultSet rs = myStm.executeQuery("SELECT * FROM Proveedores WHERE Codigo='"+cod+"';");
            if (rs.next()) {
                temp.setCodigo(Integer.parseInt(rs.getString(1)));
                temp.setNombre(rs.getString(2));
                temp.setCant_juguetes(Integer.parseInt(rs.getString(3)));
            }
        } catch (Exception e){
            
        }
        return temp; 
    }
    
    
}
