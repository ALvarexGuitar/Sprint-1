
package repositoriotareas.model;

public class Tarea {
    
    private int id;
    private String titulo;
    private String descripcion;
    private String fechaLimite;

    public Tarea(int id, String titulo, String descripcion, String fechaLimite){
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaLimite = fechaLimite;
    }

    public int getId(){ 
        return id; 
    }
    
    public String getTitulo(){ 
        return titulo; 
    }
    
    public String getDescripcion(){ 
        return descripcion; 
    }
    
    public String getFechaLimite(){ 
        return fechaLimite; 
    }
   
}
