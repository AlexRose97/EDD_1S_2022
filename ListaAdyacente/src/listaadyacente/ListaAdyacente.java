/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaadyacente;

/**
 *
 * @author Alex Rose
 */
public class ListaAdyacente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaDG miLista=new ListaDG(7);
        ////lista
        miLista.insert("A", 0);
        miLista.insert("B", 1);
        miLista.insert("C", 2);
        miLista.insert("D", 3);
        miLista.insert("E", 4);
        miLista.insert("F", 5);
        miLista.insert("G", 6);
        ///conexiones
        miLista.conexion(0,1);
        miLista.conexion(1,2);miLista.conexion(1,4);miLista.conexion(1,5);
        miLista.conexion(2,4);
        miLista.conexion(3,2);
        miLista.conexion(4,1);miLista.conexion(4,3);
        miLista.conexion(5,6);
        miLista.imprimir();
    }
    
}
