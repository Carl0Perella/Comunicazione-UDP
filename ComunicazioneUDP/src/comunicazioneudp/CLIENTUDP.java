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
public class CLIENTUDP {

    public static void main(String[] args) throws IOException{
        int porta = 8080;
        InetAddress IPServer = InetAddress.getByName("localhost");
        byte[] bufferIN = new byte[1024];
        byte[] bufferOUT = new byte[1024];
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
            DatagramSocket clientSocket = new DatagramSocket();
            System.out.println("Client pronto ad inviare il messaggio....");
            String daSpedire = in.readLine();
            bufferOUT = daSpedire.getBytes();
            DatagramPacket sendPacket = new DatagramPacket (bufferOUT, bufferOUT.length , IPServer, porta);
            clientSocket.send(sendPacket);
            DatagramPacket receivePacket = new DatagramPacket(bufferIN, bufferIN.length);
            clientSocket.receive(receivePacket);
            String ricevuto = new String(receivePacket.getData());
            int numCaratteri = receivePacket.getLength ( ) ;
            ricevuto=ricevuto.substring ( 0 , numCaratteri ) ;
            System.out.println ( " dal SERVER : " + ricevuto ) ; 
            clientSocket.close ( ) ;

    }    }