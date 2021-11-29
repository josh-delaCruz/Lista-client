package it.itismeucci;


public class App 
{
    public static void main( String[] args )
    {
        ClientSocket client = new ClientSocket(6789, "localhost");
        
        client.connetti();
        client.comunica();
    }
}
