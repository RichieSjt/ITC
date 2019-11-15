public class Main {
    public static void main(String []args){
        Arbol<Integer> arbol = new Arbol<>();
        arbol.insertarNodo(12);
        arbol.insertarNodo(15);
        arbol.insertarNodo(13);
        arbol.insertarNodo(3);
        arbol.insertarNodo(1);
        arbol.insertarNodo(5);
        arbol.insertarNodo(2);
        arbol.recorreEnOrden();
    }
}