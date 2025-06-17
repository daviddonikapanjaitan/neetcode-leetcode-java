package C17BitManipulation.P2NumberOf1Bits;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        // int n = 11;
        // int n = 128;
        int n = 2147483645;

        int result = hammingWeight(n);
        System.out.println(result);
    }

    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if((1 << i & n) != 0){
                res++;
            }
        }

        return res;
    }
}
