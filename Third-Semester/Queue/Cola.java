public class Cola<T>{
    private Nodo<T> inicial;

    public Nodo<T> getInicial() {
        return inicial;
    }

    public void setInicial(Nodo<T> inicial) {
        this.inicial = inicial;
    }

    public boolean estaVacia(){
        return inicial == null;
    }

    public void enqueue(T elemento){
        if(estaVacia()){
            Nodo<T> aInsertar = new Nodo<>(elemento);
            aInsertar.setSiguiente(inicial);
            inicial = aInsertar;
        }else{
            Nodo<T> temp = inicial;
            while(temp.getSiguiente()!=null){
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(new Nodo<T>(elemento));
        }
    }
    
    public void dequeue(){
        if(estaVacia())
            System.out.println("No hay elementos que sacar de la queue");
        else
            inicial = inicial.getSiguiente();
    }

    public int size(){
        int contador = 0; 
        if(estaVacia())
            return contador;
        else{
            Nodo<T> temp = inicial;
            while(temp!=null){
                temp = temp.getSiguiente();
                contador++;
            }
            return contador;
        }
    }

    public void imprimirCola(){
        Nodo<T> temp = inicial;
        while(temp!=null){
            System.out.println("Nodo: " + temp.getElemento());
            temp = temp.getSiguiente();
        }
    }

    
}