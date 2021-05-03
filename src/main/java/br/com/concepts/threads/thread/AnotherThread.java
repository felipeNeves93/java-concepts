package br.com.concepts.threads.thread;

import static br.com.concepts.threads.thread.ThreadColor.ANSI_BLUE;

public class AnotherThread extends Thread {

    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "Hello from  " + currentThread().getName());

        // The sleep method is utilized to stop temporarily.
        // Its important to point that the sleep time is not 100% guaranteed. The thread could be interrupted by an
        // external proccess or some other event.
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            System.out.println(ANSI_BLUE + "Another thread woke me up");
            // It will immediately terminate the instance
//            return;
        }

        System.out.println(ANSI_BLUE + "Five seconds have passed and I'm awake");
    }
}
