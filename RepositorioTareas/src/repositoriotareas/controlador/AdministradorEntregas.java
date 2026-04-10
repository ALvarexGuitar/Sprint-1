package repositoriotareas.controlador;

import repositoriotareas.baseDatos.EntregaDAO;  
import repositoriotareas.modelo.Entrega;

public class AdministradorEntregas {
    private EntregaDAO dao = new EntregaDAO();

    public void entregarTarea(int tareaId, String archivo) {
        dao.insertar(new Entrega(0, tareaId, archivo));
    }
}
