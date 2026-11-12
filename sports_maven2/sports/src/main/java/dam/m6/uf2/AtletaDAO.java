package dam.m6.uf2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AtletaDAO implements DAO<Atleta> {
    private Connection conn;

    public AtletaDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void add(Atleta item) {
        // TODO Auto-generated method stub

        if (conn == null)
            return;
        try (Statement statement = conn.createStatement()) {

            // ResultSet resultSet = statement.executeQuery("INSERT ...");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        throw new UnsupportedOperationException("Unimplemented method 'add'");

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
                        rs.getString("name"),
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

}
