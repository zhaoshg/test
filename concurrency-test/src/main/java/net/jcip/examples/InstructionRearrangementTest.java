package net.jcip.examples;

public class InstructionRearrangementTest {
    private static int x = 0;
    private static int y = 0;

    private static int a = 0;
    private static int b = 0;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for (; ; ) {
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            Thread one = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    a = 1;
                    x = b;
                }
            });
            Thread other = new Thread(new Runnable() {
                @Override
                public void run() {
                    b = 1;
                    y = a;
                }
            });
            one.start();
            other.start();
            one.join();
            other.join();
            String result = "第" + i + "次 (" + x + "," + y + ")";
            if (x == 0 && y == 0) {
                System.err.println(result);
                break;
            } else {

            }
        }
    }
}
