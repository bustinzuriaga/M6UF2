package dam.m6.uf2;

import java.sql.Connection;

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

		// mainView.mainMenu()
		int option = mainView.mainMenu();
		// switch option
		switch (option) {
			case 1:
					
				break;
			case 2:
					
		
			default:
				break;
		}
		// Afegir Usuari
		// Llistar usuaris



	}
}
