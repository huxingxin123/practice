package my15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketService {
    //搭建服务器端
    public static void main(String[] args) throws IOException{
        ucp();
        tcp();

    }

    private static void tcp() throws IOException{
        ServerSocket server=new ServerSocket(5209);
        System.out.println("服务器启动成功");
        Socket socket=server.accept();
        BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader out=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        while(true){
            System.out.println("客户端说："+in.readLine());
            String str = out.readLine();
            pw.println(str);
            pw.flush();
            System.out.println("服务器说："+str);
        }
    }
    private static void ucp() throws IOException{
        // 1,创建服务端+端口
        DatagramSocket server = new DatagramSocket(1219);

        System.out.println("等待客户端发送数据");
        // 2,准备接收容器
        byte[] container = new byte[1024];

        // 3,封装成包 new DatagramPacket(byte[] b,int length)
        DatagramPacket packet = new DatagramPacket(container, container.length);

        // 4,接收数据,使用 DatagramSocket的实例的 receive( DatagramPacket ) 方法进行接收
        server.receive(packet);

        // 5,分析数据
        byte[] data = packet.getData();
        int length = packet.getLength();
        String msg = new String(data, 0, length);
        System.out.println(msg);
        server.close();
    }
}