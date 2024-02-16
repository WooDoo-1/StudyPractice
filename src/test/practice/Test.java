package test.practice;

import java.util.ArrayList;
import java.util.List;

/* 
Обратный отсчет
*/

public class Test {
    public static volatile List<String> list = new ArrayList<>(5);

    static {
        for (int i = 0; i < 5; i++) {
            list.add("Строка " + i);
        }
    }
    public static void main(String[] args) {
        Thread t = new Thread(new Countdown(3),"Countdown");
        t.start();
    }
    public static class Countdown implements Runnable {
        private int countFrom;

        public Countdown(int countFrom) {
            this.countFrom = countFrom;
        }
        public void run() {
            try {
                while (countFrom >= 0) {
                    printCountdown();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        public void printCountdown() throws InterruptedException {
                Thread.sleep(500);

                System.out.println(list.get(countFrom));
                countFrom--;
        }
    }
}