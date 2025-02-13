import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.Buffer;
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
        } catch(ConnectException ex){
            System.out.println("ERRORE DI CONNESSIONE CON IL SERVER");
        } catch(UnknownHostException ex){
            System.out.println("ERRORE NELLA RISOLUZIONE DEL NOME");
        }catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRORE NELLA CONNESSIONE");
        }
        }
    
     public void leggi() {
       InputStream i;
       BufferedReader br;
       String messaggio;
        try {
            i = socket.getInputStream();
            br=new BufferedReader(new InputStreamReader(i));
            messaggio=br.readLine();
            System.out.println("IL MESSAGGIO RICEVUTO E': "+messaggio);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
      public void scrivi() {
        OutputStream o;
        BufferedWriter bw;
        String s = "CLIENT ON";
         try {
             o = socket.getOutputStream();
             bw = new BufferedWriter(new OutputStreamWriter(o));
             bw.write(s+"\n");
             bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
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
