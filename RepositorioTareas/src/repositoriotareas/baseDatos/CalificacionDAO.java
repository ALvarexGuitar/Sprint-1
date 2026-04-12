package repositoriotareas.baseDatos;



import java.sql.*;

import repositoriotareas.model.Calificacion;

public class CalificacionDAO {

    

    public void insertar(Calificacion c) {
        String sql = "INSERT INTO calificaciones(entrega_id, nota, comentario) VALUES (?, ?, ?)";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, c.getEntregaId());
            ps.setDouble(2, c.getNota());
            ps.setString(3, c.getComentario());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    

    public Calificacion obtenerPorEntrega(int entregaId) {
        String sql = "SELECT * FROM calificaciones WHERE entrega_id = ?";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, entregaId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Calificacion(
                        rs.getInt("id"),
                        entregaId,
                        rs.getDouble("nota"),
                        rs.getString("comentario")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
