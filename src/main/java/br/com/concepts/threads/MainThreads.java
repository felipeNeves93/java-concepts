package br.com.concepts.threads;

import static br.com.concepts.threads.thread.ThreadColor.ANSI_GREEN;
import static br.com.concepts.threads.thread.ThreadColor.ANSI_PURPLE;
import static br.com.concepts.threads.thread.ThreadColor.ANSI_RED;

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
        var myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello from the annonymous class's implementation");
                try {
                    // Here we are joining this instance with the AnotherThread instance.
                    // When Another Thread terminates its proccess, myRunnableThread will start running again.
                    // When we join a thread, means that the the Thread attached to anoter, will wait for the work of the first thread to
                    // finish to start its work. The parameter passed in the run method identify the maximum time allowed for wait to avoid
                    // unexpected errors
//                    anotherThread.join(2000);
                    anotherThread.join();
                    System.out.println(ANSI_RED + "AnotherThread terminated, so i'm running again");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_RED + "I couldnt wait after all. I was interrupted");
                }
                super.run();
            }
        });
        myRunnableThread.start();

        threadUsingLambda.start();
        // Applying the concept of interruption here. It will cause an InterruptedException in AnotherThread class,
        // and will immediately stop the exectuion of the instance.
//        anotherThread.interrupt();

        // Its more flexibe to use runnable instead of creatind a class that extends Threads.
        // Many classes in more recent versions of java expects Runnable objects.

    }
}
