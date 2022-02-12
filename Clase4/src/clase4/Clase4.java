/*
En un banco existe una cola de recepcion
en la cual los clientes esperan su turno por ser atendidos,
el banco posee un listado de cajeros que algunas veces estan disponible
y los clientes ingresan a dichas cajas

Simular el comportamiento de las estructuras
    *una lista doblemente enlazada para las cajas (5 cajas/activas aleatorias)
    *una cola para la recepcion (6 clientes)
 */
package clase4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

/**
 *
 * @author Alex Rose
 */
public class Clase4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ejemplo();

        //ordenamiento
//        int[] lista = {0, 5, 1, 2, 4, 3};
//        for (int i = 0; i < lista.length; i++) {
//            for (int j = 0; j < lista.length-1; j++) {
//                if(lista[i]<lista[j]){
//                    int aux=lista[i];
//                    lista[i]=lista[j];
//                    lista[j]=aux;
//                }
//            }
//        }
//        
//        for (int i = 0; i < lista.length; i++) {
//            System.out.println(lista[i]);
//        }
//        
    }

    public static void Ejemplo() {
        Random rd = new Random(); // creating Random object

        //Crear la cola del banco
        ECola_Banco eCola_Banco = new ECola_Banco();
        //insertar los clientes
        System.out.println("---------------Clientes------------");
        eCola_Banco.insertar("JUAN");
        eCola_Banco.insertar("PEDRO");
        eCola_Banco.insertar("DAVID");
        eCola_Banco.insertar("ALEX");
        eCola_Banco.insertar("JUANA");
        eCola_Banco.insertar("CARLOS");
        eCola_Banco.imprimir();

        //Crear la lista de cajeros
        ELista_Cajas eLista_Cajas = new ELista_Cajas();
        //Insertar sus Cajas
        System.out.println("-----------cajas-----------");
        eLista_Cajas.insertar(6, rd.nextBoolean());
        eLista_Cajas.insertar(2, rd.nextBoolean());
        eLista_Cajas.insertar(8, rd.nextBoolean());
        eLista_Cajas.insertar(1, rd.nextBoolean());
        eLista_Cajas.insertar(3, rd.nextBoolean());
        eLista_Cajas.insertar(4, rd.nextBoolean());

        eLista_Cajas.imprimir();

        //Graficar las estructuras
        GenerarImagen("eCola_Banco", eCola_Banco.GenerarDTO("Cola del banco"));
        GenerarImagen("eLista_Cajas", eLista_Cajas.GenerarDTO("Lista de Cajas"));

        //mover un cliente de la cola a lista
    }

    public static void GenerarImagen(String nombre, String txtDTO) {
        try {
            //-----------Generar el txt
            String contenido = txtDTO;
            File file = new File(nombre + ".txt");

            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();

            //---------Compilar el dto
            String dotPath = "C:\\Program Files (x86)\\Graphviz\\bin\\dot.exe";
            String fileIn = file.getCanonicalPath();
            String fileOU = fileIn.replace(".txt", ".jpg");
            String tParam = "-Tjpg";
            String tOparam = "-o";

            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileIn;
            cmd[3] = tOparam;
            cmd[4] = fileOU;

            Runtime rt = Runtime.getRuntime();
            rt.exec(cmd);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
