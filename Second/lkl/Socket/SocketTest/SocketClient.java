package my15;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class SocketClient {
    // 搭建客户端
    public static void main(String[] args) throws IOException {
        ucp();
        tcp();
    }


    private static void tcp() throws IOException{
        Socket socket = new Socket(InetAddress.getLocalHost(), 5209);
        System.out.println("客户端启动成功");
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader out = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        while (true) {
            String str = out.readLine();
            pw.println(str);
            pw.flush();
            System.out.println("客户端说：" + str);
            System.out.println("服务器说："+in.readLine());
        }
    }

    private static void ucp() throws IOException{
        // 1,创建服务端+端口
        DatagramSocket client = new DatagramSocket(614);

        // 2,准备数据
        String msg = "batman，I am you friends！";

        byte [] data = msg.getBytes();

        // 3,打包（发送的地点及端口）
        DatagramPacket packet = new DatagramPacket(data, data.length, new InetSocketAddress("127.0.0.1", 1219));

        // 4,发送资源
        client.send(packet);
        System.out.println("已发送数据包到服务端");
        // 5,关闭资源
        client.close();
    }
}
