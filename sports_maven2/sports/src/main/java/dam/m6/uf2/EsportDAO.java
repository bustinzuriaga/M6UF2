package dam.m6.uf2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EsportDAO implements DAO<Esport> {
    private Connection conn;

    public EsportDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void add(Esport item) {
        String sql = "INSERT INTO deportes (nombre) VALUES (?)";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, item.name);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al añadir esport: " + e.getMessage());
        }

    }

    @Override
    public List<Esport> getAll() {
        List<Esport> esports = new ArrayList<>();

          String sql = "SELECT * FROM deportes";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                esports.add(new Esport(
                        rs.getInt("cod"),
                        rs.getString("nombre")
                ));
            }


        } catch (SQLException e) {
            System.err.println("Error al buscar esports: " + e.getMessage());
        }

        return esports;
    }

    public boolean deportistaExists(String name) {
        return false;
    }

}
