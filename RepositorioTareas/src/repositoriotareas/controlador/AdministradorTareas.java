package repositoriotareas.controlador;

// se verifico la parte de optencion de Tareas correctamente

import repositoriotareas.baseDatos.TareaDAO;
import repositoriotareas.model.Tarea;

import java.util.ArrayList;

public class AdministradorTareas {
    private TareaDAO dao = new TareaDAO();


    // Se agrego la validacion para campos sin valor

    public void crearTarea(String t, String d, String f) {

    if (t == null || t.trim().isEmpty()) {
        throw new IllegalArgumentException("El título es obligatorio");
    }

    if (d == null || d.trim().isEmpty()) {
        throw new IllegalArgumentException("La descripción es obligatoria");
    }

    if (f == null || f.trim().isEmpty()) {
        throw new IllegalArgumentException("La fecha es obligatoria");
    }


//Validacion de Fecha corecta

    if (!f.matches("\\d{2}/\\d{2}/\\d{2}")) {
        throw new IllegalArgumentException("La fecha debe seguir el formato DD/MM/YY (ej: 25/12/26)");
    }

    dao.insertar(new Tarea(0, t, d, f));
}


    public ArrayList<Tarea> obtenerTareas() {
        return dao.listar();
    }
}
