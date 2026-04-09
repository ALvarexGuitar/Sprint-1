package repositoriotareas.logica;

import repositoriotareas.baseDatos.CalificacionDAO;
import repositoriotareas.modelo.Calificacion;

public class AdministradorCalificaciones {
    private CalificacionDAO dao = new CalificacionDAO();

    public void calificarEntrega(int entregaId, double nota, String comentario) {
        dao.insertar(new Calificacion(0, entregaId, nota, comentario));
    }

    public Calificacion obtenerCalificacion(int entregaId) {
        return dao.obtenerPorEntrega(entregaId);
    }
}
