/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase4;

/**
 *
 * @author Alex Rose
 */
public class Nodo_Lista_Doble {

    int nro_caja;
    boolean activo;
    Nodo_Cola cliente;
    Nodo_Lista_Doble siguiente;
    Nodo_Lista_Doble anterior;

    public Nodo_Lista_Doble(int nro_caja, boolean activo) {
        this.activo=activo;
        this.nro_caja=nro_caja;
        this.anterior=null;
        this.siguiente=null;
        this.cliente=null;
    }
}
