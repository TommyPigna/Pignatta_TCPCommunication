/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tommaso pignatta
 */
public class MainClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Client c = new Client("Tommaso", "verde");
         c.connetti("localhost", 1906);
         c.scrivi();
         c.leggi();
         c.chiudi();

    }
    
}
