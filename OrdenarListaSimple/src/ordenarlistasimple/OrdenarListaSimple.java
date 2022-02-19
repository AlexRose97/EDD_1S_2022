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
public class OrdenarListaSimple {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lista lista=new Lista();
        
        lista.insertar("f", 100);
        lista.insertar("f", 6);
        lista.insertar("d", 4);
        lista.insertar("e", 5);
        lista.insertar("a", 1);
        lista.insertar("c", 3);
        lista.insertar("b", 2);
        lista.insertar("b", 0);
        lista.insertar("b", 10);
        lista.insertar("b", 2);
        lista.insertar("b", 12);
        
        lista.imprimir();
        lista.ordernarById();
    }
    
}
