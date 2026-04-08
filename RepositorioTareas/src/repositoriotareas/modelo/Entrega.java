
package repositoriotareas.modelo;


public class Entrega {
    private int id;
    private int tareaId;
    private String archivo;

    public Entrega(int id, int tareaId, String archivo) {
        this.id = id;
        this.tareaId = tareaId;
        this.archivo = archivo;
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
}
    

