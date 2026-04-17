package modelos;

public class Materia {
    private int id;
    private String nombre;
    private int cupo;

    public Materia(String nombre, int cupo) {
        this.nombre = nombre;
        this.cupo = cupo;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }
}