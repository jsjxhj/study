package com.owen.study.net.http;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class SimpleHttpConnection {

    public static void main(String[] args) {
        try {
            //1. 开启一个连接
            HttpURLConnection httpConnection = (HttpURLConnection) new URL(args[0]).openConnection();
            httpConnection.setRequestMethod("GET");
            //2. 从连接中获取一个输入流
            BufferedInputStream bis = new BufferedInputStream(httpConnection.getInputStream());
            //3. 定义一个输出流
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buff = new byte[1024];
            int byteRead;
            //4. 从输入流获取数据，写给输出流
            while (-1 != (byteRead = bis.read(buff, 0, buff.length))) {
                baos.write(buff, 0, byteRead);
            }

            String fileName = args[0].substring(args[0].lastIndexOf("/") + 1);
            FileOutputStream fos = new FileOutputStream(fileName);
            fos.write(baos.toByteArray());
            baos.close();
            fos.close();
            bis.close();
            httpConnection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
