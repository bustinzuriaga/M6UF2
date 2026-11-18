package dam.m6.uf2;

import java.sql.Connection;
import java.util.List;

public class SportsManager {
	Connection conn;

	public static void main(String[] args) { 
		System.out.println("Current directory (aquí heu de posar el XML): " + System.getProperty("user.dir"));
		SportsManager controller = new SportsManager();
		controller.init();
	}

	private void init() {

		this.conn = ConnectionManager.getConnection("database.xml");
		View mainView = new View();
		AtletaDAO atletaDAO = new AtletaDAO(conn);
		EsportDAO esportDAO = new EsportDAO(conn);

		if (conn == null) {
			mainView.missatge("No s'ha pogut connectar amb la base de dades.");
			return;
		}
		int option;
		do {
			option = mainView.mainMenu();
			switch (option) {
				case 1:
					esportDAO.add(mainView.EsportForm());
					break;
				case 2:
					List<Esport> esportsPerAlta = esportDAO.getAll();
					atletaDAO.add(mainView.AtletaForm(esportsPerAlta));
					break;
				case 3:
					List<Esport> esports = esportDAO.getAll();
					mainView.LlistaEsports(esports);
					int sportId = mainView.DemanarEsport();
					mainView.LlistaAtletes(atletaDAO.getBySport(sportId));
					break;
				case 0:
					break;
				default:
					mainView.missatge("Opció no vàlida.");
			}
		} while (option != 0);
		try {
			conn.close();
		} catch (java.sql.SQLException e) {
			mainView.missatge("Error en tancar la connexió: " + e.getMessage());
		}
	}
}
