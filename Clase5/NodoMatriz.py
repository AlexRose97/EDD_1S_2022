class NodoMatriz():

    def __init__(self,x,y,dato):
        #punteros
        self.siguiente=None
        self.anterior=None
        self.abajo=None
        self.arriba=None
        #informacion del nodo
        self.dato=dato
        self.x=x
        self.y=y

    def nodo_str(self):
        return "("+str(self.x)+","+str(self.y)+")="+str(self.dato)

