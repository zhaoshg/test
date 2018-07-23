package edu.algs4.princeton;

public class StaticMethods {
    /**
     * 判断一个数是否为素数
     *
     * @param n
     * @return
     */
    public static boolean isPrime(int n) {
        //如果小于2，不是素数
        if (n < 2)
            return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 开平发（牛顿迭代法）
     *
     * @param c
     * @return
     */
    public static double sqrt(double c) {
        if (c < 0)
            return Double.NaN;
        double err = 1e-15;
        double tmp = c;

        while (Math.abs(tmp - c / tmp) > err * tmp)
            tmp = (c / tmp + tmp) / 2.0;
        return tmp;
    }


    public static double hypotenuse(double a, double b) {
        return Math.sqrt(a * a + b * b);
    }

    public static void main(String[] args) {
        System.out.println(sqrt(15.0));
    }
}