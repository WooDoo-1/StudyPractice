package test.practice.Thread.task3;

public class Test {
    public static Thread.UncaughtExceptionHandler handler = new ThreadForUnc();
    public static void main(String[] args) {
        ThreadException mainThread = new ThreadException(handler);
        mainThread.interrupt();

//Раздвоение потока mainThread;
        Thread thread1FromMainThread = new Thread(mainThread, "thread1FromMainThread");
        Thread thread2FromMainThread = new Thread(mainThread, "thread2FromMainThread");
        thread1FromMainThread.setUncaughtExceptionHandler(handler);
        thread2FromMainThread.setUncaughtExceptionHandler(handler);
        thread1FromMainThread.start();
        thread2FromMainThread.start();
        thread1FromMainThread.interrupt();
        thread2FromMainThread.interrupt();
    }

    public static class ThreadException extends Thread{

        public ThreadException (Thread.UncaughtExceptionHandler handler) {
            setUncaughtExceptionHandler(handler);
            start();
        }
        @Override
        public void run() {
            System.out.println("Старт потока " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static class ThreadForUnc implements Thread.UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("Это исключение потока " + Thread.currentThread().getName());
        }
    }
}
