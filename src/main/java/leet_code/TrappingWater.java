package leet_code;

import java.util.Arrays;

class TrappingWater {
    /* 
    * Time Complexity: O(N)
    * Space Complexity: O(N); Extra Space
    */
    public static void main(String[] args) {
        trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }

    static int trap(int[] height) {
        int trappedWater = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int[] minLR = new int[height.length];
        leftMax[0] = height[0];
        rightMax[height.length-1] = height[height.length-1];
        for(int i=1, j=height.length-2; i<height.length; i++, j--){
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
            rightMax[j] = Math.max(rightMax[j], rightMax[j + 1]);
        }
        System.out.println(Arrays.toString(leftMax));
        System.out.println(Arrays.toString(rightMax));
        for(int i=0; i<height.length; i++){
            minLR[i] = Math.min(leftMax[i], rightMax[i]);
        }
        for(int i=0; i<height.length; i++){
            if(height[i] <= minLR[i])
                trappedWater +=  minLR[i] - height[i];
        }
        return trappedWater;
    }
}
