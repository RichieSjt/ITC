public class ListaLigada<T extends Comparable<T>>{
    private Nodo<T> inicial;

    public Nodo<T> getInicial(){
        return inicial;
    }

    public void setInicial(Nodo<T> inicial){
        this.inicial = inicial;
    }

    public boolean estaVacia(){
        return inicial == null;
    }

    public void swap(int actual, int siguiente) {
        //Obtenemos los elementos a cambiar
        T elemento1 = encontrarElementoEnIndice(actual);
        T elemento2 = encontrarElementoEnIndice(siguiente);
        
        //Sobreescribimos los elementos en los nodos
		encontrarNodoEnIndice(actual).setElemento(elemento2);
		encontrarNodoEnIndice(siguiente).setElemento(elemento1);
		
    }
/*    
    public void mergeSort(){
        mergeSort(inicial);
    }

    private Nodo<T> mergeSort(Nodo<T> inicio) {
        Nodo<T> inicioAnterior = inicio;
        int mid = (contarElementos()-1)/2;
        
        if(inicio.getSiguiente() == null)
            return inicio;
        
        while((mid - 1) > 0){
            inicioAnterior = inicioAnterior.getSiguiente();
            mid--;
        }
        Nodo<T> nuevoInicio = inicioAnterior.getSiguiente();
        inicioAnterior.setSiguiente(null);
        inicioAnterior = inicio;
        Nodo<T> temp1 = mergeSort(inicioAnterior);
        Nodo<T> temp2 = mergeSort(nuevoInicio);
        return merge(temp1, temp2);
    }

    private Nodo<T> merge(Nodo<T> a, Nodo<T> b){
        Nodo<T> resultado = null;
        if(a == null)
            return b;
        if(b == null)
            return a;
        if(a.getElemento().compareTo(b.getElemento()) > 0){
            resultado = b;
            resultado.setSiguiente(merge(a, b.getSiguiente()));
        }else{
            resultado = a;
            resultado.setSiguiente(merge(a.getSiguiente(), b));
        }
        return resultado;
    }
    */
    public void mergeSort(){
        mergeSortInn(inicial);
    }
    private Nodo<T> mergeSortInn(Nodo<T> inicial){
        Nodo<T> initialAnt = inicial;
        int mid = contarElementos(inicial)/2;
        if(inicial.getSiguiente() == null){
            return inicial;
        }
        while((mid-1)>0){
            initialAnt = initialAnt.getSiguiente();
            mid--;
        }
        Nodo<T> initialNew = initialAnt.getSiguiente();
        initialAnt.setSiguiente(null);
        initialAnt = inicial;
        Nodo<T> temp1 = mergeSortInn(initialAnt);
        Nodo<T> temp2 = mergeSortInn(initialNew);
        return merge(temp1, temp2);
    }
    private Nodo<T> merge(Nodo<T> first, Nodo<T> second){
        Nodo<T> result = null;
        if(first == null){
            return second;
        }
        if(second == null){
            return first;
        }
        if(first.getElemento().compareTo(second.getElemento())>0){
            result = second;
            result.setSiguiente( merge(first, second.getSiguiente()));
        }else {
            result = first;
            result.setSiguiente(merge(first.getSiguiente(),second));
        }
        return result;
    }
    public int contarElementos(Nodo<T> nodo) {
		if(nodo==null)
			return 0;
		else {
			Nodo<T> temp = nodo;
			int contador=0;
			while(temp!=null) {
				contador++;
				temp=temp.getSiguiente();
			}
			return contador;
		}
	}

    //Método que el usuario llama para no enviar los parámetros left y right
    public void quickSort(){
        quickSort(0,contarElementos()-1);
    }
    //Método privado que ejecuta quicksort
    private void quickSort(int left, int right){
        T pivot = encontrarElementoEnIndice((right+left)/2);
        int i = left;
        int j = right;
        while (i<=j){
            while (encontrarElementoEnIndice(i).compareTo(pivot)<0){
                i++;
            }
            while (encontrarElementoEnIndice(j).compareTo(pivot)>0){
                j--;
            }
            if (i<=j){
                if (i!=j){
                    swap(i,j);
                }
                i++;
                j--;
            }
        }
        if(left<j){
            quickSort(left,j);
        }
        if(i<right){
            quickSort(i,right);
        }
    }
    
    public void insertarAlInicio(T elemento){
        Nodo<T> aInsertar = new Nodo<>(elemento);
        aInsertar.setSiguiente(inicial);
        inicial = aInsertar;
    }

    public void insertarAlUltimo(T elemento){
        Nodo<T> temp = inicial;
        if(estaVacia())
            insertarAlInicio(elemento);
        else{
            while(temp.getSiguiente()!=null){
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(new Nodo<T>(elemento));
        }
    }

    public int contarElementos(){
        int contador = 0;
        if(estaVacia())
            return contador;
        else{
            Nodo<T> temp = inicial;
            while(temp!=null){
                temp = temp.getSiguiente();
                contador++;
            }
        }
        return contador;
    }

    public void imprimeLista(){
        if(estaVacia())
            System.out.println("La lista esta vacia");
        else{
            Nodo<T> temp = inicial;
            while(temp!=null){
                System.out.println("Nodo: " + temp.getElemento().toString());
                temp = temp.getSiguiente();
            }
        }
    }

    public void obtenerElUltimo(){
        Nodo<T> temp = inicial;
        while(temp.getSiguiente()!=null){
            temp = temp.getSiguiente();
        }
        System.out.println("Ultimo elemento de la lista: " + temp.getElemento().toString());
    }

    public void obtenerElPrimero(){
        System.out.println("Primer elemento de la lista: " + inicial.getElemento().toString());
    }

    public T encontrarElementoEnIndice(int index){
        return encontrarNodoEnIndice(index).getElemento();

    }

    public Nodo<T> encontrarNodoEnIndice(int index){
        int contador = 0;
        Nodo<T> temp = inicial;
        if(index >= contarElementos()){
            System.out.println("Index out of bounds");
            return null; 
        }
        else{
            while(contador!=index){
                temp = temp.getSiguiente();
                contador++;
            }
            return temp; 
        }
    }
}