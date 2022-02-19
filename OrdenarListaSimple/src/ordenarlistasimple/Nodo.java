/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenarlistasimple;

/**
 *
 * @author Alex Rose
 */
public class Nodo {
    String txt;
    int id;
    Nodo siguiente;

    public Nodo(String txt, int id) {
        this.id = id;
        this.txt = txt;
        this.siguiente = null;
    }  
}
