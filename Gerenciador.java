import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Gerenciador {

    Servidor server;
    Cliente client;

    public void server(int hostPort) throws IOException{
    
        // inicia o servidor
        this.server = new Servidor(hostPort);
        
        this.server.executa();

    }    

    public void client(String ipServer, int hostPort, String username) throws UnknownHostException, IOException{
 
        // dispara cliente
        this.client = new Cliente(ipServer, hostPort, username);
        
        this.client.executa();
    
    }

}