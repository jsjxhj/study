package com.owen.study.net.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建一个简单的serverSocket
 */
public class SimpleServerSocket {
    public static void main(String[] args) throws IOException {
        //开启一个端口号为5678的socket监听
        try (ServerSocket server = new ServerSocket(5678)) {
            //程序阻塞，等待客户端接入
            Socket client = server.accept();
            //从client获取数据的通道
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            //往client写数据的通道
            PrintWriter pw = new PrintWriter(client.getOutputStream());

            while (true){
                //从client读取数据
                String line = br.readLine();
                //将读取的数据写回client
                pw.print(line);
                pw.flush();
                if("end".equalsIgnoreCase(line)){
                    break;
                }
            }

            //关闭客户端连接
            client.close();
        }
    }
}
