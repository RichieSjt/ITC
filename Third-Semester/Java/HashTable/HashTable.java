public class HashTable <K, V> {
    @SuppressWarnings("unchecked")

    private ListaLigada<Entrada<K, V>>[] tabla;

    public HashTable(){
        tabla = new ListaLigada[100];
    }

    public void insertar(K key, V value){
        //A position in the table given by the haschode of the object
        int position = posHash(key);

        if(tabla[position] == null){
            tabla[position] = new ListaLigada<>();
        }
		tabla[position].insertarAlUltimo(new Entrada(key, value));
		//tabla[position].quickSort();
    }

    public void imprimir() {
		
		for (int i=0;i<tabla.length;i++) {
			if(tabla[i]==null) {
				System.out.println(i+".- Vacia");
			}else {
				System.out.println(i+".- "+tabla[i].toString());
			}
		}
		
    }
    
    public int encontrar(K key) {
		int position = posHash(key);
		//tabla[pos]
		/*
		int pos=position;
		if(tabla[pos].getLlave().equals(key)) {
			return pos;
		}
		int i=position;
		while(tabla[i]!=null) {
			i++;
			if(tabla[i].getLlave().equals(key)) {
				break;
			}
		}
		return i;
		*/
		
		//TODO
		return 0;
	}

    private int posHash(K key) {
        //Obtaining the module of the hashcode returns a value between 0 and the number
        //of available spaces in the table, in this case the hash of the object student is its "Matricula".
        int position = Math.abs(key.hashCode())%tabla.length;
		return position;
	}
}