package it.itismeucci;

import java.io.*;
import java.net.*;

public class ClientSocket {
    
    protected int porta; //porta
    protected String indirizzo; //indirizzo server
    protected Socket server;
    
    //lettura e invio dati
    protected String daInviare;
    protected BufferedReader tastiera;
    protected DataOutputStream output; //output verso il server
    protected BufferedReader input; //input dal server
    
    
    public ClientSocket(int porta, String indirizzoServer) {
        this.porta = porta;
        this.indirizzo = indirizzoServer;
    }
    
    public void connetti(){
        try {
            System.out.println("Clien in esecuzione");
            System.out.println("Connessione al Server....");
            
            server = new Socket(indirizzo, porta);
            
            tastiera = new BufferedReader(new InputStreamReader(System.in));
            input = new BufferedReader(new InputStreamReader(server.getInputStream()));
            output = new DataOutputStream(server.getOutputStream());
            
        } catch (IOException ex) { System.out.println("Errore nella connessione verso il server\n" + ex.getMessage()); }
    }
    
    
    public void comunica(){
        try {
            System.out.println(input.readLine());
            for(;;){
              System.out.println(input.readLine());
                daInviare = tastiera.readLine();
                
                output.writeBytes(daInviare + '\n');

                System.out.println(input.readLine() + '\n');  
              
            }
        } catch (IOException ex) { System.out.println("Errore nella comunicazione \n " + ex.getMessage()); }
        
    }
    
    }
