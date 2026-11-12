package dam.m6.uf2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EsportDAO implements DAO<Esport> {
    private Connection conn;

    public EsportDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void add(Esport item) {
        // TODO Auto-generated method stub

        if (conn == null)
            return;
        try (Statement statement = conn.createStatement()) {

            // ResultSet resultSet = statement.executeQuery("INSERT ...");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // quitar los throws y poder cambiar el void por un Boolean que haga saber que s eha creado bien el Esport
        throw new UnsupportedOperationException("Unimplemented method 'add'");

    }

    @Override
    public List<Esport> getAll() {
        List<Esport> esports = new ArrayList<>();

          String sql = "SELECT * FROM deportistas";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                esports.add(new Esport(
                        rs.getInt("cod"),
                        rs.getString("name")
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
