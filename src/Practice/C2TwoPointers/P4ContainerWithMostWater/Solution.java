package Practice.C2TwoPointers.P4ContainerWithMostWater;

public class Solution {

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int result = maxArea(height);
        System.out.println(result);
    }

    public static int maxArea(int[] height){
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {
            int containerLength = right - left;
            int area = containerLength * Math.min(height[left], height[right]);
            res = Math.max(res, area);
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return res;
    }
}
