package C17BitManipulation.P4ReverseBits;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution(){
        int input = 43261596;

        int result = reverseBits(input);
        System.out.println(result);
    }

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int bit = (n >> i) & 1;
            res += (bit << (31 - i));
        }

        return res;
    }
}
