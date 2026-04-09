package repositoriotareas.vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class PanelProfesor extends JPanel {


    private JTextField txtTitulo, txtFecha;
    private JTextArea txtDesc;
    private DefaultTableModel modelo;



    public PanelProfesor() {
        setLayout(new BorderLayout(10,10));
        setBorder(new EmptyBorder(10,10,10,10));

        JLabel titulo = new JLabel("Gestión de Tareas");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add(titulo, BorderLayout.NORTH);

        JPanel form = new JPanel(new GridLayout(4,2,5,5));

        txtTitulo = new JTextField();
        txtDesc = new JTextArea();
        txtFecha = new JTextField();

        JButton btn = new JButton("Crear");

        form.add(new JLabel("Titulo"));
        form.add(txtTitulo);
        form.add(new JLabel("Descripcion"));
        form.add(txtDesc);
        form.add(new JLabel("Fecha"));
        form.add(txtFecha);
        form.add(btn);

        add(form, BorderLayout.WEST);
        
        
        // TODO C5 (integracion)
    }
    
}