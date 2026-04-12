package repositoriotareas.interfazUsuario;

import repositoriotareas.model.Entrega;
import repositoriotareas.baseDatos.EntregaDAO;

public class PruebaEntrega {
    public static void main(String[] args) {
        System.out.println("=== PRUEBA DE INTEGRACIÓN DÍA 3 ===");
        
        Entrega nuevaEntrega = new Entrega(0, 6, "tarea_final_v1.pdf");
        
        EntregaDAO dao = new EntregaDAO();
        
        System.out.println("Intentando insertar entrega para la tarea: " + nuevaEntrega.getTareaId());
        
        try {
            dao.insertar(nuevaEntrega);
            System.out.println("✅ ÉXITO: Los datos fluyeron correctamente al DAO.");
        } catch (Exception e) {
            System.out.println("❌ ERROR: Hubo un fallo en la conexión o en el SQL.");
            e.printStackTrace();
        }
    }
}