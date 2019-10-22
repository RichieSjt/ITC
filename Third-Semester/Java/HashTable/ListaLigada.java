public class ListaLigada<T>{
    private Nodo<T> inicial;

    public Nodo<T> getInicial(){
        return inicial;
    }

    public void setInicial(Nodo<T> inicial){
        this.inicial = inicial;
    }

    /*
    public void quickSort(){
        quickSort(0,contarElementos()-1);
    }
    //Método privado que ejecuta quicksort
    private void quickSort(int left, int right){
        if(contarElementos() == 0 || contarElementos() == 1)
            return;

        Entrada<Alumno, Double> e = (Entrada)encontrarElementoEnIndice((right+left)/2);
        double pivot = e.getValor();
        
        int i = left;
        int j = right;

        Entrada<Alumno, Double> eCompare;
        double toCompare = -1;

        while (i<=j){
            
            while (toCompare < pivot){
                eCompare = (Entrada)encontrarElementoEnIndice(i);
                toCompare = eCompare.getValor();
                i++;
            }
            toCompare = -1;
            while (toCompare > pivot){
                eCompare = (Entrada)encontrarElementoEnIndice(j);
                toCompare = eCompare.getValor();
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

    public void swap(int actual, int siguiente) {
        //Obtenemos los elementos a cambiar
        Entrada<Alumno, Double> elemento1  = (Entrada)encontrarElementoEnIndice(actual);
        Entrada<Alumno, Double> elemento2  = (Entrada)encontrarElementoEnIndice(siguiente);
        
        //Sobreescribimos los elementos en los nodos
        encontrarNodoEnIndice(actual).getElemento().setLlave(elemento2.getLlave());
        encontrarNodoEnIndice(actual).getElemento().setValor(elemento2.getValor());
        
        encontrarNodoEnIndice(siguiente).getElemento().setLlave(elemento1.getLlave());
        encontrarNodoEnIndice(siguiente).getElemento().setValor(elemento1.getValor());
        
		
    }*/

    public boolean estaVacia(){
        return inicial == null;
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
    
    public String toString() {
		String resultado="";
		if(estaVacia()) {
			System.out.println("Lista vacia");
		}else {
			Nodo<T> temp = inicial;
			while (temp!=null) {
				resultado += "[Nodo: "+ temp.getElemento().toString() + "]";
				temp=temp.getSiguiente();
			}
		}
		return resultado;
	}
	
}