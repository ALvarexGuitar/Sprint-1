package repositoriotareas;
import repositoriotareas.interfazUsuario.PanelProfesor;
import repositoriotareas.interfazUsuario.PanelEstudiante;
import repositoriotareas.interfazUsuario.PanelCalificaciones;

import javax.swing.*;

public class RepositorioTareas extends JFrame {

public RepositorioTareas() {
    setTitle("Sistema de Tareas");
    setSize(900, 600);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    JTabbedPane tabs = new JTabbedPane();

    tabs.add("Docente", new PanelProfesor());
    tabs.add("Estudiante", new PanelEstudiante());
    tabs.add("Calificar", new PanelCalificaciones());

    add(tabs);
}

public static void main(String[] args) {
    new RepositorioTareas().setVisible(true);
}
}