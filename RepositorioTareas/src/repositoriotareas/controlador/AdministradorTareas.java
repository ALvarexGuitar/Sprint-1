package repositoriotareas.controlador;

// se verifico la parte de optencion de Tareas correctamente

import repositoriotareas.baseDatos.TareaDAO;
import repositoriotareas.model.Tarea;

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
