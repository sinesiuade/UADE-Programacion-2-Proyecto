package modelos;

public class Materia {
    private int id;
    private String nombre;
    private int cupo;
    private int cupo_disponible;

    public Materia(int id, String nombre, int cupo) {
        this.id = id;
        this.nombre = nombre;
        this.cupo = cupo;
        this.cupo_disponible = cupo;
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

    public boolean tieneCupoDisponible() {
        return this.cupo_disponible != 0;
    }

    public void restarCupoDisponible() {
        if (this.cupo_disponible != 0) {
            this.cupo_disponible--;
        }
    }

    public void sumarCupoDisponible() {
        if (this.cupo_disponible != this.cupo) {
            this.cupo_disponible++;
        }
    }

    public String to_String() {
        return "ID: " + id + " | Nombre: " + nombre + " | Cupo: " + cupo + " | Cupo Disp.: " + cupo_disponible;
    }
}