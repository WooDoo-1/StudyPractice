package test.practice.Lambda.task1;
interface Executable {
     int execute(int x, int y);
}
class Runner {
    public void run (Executable e) {
        System.out.println(e.execute(10, 20));
    }
}
class Test {
    public static void main(String[] args) {
        Runner runner = new Runner();
        final int a = 5;
        runner.run((x, y) -> x+y+a);
    }
}