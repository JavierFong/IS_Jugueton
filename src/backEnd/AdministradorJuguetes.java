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
public class AdministradorJuguetes implements Administrador.Administrador1{
    DBManager db = new DBManager(); 
    
    public AdministradorJuguetes(){
        db.conectar();
    }
    @Override
    public void insertar(Juguete jgt) {
        String values = "('"+jgt.getCodigo()+"','"+jgt.getCodProveedor()+"','"+jgt.getMarca()+"','"+jgt.getEdad()+"','"+jgt.getTipo()+"','"+jgt.getComplejidad()+"','"+jgt.getValorUnitario()+"','"+jgt.getValorAdicional()+"','"+jgt.getValorReal()+"','"+jgt.getCantidad()+"')";
        db.insertar("Juguetes", values);
    }
    
    @Override
    public void modificar(Juguete jgt) {
        this.eliminar(jgt);
        this.insertar(jgt);
    }
    
    @Override
    public void eliminar(Juguete jgt) {
        String id = "Codigo_Juguete"; 
        String clave = String.valueOf(jgt.getCodigo());
        db.borrar("Juguetes",id,clave);
    }
    
    @Override
    public int generarNuevoCodigo() {
        int newcod = db.getTableLength("Juguetes");
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
            ResultSet rs = myStm.executeQuery("SELECT * FROM Juguetes WHERE Codigo_Juguete='"+cod+"'");
            if (rs.next()) {
                flag = true; 
            }
        } catch (Exception e) {
            
        }
        return flag; 
    }
    @Override
    public Juguete[] getListado() {
        int lim = db.getTableLength("Juguetes");
        Juguete[] listado = new Juguete[lim]; 
        Statement myStm = db.getStm(); 
        try {
            ResultSet rs = myStm.executeQuery("SELECT * FROM Juguetes"); 
            int i = 0; 
            while (rs.next()) {
                Juguete temp = new Juguete ();
                temp.setCodigo(Integer.parseInt(rs.getString(1)));
                temp.setCodProveedor(Integer.parseInt(rs.getString(2)));
                temp.setMarca(rs.getString(3));
                temp.setEdad(Integer.parseInt(rs.getString(4)));
                temp.setTipo(rs.getString(5));
                temp.setComplejidad(Integer.parseInt(rs.getString(6)));
                temp.setValorUnitario(Float.parseFloat(rs.getString(7)));
                temp.setValorAdicional(Float.parseFloat(rs.getString(8)));
                temp.setValorReal(); 
                temp.setCantidad(Integer.parseInt(rs.getString(10)));
                listado[i] = temp; 
                i++; 
            }
        } catch (Exception e) {
            System.out.print("No se pudo recuperar el listado de juguetes disponibles");
        }
        return listado; 
    }
    
    @Override 
    public Juguete[] sort(Juguete[] list) {
        Juguete temp; 
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
    
    public Juguete masCaro(){
        Juguete[] listado = this.getListado(); 
        Juguete mayor = new Juguete(0,0,"",0,"",0,0,0,0); 
        for (int i=0; i<listado.length; i++) {
            if (mayor.getValorReal()<listado[i].getValorReal()) {
                mayor = listado[i]; 
            }
        }
        return mayor; 
    }
    
    public Juguete[] juguetesMecanicos(){
        Juguete[] list = new Juguete[0]; 
        Statement myStm = db.getStm(); 
        try {
            int c = 0; 
            ResultSet rs = myStm.executeQuery("SELECT * FROM Juguetes WHERE Tipo = 'Mecanico'");
            while (rs.next()) {
                c++; 
            }
            list = new Juguete[c]; 
            rs = myStm.executeQuery("SELECT * FROM Juguetes WHERE Tipo = 'Mecanico';");
            int i = 0; 
            while (rs.next()) {
                Juguete temp = new Juguete();  
                temp.setCodigo(Integer.parseInt(rs.getString(1)));
                temp.setCodProveedor(Integer.parseInt(rs.getString(2)));
                temp.setMarca(rs.getString(3));
                temp.setEdad(Integer.parseInt(rs.getString(4)));
                temp.setTipo(rs.getString(5)); 
                temp.setComplejidad(Integer.parseInt(rs.getString(6)));
                temp.setValorUnitario(Float.parseFloat(rs.getString(7)));
                temp.setValorAdicional(Float.parseFloat(rs.getString(8)));
                temp.setValorReal(); 
                temp.setCantidad(Integer.parseInt(rs.getString(10)));
                list[i] = temp; 
                i++; 
            }
        } catch (Exception e){}
        
        Juguete temp; 
        int lim = list.length; 
        for(int i=0; i<lim; i++) {
            for(int j=(lim-1); j>i;j--) {
                int c1 = list[j].getComplejidad(); 
                int c2 = list[j-1].getComplejidad(); 
                if (c1 < c2) {
                    temp = list[j];
                    list[j] = list[j-1];
                    list[j-1] = temp;
                }
            }
        }
        
        return list; 
    }
    public Juguete[] juguetesElectronicos(){
        Juguete[] list = new Juguete[0]; 
        Statement myStm = db.getStm(); 
        try {
            int c = 0; 
            ResultSet rs = myStm.executeQuery("SELECT * FROM Juguetes WHERE Tipo = 'Electronico'");
            while (rs.next()) {
                c++; 
            }
            list = new Juguete[c]; 
            rs = myStm.executeQuery("SELECT * FROM Juguetes WHERE Tipo = 'Electronico';");
            int i = 0; 
            while (rs.next()) {
                Juguete temp = new Juguete();  
                temp.setCodigo(Integer.parseInt(rs.getString(1)));
                temp.setCodProveedor(Integer.parseInt(rs.getString(2)));
                temp.setMarca(rs.getString(3));
                temp.setEdad(Integer.parseInt(rs.getString(4)));
                temp.setTipo(rs.getString(5)); 
                temp.setComplejidad(Integer.parseInt(rs.getString(6)));
                temp.setValorUnitario(Float.parseFloat(rs.getString(7)));
                temp.setValorAdicional(Float.parseFloat(rs.getString(8)));
                temp.setValorReal(); 
                temp.setCantidad(Integer.parseInt(rs.getString(10)));
                list[i] = temp; 
                i++; 
            }
        } catch (Exception e){}
        
        Juguete temp; 
        int lim = list.length; 
        for(int i=0; i<lim; i++) {
            for(int j=(lim-1); j>i;j--) {
                float c1 = list[j].getValorReal(); 
                float c2 = list[j-1].getValorReal(); 
                if (c1 < c2) {
                    temp = list[j];
                    list[j] = list[j-1];
                    list[j-1] = temp;
                }
            }
        }
        
        return list; 
    }
    
    public Juguete[] listadoProveedor(int cod) {
        Juguete[] list = new Juguete[0]; 
        Statement myStm = db.getStm(); 
        try {
            ResultSet rs = myStm.executeQuery("SELECT * FROM Juguetes WHERE Codigo_Proovedor='"+cod+"';");
            int c = 0; 
            while (rs.next()){
                c++; 
            }
            list = new Juguete[c]; 
            rs = myStm.executeQuery("SELECT * FROM Juguetes WHERE Codigo_Proovedor='"+cod+"';");
            int i = 0; 
            while (rs.next()){
                Juguete temp = new Juguete(); 
                temp.setCodigo(Integer.parseInt(rs.getString(1)));
                temp.setCodProveedor(Integer.parseInt(rs.getString(2)));
                temp.setMarca(rs.getString(3));
                temp.setEdad(Integer.parseInt(rs.getString(4)));
                temp.setTipo(rs.getString(5)); 
                temp.setComplejidad(Integer.parseInt(rs.getString(6)));
                temp.setValorUnitario(Float.parseFloat(rs.getString(7)));
                temp.setValorAdicional(Float.parseFloat(rs.getString(8)));
                temp.setValorReal(); 
                temp.setCantidad(Integer.parseInt(rs.getString(10)));
                list[i] = temp; 
                i++; 
            }
        } catch (Exception e){}
        list = this.sort(list); 
        return list; 
    }
    
}
