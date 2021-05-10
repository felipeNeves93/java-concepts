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

        // One important concept is about the scope of the variables within the threads execution.
        // If a variable is declared inside the scope of a method for example, it will use the "Thread stack",
        // meaning that the variable wont be shared between threads.
        // However, if we declare an instance variable, it will be stored inside the Heap memory, being
        // Shared amongst all the executions.
        countdownThread1.start();
        countdownThread2.start();
    }
}
