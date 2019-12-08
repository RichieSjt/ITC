public class Main{
    public static void main(String[] args) {
        Grafo<String> grafo = new Grafo<>();
        grafo.agregarVertice("Hola");
        grafo.agregarVertice("Bro");
        grafo.agregarVertice("Aaaa");
        grafo.agregarVertice("Fuck");

        grafo.agregarArista("Hola", "Bro");
		grafo.agregarArista("Hola", "Aaaa");
		grafo.agregarArista("Aaaa", "Fuck");
        grafo.agregarArista("Fuck", "Bro");
        
		grafo.recorreEnAnchura();
		grafo.recorreEnProfundidad();
    }
}