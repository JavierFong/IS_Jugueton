/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backEnd;

/**
 *
 * @author Work
 * @param <Y>
 */
public interface Administrador {
    public interface Administrador1<Y extends Juguete> {
        public void insertar(Y jgt); 
        public void modificar(Y jgt); 
        public void eliminar(Y jgt);
        public int generarNuevoCodigo(); 
        public boolean buscarCodigo(int cod);
        public Y[] getListado(); 
        public Y[] sort(Y[] list); 
    }
    public interface Administrador2<Y extends Proveedor> {
        public void insertar(Y jgt); 
        public void modificar(Y jgt); 
        public void eliminar(Y jgt);
        public int generarNuevoCodigo(); 
        public boolean buscarCodigo(int cod);
        public Y[] getListado();
        public Y[] sort(Y[] list);
    }
    public interface Administrador3<Y extends Usuario> {
        public void insertar(Y jgt); 
        public void modificar(Y jgt); 
        public void eliminar(Y jgt);
        public int generarNuevoCodigo(); 
        public boolean buscarCodigo(int cod);
        public Y[] getListado(); 
        public Y[] sort(Y[] list);
    }
}
