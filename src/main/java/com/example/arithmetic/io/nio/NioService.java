package com.example.arithmetic.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author xiaobao.chen
 * Create at 2020-06-20
 */
public class NioService {

    private int port = 8080;

    //多路复用器
    //轮询器
    private Selector selector;

    //缓冲区 Buffer 等候区
    private ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

    public NioService(int port) {

        try {
            //channel
            ServerSocketChannel socketChannel = ServerSocketChannel.open();

            //绑定端口号
            socketChannel.bind(new InetSocketAddress(port));

            //设置IO模型为非阻塞。
            socketChannel.configureBlocking(false);

            //轮询器打开
            selector = Selector.open();

            //注册。
            socketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listen() {
        System.out.println("listen on " + this.port + ".");

        try {
            while (true) {
                int select = selector.select();
                //
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = keys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    process(key);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void process(SelectionKey key) throws IOException {

        if (key.isAcceptable()) {
            //如果是可接受状态，要把当前状态设置为可读状态。
            ServerSocketChannel server = (ServerSocketChannel) key.channel();

            SocketChannel socketChannel = server.accept();

            socketChannel.configureBlocking(false);

            key = socketChannel.register(selector, SelectionKey.OP_READ);
        } else if (key.isReadable()) {
            SocketChannel socketChannel = (SocketChannel) key.channel();

            int read = socketChannel.read(byteBuffer);
            if (read > 0) {
                byteBuffer.flip();
                String content = new String(byteBuffer.array(), 0, read);
                System.out.println("接受消息：" + content);

                //可以设置后续的状态为可写状态
                key = socketChannel.register(selector, SelectionKey.OP_WRITE);
                key.attach(content);
            }
        } else if (key.isWritable()) {
            SocketChannel socketChannel = (SocketChannel) key.channel();
            String attachment = (String) key.attachment();
            socketChannel.write(ByteBuffer.wrap(attachment.getBytes()));
            socketChannel.close();
        }
    }

    public static void main(String[] args) {
        new NioService(8080).listen();
    }
}
