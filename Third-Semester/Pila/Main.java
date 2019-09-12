public class Main {
    public static void main(String[] args) {
        Pila<Integer> pila = new Pila<>();
        pila.push(8);
        pila.push(3);
        pila.push(7);
        pila.push(23);
        pila.imprimirPila();
        System.out.println("Numero de elementos: " + pila.contarElementos());

        pila.pop();
        pila.imprimirPila();
        System.out.println("Numero de elementos: " + pila.contarElementos());

        pila.peek();

    }
}