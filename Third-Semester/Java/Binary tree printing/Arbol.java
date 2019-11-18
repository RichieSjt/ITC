public class Arbol<T extends Comparable<T>> {
    private Nodo<T> raiz;
    private int contadorAltura;
    private int contadorNivel;
    private int alturaMaxima;
    private String[] niveles;

    public Arbol() {
        contadorAltura = 0;
        contadorNivel = 0;
    }

    public Nodo<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo<T> raiz) {
        this.raiz = raiz;
    }
    //aqui insertamos el los nodos en la raiz o sus sub arboles en caso que ya exista una raiz
    public void insertarNodo(T elemento) {
        contadorAltura = 0;
        Nodo<T> newNodo = new Nodo<>(elemento);
        if (raiz == null) {
            raiz = newNodo;
        } else {
            insertarNodoRec(raiz, newNodo, contadorAltura);
        }
    }

    private Nodo<T> insertarNodoRec(Nodo<T> parent, Nodo<T> newNodo, int contadorAltura) {
        //aqui es el caso base y tambien determinamos la altura maxima del arbol entero
        if (parent == null) {
            newNodo.setAltura(contadorAltura);
            if (contadorAltura > alturaMaxima)
                alturaMaxima = contadorAltura;
            parent = newNodo;
            return parent;
            // aqui insertamos a la izquierda o a la derecha dependiendo si es mayor o menor y tambien sumamos el contador de la altura
        } else if (newNodo.getElemento().compareTo(parent.getElemento()) > 0) {
            contadorAltura++;
            parent.setDerecho(insertarNodoRec(parent.getDerecho(), newNodo, contadorAltura));
        } else if (newNodo.getElemento().compareTo(parent.getElemento()) < 0) {
            contadorAltura++;
            parent.setIzquierdo(insertarNodoRec(parent.getIzquierdo(), newNodo, contadorAltura));
        }
        return parent;
    }

    public void imprimirPorNiveles(){
        int nivelMaximo = alturaMaxima;
        double totalEspacios = ((alturaMaxima  * 2) *2) + 1;
        for(int i = 0; i <= nivelMaximo; i++ ){
            //imprimir espacios previos
            double numberOfNodes =  (int)Math.pow(2,i);
            double temp = Math.ceil((totalEspacios - numberOfNodes) / (numberOfNodes+1)) ;
            int espaciosNivel = (int)temp;
            espaciosRepetidos(espaciosNivel+1);
            imprimirNivel(raiz, i, 0 ,espaciosNivel);
            System.out.println();
            //imprimir lineas
            if(i != nivelMaximo){ // para no imprimir la ultima linea
                espaciosRepetidos(espaciosNivel);
                if( i == 0){ // para cuando i = 0
                    System.out.print("/ " + Character.toString((char)92));
                    System.out.println();
                }
                else{
                    for(int k = 0;  k < i * 2; k++){
                        System.out.print("/ " + Character.toString((char)92)) ;
                        espaciosRepetidos(espaciosNivel);
                    }
                    System.out.println();
                }
            }
        }

    }
    private void imprimirNivel(Nodo<T> nodoActual, int nivelObjetivo, int contadorNivel, int espaciosNivel){
        if(nodoActual != null){
            if(nivelObjetivo == contadorNivel){
                //estamos en el nivel, y hay numero
                System.out.print(nodoActual.getElemento().toString()  );
                espaciosRepetidos(espaciosNivel+1);
            }
            else{
                //seguir buscando
                imprimirNivel(nodoActual.getIzquierdo(), nivelObjetivo, contadorNivel + 1 , espaciosNivel);
                imprimirNivel(nodoActual.getDerecho(), nivelObjetivo, contadorNivel + 1, espaciosNivel);
            }
        }
        else {
            //estamos en el nivel pero no hay numero
            System.out.print(" ");
            espaciosRepetidos(espaciosNivel+1);
        }
    }
    //metodo para imprimir los espacios
    private void espaciosRepetidos(int espaciosNivel){
        for(int j = 0; j <  espaciosNivel -1   ; j++){
            System.out.print(" ");
        }
    }
}