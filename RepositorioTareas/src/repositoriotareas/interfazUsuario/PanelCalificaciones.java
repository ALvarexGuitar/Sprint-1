package repositoriotareas.interfazUsuario;
import java.awt.*;
import javax.swing.*;
import repositoriotareas.controlador.AdministradorCalificaciones;
import repositoriotareas.model.Calificacion;


public class PanelCalificaciones extends JPanel {

    private JTextField txtEntrega, txtNota, txtComentario;

    public PanelCalificaciones() {
        setLayout(new GridLayout(5,2,5,5));

        txtEntrega = new JTextField();
        txtNota = new JTextField();
        txtComentario = new JTextField();

        JButton btnGuardar = new JButton("Calificar");
        JButton btnVer = new JButton("Ver");
        
        add(new JLabel("Entrega ID"));
        add(txtEntrega);
        add(new JLabel("Nota"));
        add(txtNota);
        add(new JLabel("Comentario"));
        add(txtComentario);
        add(btnGuardar);
        add(btnVer);
        
        btnGuardar.addActionListener(e -> {

        try {
            int id = Integer.parseInt(txtEntrega.getText().trim());
            double nota = Double.parseDouble(txtNota.getText().trim());
            String comentario = txtComentario.getText().trim();

            new AdministradorCalificaciones().calificar(id, nota, comentario);

                JOptionPane.showMessageDialog(this, "Calificación guardada");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Datos inválidos");
        }
        });

        btnVer.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtEntrega.getText().trim());

                Calificacion c = new AdministradorCalificaciones()
                .obtenerCalificacion(id);

        if (c != null) {
            JOptionPane.showMessageDialog(this,
                "Nota: " + c.getNota() + "\nComentario: " + c.getComentario());
        } else {
            JOptionPane.showMessageDialog(this, "No existe calificación");
        }

        } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "ID inválido");
        }   
        });
    }
}