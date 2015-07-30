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
public class Juguete {
    private int codigo;
    private int codProveedor;
    private String marca;
    private int edad;
    private String tipo; 
    private int complejidad;
    private float valorUnitario;
    private float valorAdicional;
    private float valorReal; 
    private int Cantidad; 

    public Juguete () {
        
    }
    public Juguete(int codigo, int codProveedor, String marca, int edad, String tipo, int complejidad, float valorUnitario, float valorAdicional, int cantidad) {
        this.codigo = codigo;
        this.codProveedor = codProveedor;
        this.marca = marca;
        this.edad = edad;
        this.tipo = tipo;
        this.complejidad = complejidad;
        this.valorUnitario = valorUnitario;
        this.valorAdicional = valorAdicional;
        this.valorReal = this.valorUnitario + ( this.valorAdicional * this.complejidad); 
        this.Cantidad = cantidad; 
    }

    public int getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(int codProveedor) {
        this.codProveedor = codProveedor;
    }

    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
   
    public int getCodigo() {
        return codigo;
    }

 

    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getComplejidad() {
        return complejidad;
    }

    public void setComplejidad(int complejidad) {
        this.complejidad = complejidad;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public float getValorAdicional() {
        return valorAdicional;
    }

    public void setValorAdicional(float valorAdicional) {
        this.valorAdicional = valorAdicional;
    }

    public float getValorReal() {
        return valorReal;
    }

    public void setValorReal() {
        float vu = this.getValorUnitario(); 
        float va = this.getValorAdicional(); 
        int com  = this.getComplejidad();
        this.valorReal = vu + (com * va);
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
    
    
}
