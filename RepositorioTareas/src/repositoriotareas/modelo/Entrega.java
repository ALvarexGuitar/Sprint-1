/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositoriotareas.modelo;

/**
 *
 * @author Windows
 */
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
    

