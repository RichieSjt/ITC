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

    public int linearSearch(T elemento) {
        Nodo<T> temp = inicial;
        int counter = 0;
        
        while(temp!=null){
            if(temp.getElemento().compareTo(elemento)==0){
                return counter;
            }
            temp = temp.getSiguiente();
            counter++;
        }
        return -1;
    }
    public int binarySearch(T elemento){
        int start = 0;
        int end = contarElementos()-1;
        int mid;
        while(start <= end){
            mid = (start + end)/2;
            if(encontrarNodoEnIndice(mid).getElemento().compareTo(elemento) == 0)
                 return mid;
            if(encontrarNodoEnIndice(mid).getElemento().compareTo(elemento) > 0)
                end = mid - 1;
            else
                start = mid + 1; 
        }
        return -1;
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
            //Que le pasa al inicial?????
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

    public void quitarPrimero(){
        if(estaVacia())
            System.out.println("No puedes quitar elementos");
        else
        inicial = inicial.getSiguiente();
        //La referencia posterior al inicial desaparece despues de asignarla a inicial???
    }

    public void quitarUltimo(){
        if(estaVacia())
            System.out.println("No puedes quitar elementos");
        else if(contarElementos()==1){
            inicial = null;
        }else{
            Nodo<T> temp = inicial;
            while(temp.getSiguiente().getSiguiente()!=null){
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(null);
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

    public void encontrarElementoEnIndice(int index){
        int contador = 0;
        Nodo<T> temp = inicial;
        if(index >= contarElementos())
            System.out.println("Index out of bounds");
        else{
            while(contador!=index){
                temp = temp.getSiguiente();
                contador++;
            }
            System.out.println("Elemento en el indice " + contador + ": " + temp.getElemento());
        }
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

    public void insertarEnElIndice(int index, T elemento) {
		if(estaVacia())
			insertarAlInicio(elemento);
		else {
			if(index>=contarElementos()) {
				System.out.println("No puedes insertar en ese indice");
				return;
			}
			if(index==contarElementos()-1) {
				insertarAlUltimo(elemento);
				return;
			}
			if(index==0) {
				insertarAlInicio(elemento);
				return;
			}
			Nodo<T> anterior=encontrarNodoEnIndice(index-1);
			Nodo<T> aInsertar= new Nodo<>(elemento);
			aInsertar.setSiguiente(anterior.getSiguiente());
			anterior.setSiguiente(aInsertar);
			
		}
	}
}