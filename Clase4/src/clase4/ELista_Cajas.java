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
public class ELista_Cajas {

    Nodo_Lista_Doble inicio;

    public ELista_Cajas() {
        inicio = null;
    }

    public void insertar(int nro_caja, boolean activo) {
        Nodo_Lista_Doble nuevo = new Nodo_Lista_Doble(nro_caja, activo);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            Nodo_Lista_Doble actualAux = inicio;
            while (actualAux != null) {
                if (actualAux.siguiente == null) {
                    nuevo.anterior = actualAux;
                    actualAux.siguiente = nuevo;
                    break;
                }
                actualAux = actualAux.siguiente;
            }

        }
    }

    public void imprimir() {
        Nodo_Lista_Doble actualAux = inicio;
        while (actualAux != null) {
            if (actualAux.siguiente == null) {
                System.out.print("[" + actualAux.nro_caja + ", " + actualAux.activo + "]");
            } else {
                System.out.print("[" + actualAux.nro_caja + ", " + actualAux.activo + "]<-->");
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

        Nodo_Lista_Doble actualAux = inicio;
        while (actualAux != null) {
            nodosTXT += "N" + actualAux.hashCode() + "[label=\"" + actualAux.nro_caja + "\"];\n";

            if (actualAux.siguiente != null) {
                conexionesTXT += "N" + actualAux.hashCode() + "->" + "N" + actualAux.siguiente.hashCode() + ";\n";
            }
            
            if (actualAux.anterior != null) {
                conexionesTXT += "N" + actualAux.hashCode() + "->" + "N" + actualAux.anterior.hashCode() + ";\n";
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
