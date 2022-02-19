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
public class Lista {

    Nodo inicio;

    public Lista() {
        inicio = null;
    }

    public void insertar(String txt, int id) {
        Nodo nuevo = new Nodo(txt, id);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            Nodo actualAux = inicio;
            while (actualAux != null) {
                if (actualAux.siguiente == null) {
                    actualAux.siguiente = nuevo;
                    break;
                }
                actualAux = actualAux.siguiente;
            }
        }
    }

    public void imprimir() {
        Nodo actualAux = inicio;
        while (actualAux != null) {
            if (actualAux.siguiente == null) {
                System.out.print("[" + actualAux.id + "]");
            } else {
                System.out.print("[" + actualAux.id + "]-");
            }
            actualAux = actualAux.siguiente;
        }
        System.out.println("");
    }

    public void ordernarById() {
        Nodo aux_i;
        Nodo aux_j;
        Nodo auxValor;
        Nodo auxAnterior_i = null;
        Nodo auxAnterior_j = null;

        //recorrer la lista, iniciando en el primer nodo
        aux_i = inicio;
        while (aux_i != null) {
            //recorrer la lista iniciando en el nodo siguiente
            aux_j = aux_i.siguiente;
            while (aux_j != null) {
                if (aux_i.id > aux_j.id) {
                    System.out.println("\tcambiar: " + aux_i.id + " y " + aux_j.id + "\n");

                    //guardamos el nodo siguiente de [i]
                    auxValor = aux_i.siguiente;

                    //cambiar los apuntadores de nodos siguientes
                    if (auxValor.hashCode() != aux_j.hashCode()) { //si el nodo siguiente de [i]!=[j]
                        //hay nodos intermedios entre [i] y [j]
                        aux_i.siguiente = aux_j.siguiente;
                        aux_j.siguiente = auxValor;
                        auxAnterior_j.siguiente = aux_i;//el nodo anterior de [j] debe apuntar a [i] ya que se intercambiaran
                    } else {//si el nodo siguiente de [i]==[j]
                        //no hay nodos intermedios entre [i] y [j]
                        aux_i.siguiente = aux_j.siguiente;
                        aux_j.siguiente = aux_i;

                    }

                    //intercambiar las posiciones de los nodos [i],[j]
                    auxValor = aux_i;
                    aux_i = aux_j;
                    aux_j = auxValor;

                    ///Al cambiar la posicion de un nodo el nodo anterior de [i] debe apuntar al nuevo [i]
                    if (auxAnterior_i != null) {
                        auxAnterior_i.siguiente = aux_i;
                    }

                    //si cambiamos la posicion del primer nodo de la lista, debemos cambiar el nodo inicial.
                    if (aux_j.hashCode() == inicio.hashCode()) {
                        inicio = aux_i;
                    }
                    imprimir();

                }
                auxAnterior_j = aux_j;
                aux_j = aux_j.siguiente;
            }
            auxAnterior_i = aux_i;
            aux_i = aux_i.siguiente;
        }
    }

}
