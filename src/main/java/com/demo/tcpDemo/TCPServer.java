package com.demo.tcpDemo;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    private static final int PORT=7788;
    public void listen() throws Exception {
        // TODO Auto-generated method stub
        ServerSocket serverSocket=new ServerSocket(PORT);
        Socket client=serverSocket.accept();
        OutputStream os=client.getOutputStream();
        System.out.println("即将与客户端交互数据···");
        os.write(("Java 资源社区欢迎你！").getBytes());
        Thread.sleep(5000);
        System.out.println("结束与客户端交互数据");
        os.close();
        client.close();

    }
}

