package br.com.concepts.threads.counter;

import br.com.concepts.threads.thread.ThreadColor;

/**
 * The objective of this class is to simulate a simple counter to show how multiple threads work
 */
public class Countdown {

    private static final String THREAD_1_NAME = "Thread 1";
    private static final String THREAD_2_NAME = "Thread 2";

    // Here we are defining two colors, one fot thread 1 and other for thread 2.
    // After that, we executing a simple for loop 10x to show how the order of printing can vary from execution to execution
    public void doCountdown() {
        final var amountOfTimesToShowCurrentThread = 10;
        var color = this.defineColorByThread(Thread.currentThread().getName());

        this.showCurrentThreadByAmountOfTimes(amountOfTimesToShowCurrentThread, color);
    }

    private void showCurrentThreadByAmountOfTimes(int amountOfTimesToShowCurrentThread, String color) {
        for (int i = amountOfTimesToShowCurrentThread; i > 0; i--) {
            System.out.println(String.format("Current index: %s | Current thread color: %s | Thread name: %s", i, color, Thread.currentThread().getName()));
        }
    }

    private String defineColorByThread(String threadName) {
        if (threadName.equals(THREAD_1_NAME)) {
            return ThreadColor.ANSI_CYAN;
        }

        if (threadName.equals(THREAD_2_NAME)) {
            return ThreadColor.ANSI_PURPLE;
        }

        return ThreadColor.ANSI_GREEN;
    }
}
