public class Main {
    public static void main(String[] args) {
        ListaLigada<Integer> lista = new ListaLigada<>();
        lista.estaVacia();
        lista.insertarAlInicio(27);
        lista.insertarAlInicio(8);
        lista.insertarAlInicio(7);
        lista.insertarAlUltimo(42);
        lista.insertarAlUltimo(69);
        lista.imprimeLista();
        System.out.println("Numero de elementos: " + lista.contarElementos());

        lista.quitarPrimero();
        lista.imprimeLista();
        System.out.println("Numero de elementos: " + lista.contarElementos());

        lista.quitarUltimo();
        lista.imprimeLista();
        System.out.println("Numero de elementos: " + lista.contarElementos());

        lista.obtenerElUltimo();
        lista.obtenerElPrimero();

        System.out.println("Elemento en el indice 1: " + lista.encontrarElementoEnIndice(1)); 
        System.out.println("Elemento en el indice 2: " + lista.encontrarElementoEnIndice(2)); 

        lista.insertarAlUltimo(25);
        lista.insertarAlUltimo(1);
        lista.insertarAlUltimo(34);
        lista.insertarAlUltimo(51);
        //lista.insertarAlUltimo(9);
        //MergeSort solamente funciona con 6 elementos, porqué????

        System.out.println("\nLista antes del sort: ");
        lista.imprimeLista();

        //lista.bubbleSort();
        //lista.mergeSort();
        lista.quickSort();
         
        System.out.println("\nLista despues del sort: ");

        lista.imprimeLista();
        System.out.println("Indice del elemento 42 (Busqueda lineal): " + lista.linearSearch(42));
        System.out.println("Indice del elemento 51 (Busqueda binaria): " + lista.binarySearch(51));

    }
}