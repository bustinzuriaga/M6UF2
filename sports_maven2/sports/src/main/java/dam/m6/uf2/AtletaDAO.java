package dam.m6.uf2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AtletaDAO implements DAO<Atleta> {
    private Connection conn;

    public AtletaDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void add(Atleta item) {
        String sql = "INSERT INTO deportistas (nombre, cod_deporte) VALUES (?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, item.nombre);
            statement.setInt(2, item.cod_deporte);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al añadir atleta: " + e.getMessage());
        }

    }

    @Override
    public List<Atleta> getAll() {
        List<Atleta> deportistas = new ArrayList<>();

          String sql = "SELECT * FROM deportistas";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                deportistas.add(new Atleta(
                        rs.getInt("cod"),
                        rs.getString("nombre"),
                        rs.getInt("cod_deporte")
                ));
            }


        } catch (SQLException e) {
            System.err.println("Error al buscar deportistas: " + e.getMessage());
        }

        return deportistas;
    }

    public boolean deportistaExists(String name) {
        return false;
    }

    public List<Atleta> getBySport(int sportId) {
        List<Atleta> atletes = new ArrayList<>();
        String sql = "SELECT cod, nombre, cod_deporte FROM deportistas WHERE cod_deporte = ? ORDER BY cod";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, sportId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    atletes.add(new Atleta(rs.getInt("cod"), rs.getString("nombre"), rs.getInt("cod_deporte")));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar atletes por esport: " + e.getMessage());
        }
        return atletes;
    }

}
