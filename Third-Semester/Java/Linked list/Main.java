public class Main {
    public static void main(String[] args) {
        ListaLigada<Integer> lista = new ListaLigada<>();
        lista.estaVacia();
        lista.insertarAlInicio(2);
        lista.insertarAlInicio(8);
        lista.insertarAlInicio(7);
        lista.insertarAlUltimo(43);
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

        lista.introducirDatoEnElIndice(19, 2);
        lista.imprimeLista();

        System.out.println(lista.linearSearch(43));
    }
}