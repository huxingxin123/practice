package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpSocketReceiver {
    public static void main(String[] args) throws IOException {
        System.out.println("Receiver Start...");
        //创建Udp的Socket服务并初始化
        DatagramSocket datagramSocket=new DatagramSocket(6666);
        //创建接收数据的包
        byte[] bytes=new byte[1024];
        DatagramPacket datagramPacket=new DatagramPacket(bytes,bytes.length);
        //接收数据
        datagramSocket.receive(datagramPacket);
        //解析数据
        InetAddress address=datagramPacket.getAddress();//发送方IP
        int port=datagramPacket.getPort();//发送方端口
        String content=new String(datagramPacket.getData(),0,datagramPacket.getLength());
        System.out.println("address:"+address+"---port:"+port+"---content:"+content);
        //关闭服务
        datagramSocket.close();
    }
}
