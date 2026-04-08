
package repositoriotareas.modelo;


public class Entrega {
    private int id;
    private int tareaId;
    private String archivo;
    private String fechaEntrega;

    public Entrega(int id, int tareaId, String archivo, String fechaEntrega) {
        this.id = id;
        this.tareaId = tareaId;
        this.archivo = archivo;
        this.fechaEntrega = fechaEntrega;
    }

    public int getId(){ 
        return id; 
    }
    
    public int getTareaId(){ 
        return tareaId; 
    }
    
    public String getArchivo(){ 
        return archivo; 
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }
}
    

