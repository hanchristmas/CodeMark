// 对于每个柱子，找到其左右两边最高的柱子，该柱子能容纳的面积就是 min(max_left,
// max_right) - height。所以，
// 1. 从左往右扫描一遍，对于每个柱子，求取左边最大值；
// 2. 从右往左扫描一遍，对于每个柱子，求最大右值；
// 3. 再扫描一遍，把每个柱子的面积并累加。

public class Solution {
    public int trap(int[] height) {
        
        int n=height.length;
        if(n<=2)
            return 0;
        int[] maxLeft=new int[n];
        int[] maxRight=new int[n];
        
        for(int i=1;i<n;i++){
            maxLeft[i]=Math.max(maxLeft[i-1],height[i-1]);
            maxRight[n-1-i]=Math.max(maxRight[n-i],height[n-i]);
        }
        int sum=0;
        for(int i=0;i<n;i++){
            int h=Math.min(maxLeft[i],maxRight[i]);
            if(h>height[i])
                sum+=(h-height[i]);
        }
        return sum;
    }
}