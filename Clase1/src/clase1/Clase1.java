/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase1;

/**
 *
 * @author Alex Rose
 */
public class Clase1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Lista_Simple mylist = new Lista_Simple();
        mylist.Insertar_orden(6);
        mylist.Insertar_orden(1);
        mylist.Insertar_orden(5);
        mylist.Insertar_orden(4);
        mylist.Insertar_orden(2);
        mylist.Insertar_orden(3);
        mylist.Insertar_orden(100);

        mylist.Imprimir();

    }

}


/*Clase nodo para la lista simple*/
class Nodo {

    int id;
    Nodo siguiente;

    /*constructor de la clase nodo*/
    public Nodo(int id_nuevo) {
        this.id = id_nuevo;
        this.siguiente = null;
    }

}

class Lista_Simple {

    Nodo inicio;

    public Lista_Simple() {
        this.inicio = null;
    }

    /*metodo para insertar valores nuevos al final*/
    public void Insertar(int id_nuevo) {
        //System.out.println(" se insertara el valor: " + id_nuevo);
        Nodo nuevo = new Nodo(id_nuevo);

        if (inicio == null) {
            inicio = nuevo;
        } else {
            //System.out.println("se debe insertar despues del inicio");
            Nodo actualAux = inicio;

            while (actualAux != null) {
                if (actualAux.siguiente == null) {
                    //System.out.println("se inserto despues de:" + actualAux.id);
                    actualAux.siguiente = nuevo;
                    break;
                }
                actualAux = actualAux.siguiente;
            }
        }

    }

    /*metodo para imprimr*/
    public void Imprimir() {
        System.out.println("aca se imprime la lista");
        Nodo actualAux = inicio;
        while (actualAux != null) {
            if (actualAux.siguiente == null) {
                System.out.print("[" + actualAux.id + "]-->NULL");
            } else {
                System.out.print("[" + actualAux.id + "]-->");
            }
            actualAux = actualAux.siguiente;
        }
    }

    /*metodo insertar en orden*/
    public void Insertar_orden(int id_nuevo) {
        Nodo nuevo = new Nodo(id_nuevo);

        if (inicio == null) {
            inicio = nuevo;
        } else {
            Nodo actualAux = inicio;
            Nodo siguienteAux;

            while (actualAux != null) {
                siguienteAux = actualAux.siguiente;
                if (nuevo.id < actualAux.id) {//insertar al inicio de la lista
                    nuevo.siguiente = actualAux;
                    inicio = nuevo;
                    break;
                } else if (siguienteAux == null) {//insertar al final de la lista
                    actualAux.siguiente = nuevo;
                    break;
                } else if (nuevo.id < siguienteAux.id) {//insertar en medio de la lista
                    actualAux.siguiente = nuevo;
                    nuevo.siguiente=siguienteAux;
                    break;
                }
                actualAux = actualAux.siguiente;
            }
        }
    }

}
