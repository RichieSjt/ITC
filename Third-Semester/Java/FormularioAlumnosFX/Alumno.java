public class Alumno{
    private String nombre;
    private String matricula;
    private String calificacion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws EmptyFieldException {
        if (nombre == null || nombre.length() == 0)
            throw new EmptyFieldException ("Porfavor indica el nombre del alumno");
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) throws EmptyFieldException {
        if (matricula == null || matricula.length() == 0)
            throw new EmptyFieldException ("Porfavor indica la matricula del alumno");
        this.matricula = matricula;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) throws EmptyFieldException {
        if (calificacion == null || calificacion.length() == 0)
            throw new EmptyFieldException ("Porfavor indica la calificacion del alumno");
        this.calificacion = calificacion;
    }

    public String toString(){
        String alumno = getNombre() + " " + getMatricula() + " " + getCalificacion();
        return alumno;
    }
    
}