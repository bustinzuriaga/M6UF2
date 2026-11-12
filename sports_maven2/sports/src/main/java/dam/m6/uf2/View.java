package dam.m6.uf2;

import java.util.List;
import java.util.Scanner;

public class View {

    /**
     * @return
     */
    public int mainMenu() {
        System.out.println("1. Afegir un esport\n2. Afegir un esportista\n3. Llistar els atletes per esport\n...\n0 Sortir --> conn.close()");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        sc.close();
        return option;
        //throw new UnsupportedOperationException("Unimplemented method 'mainMenu'");
    }

    public void showAtletes(List<Atleta> list) {
        // Llistat d'usuaris
        System.out.println("MOSTRAR LLISTAT USUARIS....");
        for (Atleta atleta : list) {
            System.out.println(atleta.cod+ "\t" + atleta.name + "\t" + atleta.cod_deporte);
        }
    }

    
    public Esport addEsportForm(int last_cod){
        // Formulari usuari,
        System.out.println("FORMULARI USUARI....nom, pass, etc");
        Scanner sc = new Scanner(System.in);
        
        String username = sc.nextLine();

        sc.close();
        return new Esport(0, username);
    }


}
