package test.practice.Thread;


public class Thread4 {
    public static volatile int numSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        Thread.sleep(3500);
        clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            try {
                while (!isInterrupted() && numSeconds >= 0) {
                    if (numSeconds == 0) {
                        System.out.println("Марш!");
                    } else {
                        System.out.print(numSeconds + " ");
                        Thread.sleep(1000);
                    }
                    numSeconds--;
                }
            } catch (InterruptedException e) {
                if (numSeconds != -1) {
                    System.out.println("Прервано!");
                }
            }
        }
    }
}
