/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolb;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;
import java.awt.Desktop;

/**
 *
 * @author Alex Rose
 */
public class ArbolB {

    int orden_arbol = 5;
    RamaB raiz;

    public ArbolB() {
        this.raiz = null;
    }

    public void insertar(int id) {
        NodoB nodo = new NodoB(id);
        if (raiz == null) {
            raiz = new RamaB();
            raiz.insertar(nodo);
        } else {
            NodoB obj = insertar_en_rama(nodo, raiz);
            if (obj != null) {
                //si devuelve algo el metodo de insertar en rama quiere decir que creo una nueva rama, y se debe insertar en el arbol
                raiz = new RamaB();
                raiz.insertar(obj);
                raiz.hoja = false;
            }
        }
    }

    private NodoB insertar_en_rama(NodoB nodo, RamaB rama) {
        if (rama.hoja) {
            rama.insertar(nodo);
            if (rama.contador == orden_arbol) {
                //si ya se insertaron todos los elementos posibles se debe dividir la rama
                return dividir(rama);
            } else {
                return null;
            }
        } else {
            NodoB temp = rama.primero;
            do {
                if (nodo.id == temp.id) {
                    return null;
                } else if (nodo.id < temp.id) {
                    NodoB obj = insertar_en_rama(nodo, temp.izquierda);
                    if (obj instanceof NodoB) {
                        rama.insertar((NodoB) obj);
                        if (rama.contador == orden_arbol) {
                            return dividir(rama);
                        }
                    }
                    return null;
                } else if (temp.siguiente == null) {
                    NodoB obj = insertar_en_rama(nodo, temp.derecha);
                    if (obj instanceof NodoB) {
                        rama.insertar((NodoB) obj);
                        if (rama.contador == orden_arbol) {
                            return dividir(rama);
                        }
                    }
                    return null;
                }
                temp = (NodoB) temp.siguiente;
            } while (temp != null);
        }
        return null;
    }

    private NodoB dividir(RamaB rama) {
        int val = -999;
        NodoB temp, Nuevito;
        NodoB aux = rama.primero;
        RamaB rderecha = new RamaB();
        RamaB rizquierda = new RamaB();

        int cont = 0;
        while (aux != null) {
            cont++;
            //implementacion para dividir unicamente ramas de 4 nodos
            if (cont < 3) {
                temp = new NodoB(aux.id);
                temp.izquierda = aux.izquierda;
                if (cont == 2) {
                    temp.derecha = aux.siguiente.izquierda;
                } else {
                    temp.derecha = aux.derecha;
                }
                //si la rama posee ramas deja de ser hoja
                if (temp.derecha != null && temp.izquierda != null) {
                    rizquierda.hoja = false;
                }

                rizquierda.insertar(temp);

            } else if (cont == 3) {
                val = aux.id;
            } else {
                temp = new NodoB(aux.id);
                temp.izquierda = aux.izquierda;
                temp.derecha = aux.derecha;
                //si la rama posee ramas deja de ser hoja
                if (temp.derecha != null && temp.izquierda != null) {
                    rderecha.hoja = false;
                }
                rderecha.insertar(temp);
            }
            aux = aux.siguiente;
        }
        Nuevito = new NodoB(val);
        Nuevito.derecha = rderecha;
        Nuevito.izquierda = rizquierda;
        return Nuevito;
    }

}
