/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositoriotareas.modelo;

/**
 *
 * @author Windows
 */
public class Calificacion{
    private int id;
    private int entregaId;
    private double nota;
    private String comentario;

    public Calificacion(int id, int entregaId, double nota, String comentario) {
        this.id = id;
        this.entregaId = entregaId;
        this.nota = nota;
        this.comentario = comentario;
    }

    public int getId(){ 
        return id; 
    }
    
    public int getEntregaId(){ 
        return entregaId; 
    }
    
    public double getNota(){ 
        return nota; 
    }
    
    public String getComentario(){ 
        return comentario; 
    }
    
}
