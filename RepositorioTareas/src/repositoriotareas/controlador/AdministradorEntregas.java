package repositoriotareas.controlador;

// ala espera del archivo EntregaDAO por parte de mi compañero 
import repositoriotareas.baseDatos.EntregaDAO;
import repositoriotareas.model.Entrega;

public class AdministradorEntregas {                                                                            //
    private EntregaDAO dao = new EntregaDAO();

    public void entregarTarea(int tareaId, String archivo) {                                                    //
        dao.insertar(new Entrega(0, tareaId, archivo));                                                                     //
    }
}
