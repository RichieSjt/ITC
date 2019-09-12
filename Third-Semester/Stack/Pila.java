public class Pila<T> {
    private Nodo<T> inicial;

    public Nodo<T> getInicial() {
        return inicial;
    }

    public void setInicial(Nodo<T> inicial) {
        this.inicial = inicial;
    }

    public boolean estaVacia(){
        return inicial==null;
    }

    public void push(T elemento){
        Nodo<T> aInsertar = new Nodo<>(elemento);
        if(estaVacia()){
            aInsertar.setSiguiente(inicial);
            inicial = aInsertar;
        }else{
            Nodo<T> temp = inicial;
            while(temp.getSiguiente()!=null){
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(aInsertar); ;
        }
    }
    public void pop(){
        Nodo<T> temp = inicial;
        if(estaVacia()){
            System.out.println("No hay elementos que quitar");
        }else if (contarElementos()==1){
            inicial = inicial.getSiguiente();
        }else{
            while(temp.getSiguiente().getSiguiente()!=null){
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(null);
        }
    }

    public void peek(){
        if(estaVacia())
            System.out.println("No hay elementos");
        else if (contarElementos()==1){
            System.out.println("Peek " + inicial.getElemento());
        }else{
            Nodo<T> temp = inicial;
            while(temp.getSiguiente()!=null){
                temp = temp.getSiguiente();
            }
            System.out.println("Peek: " + temp.getElemento());
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

    public void imprimirPila(){
        Nodo<T> temp = inicial;
        while(temp!=null){
            System.out.println("Nodo: " + temp.getElemento().toString());
            temp = temp.getSiguiente();   
        }
    }

    
}