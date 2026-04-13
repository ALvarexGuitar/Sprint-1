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
            new AdministradorCalificaciones().calificar(
                    Integer.parseInt(txtEntrega.getText()),
                    Double.parseDouble(txtNota.getText()),
                    txtComentario.getText()
            );
        });

        btnVer.addActionListener(e -> {
            Calificacion c = new AdministradorCalificaciones()
                    .obtenerCalificacion(Integer.parseInt(txtEntrega.getText()));

            if (c != null) {
                JOptionPane.showMessageDialog(this,
                        "Nota: " + c.getNota() + "\nComentario: " + c.getComentario());
            }
        });
    }
}