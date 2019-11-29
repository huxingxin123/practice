package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPSever {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(6666);
        //获取客户端Socket
        Socket socket=serverSocket.accept();
        //获取输入流
        InputStream inputStream=socket.getInputStream();
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
        //输出客户端传来的数据
        String data=null;
        while ((data=bufferedReader.readLine())!=null){
            System.out.println("client:"+data);
        }
        //关闭服务
        socket.close();
        serverSocket.close();
    }
}
