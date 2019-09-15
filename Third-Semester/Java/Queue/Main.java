public class Main{
    public static void main(String[] args) {
        Cola<Integer> cola = new Cola<>();
        cola.enqueue(67);
        cola.enqueue(23);
        cola.enqueue(81);
        cola.enqueue(59);
        cola.imprimirCola();
        System.out.println("Size de la cola: " + cola.size());
        
        cola.dequeue();
        cola.imprimirCola();
        System.out.println("Size de la cola: " + cola.size());

    }
}