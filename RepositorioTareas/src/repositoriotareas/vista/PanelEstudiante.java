package repositoriotareas.vista;
import repositoriotareas.logic.AdministradorEntregas;
import repositoriotareas.logic.AdministradorTareas;
import repositoriotareas.modelo.Tarea;

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

        txtArchivo = new JTextField(20);
        JButton btn = new JButton("Entregar");

        JPanel abajo = new JPanel();
        abajo.add(txtArchivo);
        abajo.add(btn);

        
        btn.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            int id = (int) tabla.getValueAt(fila,0);
            
            new AdministradorEntregas().entregarTarea(id, txtArchivo.getText());
        });
        
        add(new JScrollPane(tabla), BorderLayout.CENTER);
        add(abajo, BorderLayout.SOUTH);
        cargar();


    }

    private void cargar() {
        modelo.setRowCount(0);
        for (Tarea t : new AdministradorTareas().obtenerTareas()) {
            modelo.addRow(new Object[]{t.getId(), t.getTitulo(), t.getDescripcion(), t.getFechaLimite()});
        }
    }
}