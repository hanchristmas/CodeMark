// Given an array of integers, every element appears three times except for one. Find that single one.
// 统计每位二进制出现次数，若某位二进制出现次数不是3的倍数，则此位为1

public class Solution {
    public int singleNumber(int[] nums) {
        int result=0;
        int mask=0;
        int count=0;
        for(int i=0;i<32;i++){
            count=0;
            mask=1<<i;
            for(int j=0;j<nums.length;j++){
                if((mask&nums[j])!=0){
                    count++;
                }
            }
            if(count%3!=0){
                result|=mask;
            }
        }
        return result;
        
    }
}