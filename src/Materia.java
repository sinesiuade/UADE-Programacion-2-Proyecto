
public class Materia 
{
    private Comision[] comisiones = new Comision[3]; 
    private String nombre;
    
    public void Materia(Comision[] comisiones, String nombre)
    {
        this.comisiones = comisiones;
        this.nombre = nombre;
    }
    public void Materia(String nombre)
    {
        this.nombre = nombre;
    }

    public Comision[] getComision()
    {
        return comisiones;
    }
    public String getNombre()
    {
        return nombre;
    }
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
}
