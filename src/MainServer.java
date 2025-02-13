
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tommaso pignatta
 */
public class MainServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Server s = new Server(1906);
        Scanner scanner = new Scanner(System.in);
        System.out.print("INSERISCI IL NUMERO DI CLIENT CON IL QUALE SI VUOLE REALIZZARE UN COMUNICAZIONE TCP: ");
        int numClient = scanner.nextInt();
        scanner.close();
        for(int i=0; i<numClient; i++){
        s.attendi();
        s.leggi();
        s.scrivi();
        s.chiudi();
    }
        s.termina();
    }
}
