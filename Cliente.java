/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author Virginia
 */
public class Cliente {
   
   private String host;
   private int porta;
   private String username;
   
   public Cliente (String host, int porta, String username) {
     this.host = host;
     this.porta = porta;
     this.username = username;
   }
   
   public void executa() throws UnknownHostException, IOException {
     
    try {

      Socket cliente = new Socket(this.host, this.porta);
      Chat interfaceClient = new Chat(this.username, this.host, false, this.porta);

      interfaceClient.setMessage(" "+this.username +" se conectou ao servidor!");
 
      // thread para receber mensagens do servidor
      Recebedor r = new Recebedor(cliente.getInputStream());
      new Thread(r).start();
     
      // lê msgs do teclado e manda pro servidor
      Scanner teclado = new Scanner(System.in);
      PrintStream saida = new PrintStream(cliente.getOutputStream());
      while (teclado.hasNextLine()) {
        saida.println(this.username+ ": " +teclado.nextLine());
        interfaceClient.setMessage(this.username+ ": " +teclado.nextLine());
       
      }
     
      saida.close();
      teclado.close();
      cliente.close();   

    } catch(IOException exception){

      System.out.println("Oops");
      Chat interfaceClient = new Chat(" ", " ", false, 0);

    }

   }
 }
