package Practice.C17BitManipulation.P6SumOfTwoIntegers;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        // int a = 1, b = 2;
        int a = 2, b = 3;

        int result = getSum(a, b);
        System.out.println(result);
    }

    public int getSum(int a, int b) {
        int carry = 0, res = 0, mask = 0xFFFFFFFF;

        for (int i = 0; i < 32; i++) {
            int a_bit = (a >> i) & 1;
            int b_bit = (b >> i) & 1;
            int cur_bit = a_bit ^ b_bit ^ carry;
            carry = (a_bit + b_bit + carry) >= 2 ? 1: 0;
            if(cur_bit != 0) {
                res |= (1 << i);
            }
        }

        if(res > 0x7FFFFFFF){
            res = ~(res ^ mask);
        }

        return res;
    }
}
