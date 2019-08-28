package com.owen.study.net.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 创建一个简单的clientSocket
 */
public class SimpleClientSocket {
    public static void main(String[] args) throws IOException {
        //与服务端创立一个连接
        Socket server = new Socket(InetAddress.getLocalHost(),5678);
        //从服务端读取数据的通道
        BufferedReader serverBr = new BufferedReader(new InputStreamReader(server.getInputStream()));
        //向服务端写入数据的通道
        PrintWriter pw = new PrintWriter(server.getOutputStream());
        //从标准输入设备读取数据
        BufferedReader systemBr = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            //将标准输入中读取的数据，写给服务端
            String line = systemBr.readLine();
            pw.println(line);
            pw.flush();
            if("end".equalsIgnoreCase(line)){
                break;
            }
            System.out.printf(serverBr.readLine());
        }

        server.close();
    }
}
