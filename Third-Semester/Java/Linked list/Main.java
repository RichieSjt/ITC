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

        lista.encontrarElementoEnIndice(2);
        lista.encontrarElementoEnIndice(3);

        lista.insertarAlUltimo(51);
        lista.insertarAlUltimo(56);
        lista.insertarAlUltimo(78);
        lista.insertarAlUltimo(82);
        lista.insertarAlUltimo(95);
        lista.insertarAlUltimo(100);

        lista.imprimeLista();
        System.out.println("Indice del elemento 42 (Busqueda lineal): " + lista.linearSearch(42));
        System.out.println("Indice del elemento 51 (Busqueda binaria): " + lista.binarySearch(51));

    }
}