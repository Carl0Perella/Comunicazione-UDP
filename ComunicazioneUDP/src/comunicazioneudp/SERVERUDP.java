/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package comunicazioneudp;
import java.io.*;
import java.net.*;


/**
 *
 * @author Carloperella
 */
public class SERVERUDP {
public static void main(String[] args) throws IOException{

        int porta = 8080;
        DatagramSocket serverSocket = new DatagramSocket(porta);
        
        boolean attivo = true;
        byte[] bufferIN = new byte[1024];
        byte[] bufferOUT = new byte[1024];
        
        System.out.println("Server in ascolto");
            DatagramPacket receivePacket = new DatagramPacket(bufferIN, bufferIN.length);
            serverSocket.receive(receivePacket);
            
            
            String ricevuto = new String(receivePacket.getData());
            int numCaratteri = receivePacket.getLength();
            
            
            ricevuto = ricevuto.substring(0,numCaratteri);
            System.out.println("Ricevuto : " + ricevuto);
            
            InetAddress IPClient = receivePacket.getAddress();
            int portaClinet = receivePacket.getPort();
            
            
            String daSpedire = ricevuto.toUpperCase();
            bufferOUT = daSpedire.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(bufferOUT, bufferOUT.length, IPClient, portaClinet);
            serverSocket.send(sendPacket); 
            
            if(ricevuto.equals("fine")){
                System.out.println("Fine della connessione");
                attivo=false;
        }
        
        serverSocket.close();
    }
    
}
