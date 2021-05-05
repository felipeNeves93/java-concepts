package br.com.concepts.threads.counter;

public class Main {

    public static void main(String[] args) {
        var countdown = new Countdown();

        // We are creating here two instances of our CountdownThread that extends thread,
        // and passing the counter that we just created to show the order of numbers printed and colors.
        // It will vary from execution to execution
        var countdownThread1 = new CountdownThread(countdown);
        countdownThread1.setName("Thread 1");

        var countdownThread2 = new CountdownThread(countdown);
        countdownThread2.setName("Thread 2");

        countdownThread1.start();
        countdownThread2.start();
    }
}
