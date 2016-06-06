// Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

// Note:
// Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
// The solution set must not contain duplicate triplets.
//     For example, given array S = {-1 0 1 2 -1 -4},

//     A solution set is:
//     (-1, 0, 1)
//     (-1, -1, 2)

import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
        ArrayList<ArrayList<Integer>> resultList=new ArrayList<ArrayList<Integer>>();
        Arrays.sort(nums);
        if(nums.length<3)
            return resultList;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(i!=0&&nums[i]==nums[i-1])
                continue;
            int p=i+1;
            int q=nums.length-1;
            while(p<q){
                sum=nums[i]+nums[p]+nums[q];
                if(sum<0)
                    p++;
                else if(sum>0)
                    p--;
                else {
                    ArrayList<Integer> result = new ArrayList<Integer>();
                    result.add(nums[i]);
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
        return resultList;
    }
}