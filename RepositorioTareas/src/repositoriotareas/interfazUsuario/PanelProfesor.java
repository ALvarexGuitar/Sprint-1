package repositoriotareas.interfazUsuario;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import repositoriotareas.controlador.AdministradorTareas;

public class PanelProfesor extends JPanel {

    private JTextField txtTitulo, txtFecha;
    private JTextArea txtDesc;
    private JTable tabla; 
    private DefaultTableModel modelo;
    private AdministradorTareas administrador; 

    public PanelProfesor() {
        administrador = new AdministradorTareas();
        
        setLayout(new BorderLayout(10,10));
        setBorder(new EmptyBorder(10,10,10,10));

        JLabel tituloLabel = new JLabel("Gestión de Tareas - Panel Docente");
        tituloLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add(tituloLabel, BorderLayout.NORTH);

        JPanel form = new JPanel(new GridLayout(4,2,5,5));
        txtTitulo = new JTextField();
        txtDesc = new JTextArea();
        txtFecha = new JTextField();
        JButton btn = new JButton("Crear Tarea");

        form.add(new JLabel("Título:"));
        form.add(txtTitulo);
        form.add(new JLabel("Descripción:"));
        form.add(new JScrollPane(txtDesc));
        form.add(new JLabel("Fecha Límite:"));
        form.add(txtFecha);
        form.add(new JLabel("Acción:"));
        form.add(btn);

        add(form, BorderLayout.WEST);


        modelo = new DefaultTableModel(new Object[]{"ID", "Título", "Fecha"}, 0);
        tabla = new JTable(modelo);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        btn.addActionListener(e -> {

        String t = txtTitulo.getText();
        String d = txtDesc.getText();
        String f = txtFecha.getText();

    try {
        administrador.crearTarea(t, d, f);

        JOptionPane.showMessageDialog(this, "Tarea creada correctamente");
        limpiarCampos();
        cargarTabla();

        } catch (IllegalArgumentException ex) {
    JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de validación", JOptionPane.WARNING_MESSAGE);
        }
    });

        cargarTabla();
    }

    private void cargarTabla() {
        modelo.setRowCount(0);
        administrador.obtenerTareas().forEach(tarea -> {
            modelo.addRow(new Object[]{tarea.getId(), tarea.getTitulo(), tarea.getFechaLimite()});
        });
    }

    private void limpiarCampos() {
        txtTitulo.setText("");
        txtDesc.setText("");
        txtFecha.setText("");
    }
}
