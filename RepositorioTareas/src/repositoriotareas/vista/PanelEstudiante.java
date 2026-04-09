package repositoriotareas.vista;

import repositoriotareas.logic.AdministradorTareas;
import repositoriotareas.model.Tarea;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelEstudiante extends JPanel {

    private JTable tabla;
    private DefaultTableModel modelo;
    private JTextField txtArchivo;

    public PanelEstudiante() {
        setLayout(new BorderLayout());

        modelo = new DefaultTableModel(new String[]{"ID","Titulo","Desc","Fecha"},0);
        tabla = new JTable(modelo);

        // La parte baja del JPanel y el botón se agregarán en el Día 3

        add(new JScrollPane(tabla), BorderLayout.CENTER);

        cargar();
    }

    private void cargar() {
        modelo.setRowCount(0);
        for (Tarea t : new AdministradorTareas().obtenerTareas()) {
            modelo.addRow(new Object[]{t.getId(), t.getTitulo(), t.getDescripcion(), t.getFechaLimite()});
        }
    }
}