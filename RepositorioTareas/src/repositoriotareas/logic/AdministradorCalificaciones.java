package repositoriotareas.logic;

import repositoriotareas.baseDatos.CalificacionDAO;
import repositoriotareas.model.Calificacion;

public class AdministradorCalificaciones {
    private CalificacionDAO dao = new CalificacionDAO();

    public void calificar(int entregaId, double nota, String comentario) {
        dao.insertar(new Calificacion(0, entregaId, nota, comentario));
    }

    public Calificacion obtenerCalificacion(int entregaId) {
        return dao.obtenerPorEntrega(entregaId);
    }
}
