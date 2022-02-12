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
public class ECola_Banco {

    Nodo_Cola inicio;
    int turno;

    public ECola_Banco() {
        inicio = null;
        turno = 0;
    }

    public void insertar(String nombre) {
        turno++;
        Nodo_Cola nuevo = new Nodo_Cola(nombre, turno);

        if (inicio == null) {
            inicio = nuevo;
        } else {
            nuevo.siguiente = inicio;
            inicio = nuevo;
        }
    }

    public void imprimir() {
        Nodo_Cola actualAux = inicio;
        while (actualAux != null) {
            if (actualAux.siguiente == null) {
                System.out.print("[" + actualAux.turno + "|" + actualAux.nombre + "]");
            } else {
                System.out.print("[" + actualAux.turno + "|" + actualAux.nombre + "]-");
            }
            actualAux = actualAux.siguiente;
        }
        System.out.println("");
    }

    public String GenerarDTO(String titulo) {
        String result = "digraph G {\n";
        result += "label=\"" + titulo + "\";\n";
        String conexionesTXT = "";
        String nodosTXT = "";

        Nodo_Cola actualAux = inicio;
        while (actualAux != null) {
            nodosTXT += "N" + actualAux.hashCode() + "[label=\"" + actualAux.nombre + "\"];\n";

            if (actualAux.siguiente != null) {
                conexionesTXT += "N" + actualAux.hashCode() + "->" + "N" + actualAux.siguiente.hashCode() + ";\n";
            }
            actualAux = actualAux.siguiente;
        }

        result += "//agregar nodos\n";
        result += nodosTXT;
        result += "//enlazar nodos\n";
        result += "{rank=same;\n";
        result += conexionesTXT;

        result += "}\n";

        result += "}\n";
        return result;
    }

}
