package repositoriotareas.baseDatos;

import java.sql.*;
import java.util.ArrayList;

import repositoriotareas.model.Entrega;

public class EntregaDAO {

    

    public void insertar(Entrega e) {
        String sql = "INSERT INTO entregas(tarea_id, nombre_archivo) VALUES (?, ?)";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, e.getTareaId());
            ps.setString(2, e.getArchivo());
            ps.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public ArrayList<Entrega> listarPorTarea(int tareaId) {
        ArrayList<Entrega> lista = new ArrayList<>();
        String sql = "SELECT * FROM entregas WHERE tarea_id = ?";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, tareaId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Entrega(
                        rs.getInt("id"),
                        rs.getInt("tarea_id"),
                        rs.getString("nombre_archivo")
                ));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return lista;
    }
}
