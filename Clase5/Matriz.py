from NodoMatriz import NodoMatriz


class Matriz():
    def __init__(self):
        self.root=NodoMatriz(-1,-1,"Root")


##Buscar columna
    def buscar_columna(self,x):
        aux=self.root
        while aux is not None:
            if(aux.x==x):
                return aux
            aux=aux.siguiente
        return None
##Buscar la fila
    def buscar_fila(self,y):
        aux=self.root
        while aux is not None:
            if(aux.y==y):
                return aux
            aux=aux.abajo
        return None
##Insertar Cabecera Columna
    def crear_columna(self,x):
        nodo_col=self.root
        nuevo=NodoMatriz(x,-1,"COL")
        columna=self.insertar_orden_col(nuevo,nodo_col)
        return columna

##Insertar en orden columnas
    def insertar_orden_col(self,nuevo,cabeza_col):
        aux = cabeza_col
        insertado=False
        while True:
            if(nuevo.x==aux.x):
                # si la posicion ya existe sobre escribimos
                aux.y=nuevo.y
                aux.dato=nuevo.dato
                return aux
            elif(aux.x>nuevo.x):
                #insertar en medio, antes del aux
                insertado=True
                break
            if aux.siguiente is not None:
                aux=aux.siguiente
            else:
                #insertar despues del auxiliar
                insertado=False
                break
        if insertado:
            nuevo.siguiente=aux
            aux.anterior.siguiente=nuevo
            nuevo.anterior=aux.anterior
            aux.anterior=nuevo
        else:
            aux.siguiente=nuevo
            nuevo.anterior=aux
        return nuevo

##Insertar Cabecera Fila
    def crear_fila(self,y):
        nodo_fila=self.root
        nuevo=NodoMatriz(-1,y,"Fila")
        columna=self.insertar_orden_fil(nuevo,nodo_fila)
        return columna

##Insertar en orden Filas
    def insertar_orden_fil(self,nuevo,cabeza_fila):
        aux = cabeza_fila
        insertado=False
        while True:
            if(nuevo.y==aux.y):
                # si la posicion ya existe sobre escribimos
                aux.x=nuevo.x
                aux.dato=nuevo.dato
                return aux
            elif(aux.y>nuevo.y):
                #insertar en medio, antes del aux
                insertado=True
                break
            if aux.abajo is not None:
                aux=aux.abajo
            else:
                #insertar despues del auxiliar
                insertado=False
                break
        if insertado:
            nuevo.abajo=aux
            aux.arriba.abajo=nuevo
            nuevo.arriba=aux.arriba
            aux.arriba=nuevo
        else:
            aux.abajo=nuevo
            nuevo.arriba=aux
        return nuevo

    
##Metodo para insertar   
    def insertarNodo(self,x,y,dato):
        nuevo=NodoMatriz(x,y,dato)
        NodoColumna = self.buscar_columna(x)
        NodoFila =self.buscar_fila(y)
        ##Caso 1---No existe fila ni columna
        if NodoFila is None and NodoColumna is None:
            print("Caso1, ---No existe fila ni columna")
            ##crear las cabeceras
            NodoColumna=self.crear_columna(x)
            NodoFila=self.crear_fila(y)
            #insertamos contenido
            nuevo=self.insertar_orden_col(nuevo,NodoFila)
            nuevo=self.insertar_orden_fil(nuevo,NodoColumna)
            return
        ##Caso 2---No existe Fila, pero si columna
        elif NodoFila is None and NodoColumna is not None:
            print("Caso2")
            ##crear las cabeceras
            ##NodoColumna=self.crear_columna(x)
            NodoFila=self.crear_fila(y)
            #insertamos contenido
            nuevo=self.insertar_orden_col(nuevo,NodoFila)
            nuevo=self.insertar_orden_fil(nuevo,NodoColumna)
            return
        ##Caso 3---No existe columna, pero si fila
        elif NodoFila is not None and NodoColumna is None:
            print("Caso3")
            ##crear las cabeceras
            NodoColumna=self.crear_columna(x)
            ##NodoFila=self.crear_fila(y)
            #insertamos contenido
            nuevo=self.insertar_orden_col(nuevo,NodoFila)
            nuevo=self.insertar_orden_fil(nuevo,NodoColumna)
            return
        ##caso en el que si existe fila y columna
        elif NodoFila is not None and NodoColumna is not None:
            print("Caso4")
            ##crear las cabeceras
            ##NodoColumna=self.crear_columna(x)
            ##NodoFila=self.crear_fila(y)
            #insertamos contenido
            nuevo=self.insertar_orden_col(nuevo,NodoFila)
            nuevo=self.insertar_orden_fil(nuevo,NodoColumna)
            return


##Imprimir
    def imprimir(self):
        aux=self.root
        while aux is not None:
            tex=""
            aux2=aux
            while aux2 is not None:
                tex+="["+str(aux2.x)+str(aux2.y)+"]"
                aux2=aux2.siguiente
            print(tex)
            aux=aux.abajo
        return None

