
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
    public static final String BLUE = "\u001B[34m";
    public static final String RESET = "\u001B[0m";
    
    public Server(int porta){
        this.porta=porta;
        try{
            serverSocket = new ServerSocket(porta);
            System.out.println(BLUE+"1) SERVER IN ASCOLTO"+RESET);
        }
        catch(BindException ex) {
            System.out.println(BLUE+"LA PORTA E' OCCUPATA"+RESET);
        } catch(IllegalArgumentException ex) {
             System.out.println(BLUE+"IL NUMERO DI PORTA NON E' VALIDO"+RESET);
        }
        catch(IOException ex){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(BLUE+"ERRORE DEL SERVER NELLA FASE DI BINDING"+RESET);
        }
    }
    
        public Socket attendi(){
        try {
            clientSocket = serverSocket.accept();
            System.out.println(BLUE+"2) CONNESSIONE CON IL CLIENT AVVENUTA E DATA SOCKET CREATO");
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(BLUE+"PROBLEMI DI CONNESSIONE CON IL CLIENT"+RESET);
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
            System.out.println(BLUE+"IL MESSAGGIO RICEVUTO E': "+s+RESET);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(BLUE+"IL MESSAGGIO NON E' STATO RICEVUTO"+RESET);
        }
        }
        
        public void scrivi(){
            OutputStream o;
            BufferedWriter bw;
            String mess = "SERVER ON";
        try {
             o = clientSocket.getOutputStream();
             bw=new BufferedWriter(new OutputStreamWriter(o));
             bw.write(BLUE+mess+"\n"+RESET);
             bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        public void chiudi(){
        if(clientSocket!=null){
            try{
                clientSocket.close();
                System.out.println(BLUE+"5) CHIUSURA DELLA CONNESSIONE CON IL CLIENT"+RESET);
            }
            catch(IOException ex){
             Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
        
        public void termina(){
           try {
            serverSocket.close();
            System.out.println(BLUE+"6) CHIUSURA SERVER"+RESET);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
  }
