package com.demo.tcpDemo;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPdemoSever {

    public static void main(String[] args) throws Exception {
        TCPServer tcpServer = new TCPServer();
        tcpServer.listen();
    }




}
