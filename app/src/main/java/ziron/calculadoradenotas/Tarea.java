package ziron.calculadoradenotas;

/**
 * Created by arodrigu46 on 18/11/2017.
 */

public class Tarea {
    private String id;
    private String foto;
    private String nombre;
    private String fechaEntrega;

    public Tarea() {

    }

    public Tarea(String id) {
        this.id = id;
    }

    public Tarea(String foto, String nombre, String fechaEntrega) {
        this.foto = foto;
        this.nombre = nombre;
        this.fechaEntrega = fechaEntrega;
    }

    public Tarea(String id, String foto, String nombre, String fechaEntrega) {
        this.id = id;
        this.foto = foto;
        this.nombre = nombre;
        this.fechaEntrega = fechaEntrega;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
    public void guardar(){
        Datos.guardarTarea(this);
    }
    public void modificar(){Datos.actualizar(this);}

    public void eliminar(){Datos.eliminar(this);}
}
