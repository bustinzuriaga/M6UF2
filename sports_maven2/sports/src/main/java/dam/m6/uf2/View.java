package dam.m6.uf2;

import java.util.List;
import java.util.Scanner;

public class View {
    private final Scanner sc = new Scanner(System.in);

    /**
     * @return
     */
    public int mainMenu() {
        System.out.println("\n1. Afegir un esport\n2. Afegir un atleta\n3. Llistar els atletes per esport\n0. Sortir");
        System.out.print("Opció: ");
        int option = sc.nextInt();
        sc.nextLine();
        return option;
        //throw new UnsupportedOperationException("Unimplemented method 'mainMenu'");
    }

    public Esport EsportForm() {
        System.out.print("Nom de l'esport: ");
        return new Esport(0, sc.nextLine());
    }

    public Atleta AtletaForm(List<Esport> esports) {
        System.out.print("Nom de l'atleta: ");
        String nombre = sc.nextLine();
        LlistaEsports(esports);
        System.out.print("ID de l'esport: ");
        int sportId = sc.nextInt();
        sc.nextLine();
        return new Atleta(0, nombre, sportId);
    }

    public int DemanarEsport() {
        System.out.print("Introdueix l'ID de l'esport: ");
        int sportId = sc.nextInt();
        sc.nextLine();
        return sportId;
    }    

    public void LlistaAtletes(List<Atleta> list) {
        // Llistat d'usuaris
        System.out.println("MOSTRAR LLISTAT D'ATLETES....");
        for (Atleta atleta : list) {
            System.out.println(atleta.cod+ "\t" + atleta.nombre + "\t" + atleta.cod_deporte);
        }
    }

    public void LlistaEsports(List<Esport> list) {
        // Llistat d'usuaris
        System.out.println("MOSTRAR LLISTAT D'ESPORTS....");
        for (Esport esport : list) {
            System.out.println(esport.cod+ "\t" + esport.name);
        }
    }

    public void missatge(String message) {
        System.out.println(message);
    }

}
