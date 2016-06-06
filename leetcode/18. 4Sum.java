// Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

// Note:
// Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
// The solution set must not contain duplicate quadruplets.
//     For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

//     A solution set is:
//     (-1,  0, 0, 1)
//     (-2, -1, 1, 2)
//     (-2,  0, 0, 2)

import java.util.*;

public class Solution {
    public ArrayList<ArrayList<Integer>> resultList=new ArrayList<ArrayList<Integer>>();
	public ArrayList<ArrayList<Integer>> fourSum(int[] nums,int target){

		Arrays.sort(nums);
		if(nums.length<4)
            return resultList;
        int sum=0;
        for(int i=0;i<nums.length;i++){
        	if(i!=0&&nums[i]==nums[i-1])
        		continue;
        	for(int j=i+1;j<nums.length;j++){
        		if(nums[j]==nums[j-1])
        			continue;
        		judgeAndPut(i,j,j+1,nums.length-1,target,nums);
        	}
        }
        return resultList;
	}

	public void judgeAndPut(int i,int j,int p,int q,int target,int[] nums){
		while(p<q){
			int sum=nums[i]+nums[j]+nums[p]+nums[q];
			if(sum<target)
				p++;
			else if(sum>target)
				q--;
			else{
				ArrayList<Integer> result = new ArrayList<Integer>();
                    result.add(nums[i]);
                    result.add(nums[j]);
                    result.add(nums[p]);
                    result.add(nums[q]);
                    resultList.add(result);
                    p++;
                    q--;
                    while(p<q&&nums[p]==nums[p-1]){
                        p++;
                    }
                    while(p<q&&nums[q]==nums[q+1]){
                        q--;
                    }
			}
		}
	}
}