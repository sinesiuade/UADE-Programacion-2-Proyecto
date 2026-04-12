public class Estudiante {
    private int dni=0;
    private Materia[] materias = new Materia[10];
    private String nombre = "";
    private String mail = "";


    public void agregarMateria(Materia materia) {

    }

    public void Alumno(String nombre, String mail, int dni) {
        this.nombre = nombre;
        this.mail = mail;
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
    public int getDni() {
        return dni;
    }
    public void setDni(int dni) {
        this.dni = dni;
    }
}
