// Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

//     For example, given array S = {-1 2 1 -4}, and target = 1.

//     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int sum=0;
        int offset=0;
        int closest=nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length;i++){
        	int p=i+1;
        	int q=nums.length-1;
        	while(p<q){
        		sum=nums[i]+nums[p]+nums[q];
        		offset=sum-target;
        		if(offset==0)
        			return target;
        		
        		if(Math.abs(offset)<Math.abs(closest-target))
        			closest=sum;
        			
        		if(offset<0){
        			p++;
        			while(p<q&&nums[p]==nums[p-1]){
        				p++;
        			}
        		}
        		if(offset>0){
        			q--;
        			while(p<q&&nums[q]==nums[q-1]){
        				q--;
        			}
        		}
        	}
        	
        }
        return closest;
    }
}