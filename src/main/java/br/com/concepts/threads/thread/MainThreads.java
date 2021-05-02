package br.com.concepts.threads.thread;

import static br.com.concepts.threads.thread.ThreadColor.ANSI_GREEN;
import static br.com.concepts.threads.thread.ThreadColor.ANSI_PURPLE;

public class MainThreads {

    /**
     * Every Java program has a proccess.
     * Every Proccess has one or more threads.
     * Thread can be described as an task that a proccess executes
     */
    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main thread");

        // Creates a new instance of the class that we've created that overrides the Thread superclass
        var anotherThread = new AnotherThread();

        // Start the run method to execute the block of code
        anotherThread.start();

        // We cannot guarantee when the thread is going to be executed. Its up to the JVM to decide
        System.out.println(ANSI_GREEN + "Hello again from the main thread");

        // Using lambdas (anonymous class) to create a thread
        Thread threadUsingLambda = new Thread(() -> System.out.println("Running inside the lambda"));

        threadUsingLambda.start();

    }
}
