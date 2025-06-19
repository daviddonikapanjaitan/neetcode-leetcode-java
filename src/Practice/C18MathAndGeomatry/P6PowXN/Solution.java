package Practice.C18MathAndGeomatry.P6PowXN;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        double x = 2.00000;
        int n = 10;

        // double x = 2.10000;
        // int n = 3;

        // double x = 2.00000;
        // int n = -2;

        double myPow = myPow(x, n);
        System.out.println(myPow);
    }

    public double myPow(double x, int n) {
        if(x == 0) return 0;
        if(n == 0) return 1;

        double res = 1;
        long power = Math.abs((long) n);

        while (power > 0) {
            if((power & 1) == 1) {
                res *= x;
            }
            x *= x;
            power >>= 1;
        }

        return n >= 0 ? res : 1 / res;
    }
}
