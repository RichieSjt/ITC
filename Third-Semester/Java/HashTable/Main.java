public class Main {
    public static void main(String[] args) {
        HashTable<Alumno,Double> tabla = new HashTable<Alumno,Double>();

        Alumno a = new Alumno("Ricardo","Juarez","A01650943");
        Alumno a2 = new Alumno("Stones","R","A01783291");
		tabla.insertar(a, 100.0);
        tabla.insertar(a2, 80.0);
		tabla.imprimir();
		System.out.println(tabla.encontrar(a2));

    }
}