package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpSocketOne {
    public static void main(String[] args) {
        try {
            new Thread(() -> {
                try {
                    receive();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
            send();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private static void receive()throws IOException{
        System.out.println("UdpSocketOne Receiver Start...");
        DatagramSocket datagramSocket=new DatagramSocket(6666);
        while (true){
            byte[] bytes=new byte[1024];
            DatagramPacket datagramPacket=new DatagramPacket(bytes,bytes.length);
            datagramSocket.receive(datagramPacket);
            String content=new String(datagramPacket.getData(),0,datagramPacket.getLength());
            System.out.println("content:"+content);
        }
    }

    private static void send()throws IOException{
        System.out.println("UdpSocketOne Sender Start...");
        DatagramSocket datagramSocket=new DatagramSocket();
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String line=null;
        while ((line=bufferedReader.readLine())!=null){
            System.out.print("输入消息：");
            byte[] bytes=line.getBytes();
            InetAddress address=InetAddress.getByName("255.255.255.255");
            DatagramPacket datagramPacket=new DatagramPacket(bytes,bytes.length,address,7777);
            datagramSocket.send(datagramPacket);
        }
        datagramSocket.close();
    }
}
