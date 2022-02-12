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
public class Nodo_Cola {

    String nombre;
    int turno;
    Nodo_Cola siguiente;

    public Nodo_Cola(String nombre, int turno) {
        this.turno = turno;
        this.nombre = nombre;
        this.siguiente = null;
    }
}
