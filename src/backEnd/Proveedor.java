/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backEnd;

/**
 *
 * @author Work
 */
public class Proveedor {
    int codigo; 
    String nombre; 
    int cant_juguetes; 

    public Proveedor(int codigo, String nombre, int cant_juguetes) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cant_juguetes = cant_juguetes;
    }

    public Proveedor() {
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setCant_juguetes(int cant_juguetes) {
        this.cant_juguetes = cant_juguetes;
    }
    
    public int getCant_juguetes() {
        return cant_juguetes;
    }
    
}
