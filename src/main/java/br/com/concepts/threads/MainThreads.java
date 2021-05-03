package br.com.concepts.threads;

import static br.com.concepts.threads.thread.ThreadColor.ANSI_GREEN;
import static br.com.concepts.threads.thread.ThreadColor.ANSI_PURPLE;

import br.com.concepts.threads.runnable.MyRunnable;
import br.com.concepts.threads.thread.AnotherThread;

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
        anotherThread.setName("== Another Thread =="); // It's possible to set a name for thread to me easier to identify

        // Start the run method to execute the block of code
        anotherThread.start();

        // We cannot guarantee when the thread is going to be executed. Its up to the JVM to decide
        System.out.println(ANSI_GREEN + "Hello again from the main thread");

        // Using lambdas (anonymous class) to create a thread
        Thread threadUsingLambda = new Thread(() -> System.out.println("Running inside the lambda"));

        // Another form of creating thread is implementing the runnable interface
        var myRUnnableThread = new Thread(new MyRunnable());
        myRUnnableThread.start();

        threadUsingLambda.start();

        // Its more flexibe to use runnable instead of creatind a class that extends Threads.
        // Many classes in more recent versions of java expects Runnable objects.

    }
}
