
package repositoriotareas.baseDatos;

import repositoriotareas.modelo.Tarea;
import java.sql.*;
import java.util.ArrayList;

public class TareaDAO {

    public void insertar(Tarea t) {
        String sql = "INSERT INTO tareas(titulo, descripcion, fecha_limite) VALUES (?, ?, ?)";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, t.getTitulo());
            ps.setString(2, t.getDescripcion());
            ps.setString(3, t.getFechaLimite());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Tarea> listar() {
        ArrayList<Tarea> lista = new ArrayList<>();
        try (Connection conn = ConexionBD.conectar();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM tareas")) {
            while (rs.next()) {
                lista.add(new Tarea(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("descripcion"),
                    rs.getString("fecha_limite")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}