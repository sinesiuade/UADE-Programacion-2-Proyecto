package modelos;

public class Estudiante {
    private Materia[] materias = new Materia[10];
    private Materia[] materiasAIngresar = new Materia[10];
    private String nombre = "";
    private String mail = "";
    private int prioridad;

    public void agregarMateria(Materia materia) {

    }

    public void Alumno(String nombre, String mail, int prioridad) {
        this.nombre = nombre;
        this.mail = mail;
        this.prioridad = prioridad;
    }

    public Materia[] getMaterias() {
        return materias;
    }

    public void setMaterias(Materia[] materias) {
        this.materias = materias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
}
