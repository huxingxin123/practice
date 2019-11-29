package tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        //创建客户端Socket服务
        Socket socket=new Socket();
        //获取服务端地址
        InetSocketAddress address=new InetSocketAddress("192.168.0.107",6666);
        //请求连接
        socket.connect(address);
        //获取输出流并写入数据
        OutputStream outputStream=socket.getOutputStream();
        outputStream.write("你好！".getBytes());
        //关闭服务
        socket.close();
    }

}
