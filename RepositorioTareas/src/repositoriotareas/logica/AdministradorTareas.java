package repositoriotareas.logica;

import repositoriotareas.baseDatos.TareaDAO;
import repositoriotareas.modelo.Tarea;
import java.util.ArrayList;

public class AdministradorTareas {
    private TareaDAO dao = new TareaDAO();

    public void crearTarea(String t, String d, String f) {
        dao.insertar(new Tarea(0, t, d, f));
    }

    public ArrayList<Tarea> obtenerTareas() {
        return dao.listar();
    }
}
