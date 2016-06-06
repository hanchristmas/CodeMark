// Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

// If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

// The replacement must be in-place, do not allocate extra memory.

// Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
// 1,2,3 → 1,3,2
// 3,2,1 → 1,2,3
// 1,1,5 → 1,5,1

// 分析：求下一个排列，例如：
// 1,2,3,4,5
// 1,2,3,5,4
// 1,2,4,3,5
// ...
// 1,2,5,4,3
// 1,3,2,4,5

// 三个步骤：
// (1)从右[len-1]往左[i]，找到num[i] > num[i-1],如没有，即i==0,则num为从大到小排列的数组，则此时的下一个排列，为所有元素从小到大的排列;
// (2)找到[num[i], num[len-1]]闭区间中比A[i-1]大的最小数num[minIndex],交换num[minIndex]和num[i-1],注：因为肯定有num[i] > num[i-1],所以minIndex从i开始;
// (3)对新的[num[i], num[len-1]],从小到大排序。


public class Solution {
    public void nextPermutation(int[] nums) {
        int mark=-1;
        int border=-1;

        for(int i=nums.length-1;i>0;i--){
            if(nums[i-1]<nums[i]){
                mark=i-1;
                break;
            }
        }
        
        if(mark==-1){
            reverse(nums,0,nums.length-1);
            return;
        }
        
        for(int j=nums.length-1;j>0;j--){
            if(nums[j]>nums[mark]){
                border=j;
                int tmp=nums[mark];
                nums[mark]=nums[border];
                nums[border]=tmp;
                break;
            }
        }

            
        reverse(nums,mark+1,nums.length-1);
    }
    
    public void reverse(int nums[],int start,int end){
        while(start<end){
            int tmp=nums[start];
            nums[start]=nums[end];
            nums[end]=tmp;
            start++;
            end--;
        }
    }
}