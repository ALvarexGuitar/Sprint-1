package repositoriotareas.ui;

import repositoriotareas.logic.AdministradorTareas;
import repositoriotareas.model.Tarea;

// Nota: Si C3 aún no te pasa AdministradorEntregas, 
// esta línea podría salir en rojo. Si es así, coméntala.
import repositoriotareas.logic.AdministradorEntregas; 

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelEstudiante extends JPanel {

    private JTable tabla;
    private DefaultTableModel modelo;
    private JTextField txtArchivo;

    public PanelEstudiante() {
        setLayout(new BorderLayout());

        // Configuración de la tabla con los datos de Tarea
        modelo = new DefaultTableModel(new String[]{"ID", "Título", "Descripción", "Fecha Límite"}, 0);
        tabla = new JTable(modelo);

        // Componentes para la entrega (Día 2 - C5)
        txtArchivo = new JTextField(20);
        JButton btnEntregar = new JButton("Entregar Tarea");

        JPanel panelInferior = new JPanel();
        panelInferior.add(new JLabel("Ruta del archivo:"));
        panelInferior.add(txtArchivo);
        panelInferior.add(btnEntregar);

        // Lógica de integración del botón
        btnEntregar.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila != -1) {
                int id = (int) tabla.getValueAt(fila, 0);
                String ruta = txtArchivo.getText();
                
                if(!ruta.isEmpty()) {
                    // Aquí conectamos con la lógica de entregas de C3
                    new AdministradorEntregas().entregarTarea(id, ruta);
                    JOptionPane.showMessageDialog(this, "Tarea " + id + " entregada con éxito.");
                } else {
                    JOptionPane.showMessageDialog(this, "Por favor, escribe la ruta del archivo.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona una tarea de la tabla primero.");
            }
        });

        add(new JScrollPane(tabla), BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        // Carga inicial de datos
        cargarDatos();
    }

    private void cargarDatos() {
        try {
            modelo.setRowCount(0);
            // Integración con el método de C3
            AdministradorTareas admin = new AdministradorTareas();
            for (Tarea t : admin.obtenerTareas()) {
                modelo.addRow(new Object[]{
                    t.getId(), 
                    t.getTitulo(), 
                    t.getDescripcion(), 
                    t.getFechaLimite()
                });
            }
        } catch (Exception e) {
            System.out.println("Error al cargar datos: " + e.getMessage());
        }
    }

    // MÉTODO PARA EJECUTAR LA PRUEBA DE INTEGRACIÓN
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Sistema de Tareas - Integración C5");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new PanelEstudiante());
            frame.setSize(700, 400);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}