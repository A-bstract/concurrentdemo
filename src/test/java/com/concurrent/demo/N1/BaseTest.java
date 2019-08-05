package com.concurrent.demo.N1;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *  简单的文件复制
 */
public class BaseTest {
    public static void main(String args[]) throws Exception {
        //缓冲
        ByteBuffer bf = ByteBuffer.allocate(1000000);

        FileInputStream in = new FileInputStream("E:\\data\\image11.jpg");
        FileChannel channel = in.getChannel();
        channel.read(bf);
        bf.flip();

        FileOutputStream out = new FileOutputStream("C:\\Users\\admin\\Desktop\\testnio.jpg");
        FileChannel channelOut = out.getChannel();
        channelOut.write(bf);
    }
}
