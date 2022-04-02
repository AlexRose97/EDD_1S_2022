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
public class ListaDG {

    //Clase para realizar las conexiones entre los nodos
    private class ENodo {

        int ivex;//posicion del nodo conectado
        ENodo siguiente;//nodo siguiete en la sublista

        //constructor de la clase
        public ENodo(int ivex) {
            this.ivex = ivex;
            this.siguiente = null;
        }
    }

    //Vector de la lista de adyacencia
    private class VNodo {

        String data;//valor del nodo
        ENodo inicio = null;//inicio de la sublista enlazada

        //metodo de insertar en la sublista
        public void insert(int ivex) {
            ENodo nuevo = new ENodo(ivex);
            if (inicio == null) {
                inicio = nuevo;
            } else {
                ENodo aux = inicio;
                while (true) {
                    if (aux.siguiente == null) {
                        aux.siguiente = nuevo;
                        break;
                    }
                    aux = aux.siguiente;
                }
            }
        }

        //imprimir la sublista
        public void imprimir() {
            ENodo aux = inicio;
            while (aux != null) {
                System.out.print("->" +"["+ aux.ivex+"]");
                aux = aux.siguiente;
            }
        }

    }

    //estructura principal de los nodos que conforman el grafo
    VNodo v[];

    public ListaDG(int vlen) {
        v = new VNodo[vlen];
        //inicializar el vector de los nodos del grafo
        for (int i = 0; i < v.length; i++) {
            v[i] = new VNodo();
        }
    }

    //insertar nodos en el grafo
    public void insert(String valor, int pos) {
        if (pos >= 0 && pos < v.length) {
            v[pos].data = valor;
            v[pos].inicio = null;
        }
    }

    //insertar conexiones en el grafo
    public void conexion(int inicio, int fin) {
        if (inicio >= 0 && inicio < v.length) {
            v[inicio].insert(fin);
        }
    }

    //imprimir la lsita de adyacencia del grafo
    public void imprimir() {
        for (int i = 0; i < v.length; i++) {
            System.out.print(i+"["+v[i].data+"]");
            v[i].imprimir();
            System.out.println("");
        }
    }

}
