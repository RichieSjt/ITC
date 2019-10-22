public class Alumno {
    private String nombre;
	private String apellido;
    private String matricula;

    public Alumno(String nombre, String apellido, String matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public String toString() {
		return "Alumno [nombre: " + nombre + ", apellido: " + apellido + ", matricula: " + matricula + "]";
    }

    public int hashCode() {
		int matriculaEntera = Integer.parseInt(matricula.substring(1, matricula.length()));
		return matriculaEntera;
	}
	
	public boolean equals(Object o) {
		Alumno a = (Alumno)o;
		return a.getMatricula().equals(matricula);
	}
}