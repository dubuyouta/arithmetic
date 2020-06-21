package com.example.arithmetic.io.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.UUID;

/**
 * @author xiaobao.chen
 * Create at 2020-06-20
 */
public class BioClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);

        OutputStream outputStream = socket.getOutputStream();


        String message = UUID.randomUUID().toString();

        outputStream.write(message.getBytes());
        outputStream.flush();
        outputStream.close();
        socket.close();
    }

}
