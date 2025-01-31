
import java.io.IOException;
import java.net.ServerSocket;
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
public class Server {
    ServerSocket serverSocket;
    Socket clientSocket;
    int porta;
    
    public Server(int porta){
        this.porta=porta;
        try{
            serverSocket = new ServerSocket(porta);
            System.out.println("1) SERVER IN ASCOLTO");
        }
        catch(IOException ex){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("ERRORE DEL SERVER NELLA FASE DI CONNESSIONE");
        }
    }
    
        public Socket attendi(){
        try {
            clientSocket = serverSocket.accept();
            System.out.println("2) CONNESSIONE CON IL CLIENT AVVENUTA E DATA SOCKET CREATO");
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("PROBLEMI DI CONNESSIONE CON IL CLIENT");
        }
        return clientSocket;
        }
        
        public void leggi(){
        }
        
        public void scrivi(){
            
        }
        
        public void chiudi(){
        if(clientSocket!=null){
            try{
                clientSocket.close();
                System.out.println("5) CHIUSURA DELLA CONNESSIONE CON IL CLIENT");
            }
            catch(IOException ex){
             Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
        
        public void termina(){
        }
    }
