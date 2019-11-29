package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpSocketSender {
    public static void main(String[] args) throws IOException {
        System.out.println("Sender Start...");
        //创建Socket服务
        DatagramSocket datagramSocket=new DatagramSocket();
        //发送消息内容
        String data="给你发的消息。";
        byte[] bytes=data.getBytes();
        //地址
        InetAddress address=InetAddress.getByName("113.250.157.248");
        //封装数据
        DatagramPacket datagramPacket=new DatagramPacket(bytes,bytes.length,address,6666);
        //发送消息
        datagramSocket.send(datagramPacket);
        //关闭服务
        datagramSocket.close();
    }
}
