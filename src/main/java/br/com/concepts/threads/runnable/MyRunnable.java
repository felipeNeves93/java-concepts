package br.com.concepts.threads.runnable;

import br.com.concepts.threads.thread.ThreadColor;

/**
 * We can implement the interface runnable and override
 * the run method to create a class with a thread
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(ThreadColor.ANSI_RED + "Inside My runnable implementation");
    }
}
