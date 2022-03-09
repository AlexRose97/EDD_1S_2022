/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolb;

/**
 *
 * @author Alex Rose
 */
public class NodoB {

    //Valores
    int id;
    //Apuntadores
    NodoB siguiente;
    NodoB anterior;
    RamaB derecha;
    RamaB izquierda;

    public NodoB(int id) {
        this.id = id;
        this.anterior = null;
        this.siguiente = null;
        this.derecha = null;
        this.izquierda = null;
    }

}
