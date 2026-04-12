public class NodoDiccionario 
{
    private int clave=0;
    private Estudiante estudiante;
    private Estudiante siguiente=null;

    public void NodoDiccionario(Estudiante estudiante)
    {
        clave = estudiante.getDni();
        this.estudiante = estudiante;
    }

    public int getClave()
    {
        return clave;
    }

    public Estudiante getEstudiante()
    {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante)
    {
        this.estudiante = estudiante;
    }

    public void agregar(Estudiante siguiente)
    {
        this.siguiente=siguiente;
    }

    public Estudiante getSiguiente()
    {
        return siguiente;
    }

    
}
