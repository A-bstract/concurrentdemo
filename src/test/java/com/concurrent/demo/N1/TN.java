package com.concurrent.demo.N1;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;

public class TN {
    public static void main(String args[]) throws InterruptedException {

        ByteBuffer bf = ByteBuffer.allocate(1024);

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (bf){
                    ByteArrayInputStream bArry = new ByteArrayInputStream("hellow".getBytes());
                    ReadableByteChannel ByteChannel = Channels.newChannel(bArry);
                    try {
                        ByteChannel.read(bf);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (bf){
                    System.out.println(new String(bf.array()));
                }
            }
        }).start();
    }
}
