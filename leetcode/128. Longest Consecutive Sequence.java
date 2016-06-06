// Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

// For example,
// Given [100, 4, 200, 1, 3, 2],
// The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

// Your algorithm should run in O(n) complexity.

import java.util.*;

public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)
            return 0;
        
        Map<Integer,Boolean> numMap=new HashMap<Integer,Boolean>();
        int max=1;
        for(int e:nums){
            numMap.put(e,false);
        }
        for(Integer e :numMap.keySet()){
            if(numMap.get(e)==true)
                continue;
            numMap.put(e,true);
            int count=1;
            int left=e-1;
            int right=e+1;
            
            while(numMap.containsKey(left)){
                count++;
                numMap.put(left,true);
                left--;
            }
            while(numMap.containsKey(right)){
                count++;
                numMap.put(right,true);
                right++;
            }
            max=Math.max(max,count);
        }
        return max;
    }
}