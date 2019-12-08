import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Grafo<T extends Comparable<T>>{
    private List<Vertice<T>> verticesArray;
    private Queue<Vertice<T>> verticesQueue;
    private Stack<Vertice<T>> verticesStack;

    public Grafo() {
        verticesArray = new ArrayList<>();
        verticesQueue = new LinkedList<>();
        verticesStack = new Stack<>();
    }

    public void agregarVertice(T elemento) {
        boolean repeats = false;
        for(Vertice<T> vertice : verticesArray){
            if(vertice.getElemento().compareTo(elemento) == 0)
                repeats = true;
        }
        if(!repeats)
            verticesArray.add(new Vertice<>(elemento));
    }

    public void agregarArista(T elemento1, T elemento2) throws VerticesNotFoundException {
        //Temporal vertices to store the corresponding when found
        Vertice<T> temp1 = null;
        Vertice<T> temp2 = null;

        for(Vertice<T> vertice : verticesArray){
            if(vertice.getElemento().compareTo(elemento1) == 0)
                temp1 = vertice;
        }
        for(Vertice<T> vertice : verticesArray){
            if(vertice.getElemento().compareTo(elemento2) == 0)
                temp2 = vertice;
        }

        if(temp1!= null && temp2 != null ){
            Arista<T> arista = new Arista<>(temp1, temp2);
            temp1.agregarArista(arista);
            temp2.agregarArista(arista);
        }else{
            throw new VerticesNotFoundException();
        }
    }

    public void recorreEnAnchura() {
        if(verticesArray.get(0) == null)
            System.out.println("No vertices found");
        else{
            verticesQueue.add(verticesArray.get(0));

			while(!verticesQueue.isEmpty()) {
                //poll returns the head of the queue and removes it
                Vertice<T> aExplorar = verticesQueue.poll();
                
				if(!aExplorar.isVisitado())
					System.out.print(aExplorar.getElemento().toString()+" ,");
                aExplorar.setVisitado(true);
                
                List<Arista<T>> aristasAVisitar = aExplorar.getAristas();
                
				for(Arista<T> arista:aristasAVisitar) {
					if(!arista.getVertice1().isVisitado())
                        verticesQueue.add(arista.getVertice1());
                        
					if(!arista.getVertice2().isVisitado())
						verticesQueue.add(arista.getVertice2());
                }
			}
        }
        System.out.println("");
		reiniciarVisitas();
    }   

    public void recorreEnProfundidad() {
        if(verticesArray.get(0) == null)
            System.out.println("No vertices found");
        else{
            verticesStack.add(verticesArray.get(0));
            while(!verticesStack.isEmpty()) {
                Vertice<T> aExplorar = verticesStack.pop();
                
				if(!aExplorar.isVisitado())
					System.out.print(aExplorar.getElemento().toString()+" ,");
                aExplorar.setVisitado(true);
                
                List<Arista<T>> aristasAVisitar = aExplorar.getAristas();
                
				for(Arista<T> arista:aristasAVisitar) {
					if(!arista.getVertice1().isVisitado())
                        verticesStack.push(arista.getVertice1());
                        
					if(!arista.getVertice2().isVisitado())
                        verticesStack.push(arista.getVertice2());
                }
			}
        }
        System.out.println("");
		reiniciarVisitas();
    }

    public void reiniciarVisitas() {
		for (Vertice<T> vertice : verticesArray) 
			vertice.setVisitado(false);
    }
}