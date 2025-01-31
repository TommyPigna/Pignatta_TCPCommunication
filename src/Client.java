import java.net.ConnectException;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tommaso pignatta
 */
public class Client {
    String nome;
    String colore;
    Socket socket;
    
    public Client(String nome, String colore){
        this.nome=nome;
        this.colore=colore;
    }
    
    public void connetti(String nomeServer, int porta){
        try {
            socket = new Socket(nomeServer, porta);
            System.out.println("1) CONNESSIONE AVVENUTA CON IL SERVER");
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("ERRORE NELLA FASE DI COMUNICAZIONE");
            
        }
    }
    
    public void chiudi(){
        if(socket!=null){
            try{
                socket.close();
                System.out.println("4) CHIUSURA DELLA CONNESSIONE CON IL SERVER");
            }
            catch(ConnectException ex){
            System.err.println("ERRORE: SERVER NON CONNESSO");
            }
            catch(IOException ex){
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
}
