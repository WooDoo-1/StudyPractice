package test.practice.Thread.task3;

public class Test {
    public static Thread.UncaughtExceptionHandler handler = new ThreadForUnc();
    public static void main(String[] args) {
        ThreadException thread1 = new ThreadException(handler);
        thread1.interrupt();

//Раздвоение потока thread1;
        Thread threadFirstFromThread1 = new Thread(thread1, "threadFirstFromThread1");
        Thread threadTwoFromThread1 = new Thread(thread1, "threadTwoFromThread1");
        threadFirstFromThread1.setUncaughtExceptionHandler(handler);
        threadTwoFromThread1.setUncaughtExceptionHandler(handler);
        threadFirstFromThread1.start();
        threadTwoFromThread1.start();
        threadFirstFromThread1.interrupt();
        threadTwoFromThread1.interrupt();
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
