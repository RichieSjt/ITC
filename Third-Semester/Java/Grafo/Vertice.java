import java.util.ArrayList;
import java.util.List;

public class Vertice<T extends Comparable<T>> implements Comparable<Vertice<T>> {
    private T elemento;
    private List<Arista<T>> aristas;
    private boolean visitado;

    public Vertice(T elemento) {
        this.elemento = elemento;
        aristas = new ArrayList<>();
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public void agregarArista(Arista<T> arista){
        aristas.add(arista);
    }

    public List<Arista<T>> getAristas() {
        return aristas;
    }

    public void setAristas(List<Arista<T>> aristas) {
        this.aristas = aristas;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public int compareTo(Vertice<T> o) {
		// TODO Auto-generated method stub
		return 0;
	}
}