
import java.io.*;
import java.net.BindException;
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
        catch(BindException ex) {
            System.out.println("LA PORTA E' OCCUPATA");
        } catch(IllegalArgumentException ex) {
             System.out.println("IL NUMERO DI PORTA NON E' VALIDO ");
        }
        catch(IOException ex){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("ERRORE DEL SERVER NELLA FASE DI BINDING");
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
           InputStream i;
           BufferedReader br;
           String s;
        try {
            i = clientSocket.getInputStream();

            br = new BufferedReader(new InputStreamReader(i));
            s=br.readLine();
            System.out.println("IL MESSAGGIO RICEVUTO E': "+s);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("IL MESSAGGIO RICEVUTO NON E' STATO RICEVUTO ");
        }
        }
        
        public void scrivi(){
            OutputStream o;
            BufferedWriter bw;
            String mess = "SERVER ON";
        try {
             o = clientSocket.getOutputStream();
             bw=new BufferedWriter(new OutputStreamWriter(o));
             bw.write(mess+"\n");
             bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
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
           try {
            serverSocket.close();
            System.out.println("6) CHIUSURA SERVER");
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
  }
