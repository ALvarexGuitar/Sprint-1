package repositoriotareas.vista;

import repositoriotareas.modelo.Calificacion;
import repositoriotareas.logic.AdministradorCalificaciones;

import javax.swing.*;
import java.awt.*;

public class PanelCalificaciones extends JPanel {

    private JTextField txtEntrega, txtNota, txtComentario;

    public PanelCalificaciones() {
        setLayout(new GridLayout(5,2,5,5));

        txtEntrega = new JTextField();
        txtNota = new JTextField();
        txtComentario = new JTextField();

        JButton btnGuardar = new JButton("Calificar");

        add(new JLabel("Entrega ID"));
        add(txtEntrega);
        add(new JLabel("Nota"));
        add(txtNota);
        add(new JLabel("Comentario"));
        add(txtComentario);
        add(btnGuardar);

        btnGuardar.addActionListener(e -> {
            new AdministradorCalificaciones().calificar(
                    Integer.parseInt(txtEntrega.getText()),
                    Double.parseDouble(txtNota.getText()),
                    txtComentario.getText()
            );
        });

        //mostrar nota para dia 5
    }
}