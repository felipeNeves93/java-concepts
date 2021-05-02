package br.com.concepts.threads.thread;

import static br.com.concepts.threads.thread.ThreadColor.ANSI_BLUE;

public class AnotherThread extends Thread {

    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "Run from another thread");
    }
}
