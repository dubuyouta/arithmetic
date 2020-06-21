package com.example.arithmetic.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author xiaobao.chen
 * Create at 2020-06-20
 */
public class BioService {

    private ServerSocket serverSocket;

    public BioService(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("服务启动。端口号是：" + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listener() throws IOException {

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println(socket.getPort());

            InputStream inputStream = socket.getInputStream();

            byte[] buff = new byte[1024];
            int read = inputStream.read(buff);
            if (read > 0) {
                System.out.println("接收到数据：" + new String(buff));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //启动服务端
        new BioService(8080).listener();
    }
}
