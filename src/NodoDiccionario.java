public class NodoDiccionario 
{
    private int clave=0;
    private Estudiante estudiante=null;
    private NodoDiccionario siguiente=null;

    public void NodoDiccionario()
    {
        clave=0;
        estudiante=null;
        siguiente=null;
    }
    public NodoDiccionario(Estudiante estudiante)
    {
        clave = estudiante.getDni();
        this.estudiante = estudiante;
    }

    public int getClave()
    {
        return clave;
    }

    public void setClave(int clave)
    {
        this.clave = clave;
    }

    public Estudiante getEstudiante()
    {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante)
    {
        this.estudiante = estudiante;
    }

    public void setSiguiente(NodoDiccionario siguiente)
    {
        this.siguiente=siguiente;
    }

    public NodoDiccionario getSiguiente()
    {
        return siguiente;
    }

    public Estudiante buscarDni(int dni)
    {
        if(clave==dni)
        {
            return estudiante;
        }
        else
        {
            if(siguiente!=null)
            {
                return siguiente.buscarDni(dni);
            }
            else
            {
                return null;
            }
        }
    }

    public void eliminarEstudiante(int dni)
    {
        if (clave==dni) 
        {
            estudiante=null;
        }
        else
        {
            if(siguiente!=null)
            {
                if(siguiente.getClave()==dni && siguiente.getSiguiente()==null)
                {
                    siguiente=siguiente.getSiguiente();
                    System.out.println("Estudiante "+ siguiente.getEstudiante().getNombre() + " eliminado.");
                }
                else
                {
                    if(siguiente.getClave()==dni)
                    {
                        siguiente=null;
                        System.out.println("Estudiante "+ siguiente.getEstudiante().getNombre() + " eliminado.");
                    }
                    else
                    {
                        siguiente.eliminarEstudiante(dni);
                    }
                }
            }
        }
    }

    public void agregarEstudiante(Estudiante estudiante)
    {
        if(clave==0)
        {
            clave=estudiante.getDni();
            this.estudiante=estudiante;
        }
        else
        {
            if(siguiente==null)
            {
                NodoDiccionario nuevoNodo = new NodoDiccionario(estudiante);
                siguiente=nuevoNodo;
            }
            else
            {
                siguiente.agregarEstudiante(estudiante);
            }
        }
    }

    
}
