public class Arbol<T extends Comparable<T>> {
	private Nodo<T> raiz;
	private int heightCounter;
	private int levelCounter;
	private int alturaMaxima;
	private String[] levels;

	public Nodo<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo<T> raiz) {
        this.raiz = raiz;
    }
	
	public void insertarNodo(T elemento){
		heightCounter = 0;
		Nodo<T> newNodo = new Nodo<>(elemento);
		if(raiz == null){
			raiz = newNodo;
		} else {
			insertarNodoRec(raiz, newNodo, heightCounter);
		}
	}
	
	private Nodo<T> insertarNodoRec(Nodo<T> parent, Nodo<T> newNodo, int heightCounter){
		if(parent==null){
			newNodo.setAltura(heightCounter);
			if(heightCounter > alturaMaxima)
				alturaMaxima = heightCounter;
			parent = newNodo;
			return parent;
		}
		else if(newNodo.getElemento().compareTo(parent.getElemento()) > 0){
			heightCounter++;
			parent.setDerecho(insertarNodoRec(parent.getDerecho(), newNodo, heightCounter));
		}
		else if(newNodo.getElemento().compareTo(parent.getElemento()) < 0){
			heightCounter++;
			parent.setIzquierdo(insertarNodoRec(parent.getIzquierdo(), newNodo, heightCounter));
		}
		return parent;
	}
	public void recorreEnOrden() {
		arraySize();
		recorreEnOrdenRec(raiz, null);
		System.out.println("\nArray:");
		printArray();
	}
	
	private void recorreEnOrdenRec(Nodo<T> nodo, Nodo<T> parent) {
		if(nodo!=null){
			recorreEnOrdenRec(nodo.getIzquierdo(), nodo);
			fillArray("L" + nodo.getAltura() + " " + nodo.toString());
			System.out.print(nodo.getElemento().toString() + " ");
			recorreEnOrdenRec(nodo.getDerecho(), nodo);
		}else{
			fillArray(("L" + (parent.getAltura()+1)) + " N");
		}
	}

	private void fillArray(String nodeAtLevel){
		levels[levelCounter] = nodeAtLevel;
		levelCounter++;
	}

	public void printArray(){
		for(String x : levels){
			System.out.println(x);
		}
	}

	private void arraySize(){
		int totalNodos = 0;
		for(int i = 0; i < alturaMaxima+1; i++){
			totalNodos += Math.pow(2, i);
		}
		levels = new String[totalNodos];
	}

	public void imprimir(){
		Nodo<T> temp;
		int espacio = alturaMaxima - 1; 
		for(int i = 0; i <= espacio; i++){
			System.out.print(" ");
		}
		System.out.print(raiz.toString());

		//Contar los elementos en el ultimo nivel

	}			
	
}