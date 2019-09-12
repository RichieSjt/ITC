public class ListaLigada<T> {
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

    public void introducirDatoEnElIndice(T elemento, int index){
        if(index >= contarElementos()){
            System.out.println("Index out of bounds");
        }
        encontrarNodoEnIndice(index-1).setElemento(elemento);
    }
    //Porque el codigo del profe para este metodo difiere tanto;
}