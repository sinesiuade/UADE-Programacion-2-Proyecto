public class Pedido 
{
    private Estudiante estudiante;
    private Materia materia;

    public void setEstudiante(Estudiante estudiante)
    {
        this.estudiante = estudiante;
    }
    public Estudiante getEstudiante()
    {
        return estudiante;
    }
    public void setMateria(Materia materia)
    {
        this.materia = materia;
    }
    public Materia getMateria()
    {
        return materia;
    }
    public void mostrarPedido()
    {
        System.out.println("Estudiante: " + estudiante.getNombre() + " - Materia: " + materia.getNombre());
    }
    
}
