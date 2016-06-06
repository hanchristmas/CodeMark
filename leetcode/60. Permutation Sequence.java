// The set [1,2,3,…,n] contains a total of n! unique permutations.

// By listing and labeling all of the permutations in order,
// We get the following sequence (ie, for n = 3):

// "123"
// "132"
// "213"
// "231"
// "312"
// "321"
// Given n and k, return the kth permutation sequence.

// Note: Given n will be between 1 and 9 inclusive.


// 假设有n个元素，第K个permutation是
// a1, a2, a3, .....   ..., an
// 那么a1是哪一个数字呢？
// 那么这里，我们把a1去掉，那么剩下的permutation为
// a2, a3, .... .... an, 共计n-1个元素。 n-1个元素共有(n-1)!组排列，那么这里就可以知道
// 设变量K1 = K
// a1 = K1 / (n-1)!
// 同理，a2的值可以推导为
// a2 = K2 / (n-2)!
// K2 = K1 % (n-1)!
//  .......
// a(n-1) = K(n-1) / 1!
// K(n-1) = K(n-2) /2!
// an = K(n-1)

public class Solution {
    public String getPermutation(int n, int k) {
        int[] nums=new int[n];
        int selected;
        for(int i=0;i<n;i++){
            nums[i]=i+1;
        }
        k--;
        String result="";
        for(int i=0;i<n;i++){
            selected=k/recursion(n-1-i);
            result+=Integer.toString(nums[selected]);
            k=k%recursion(n-1-i);
            
            //去掉已填入序列的数字，索引在后的数字向前补
            for(int j=selected;j<n-1;j++){		
                nums[j]=nums[j+1];
            }
        }
        return result;
        
    }
    
    public int recursion(int i){    
       if(i<0)                          
          return -1;
       else if(i==0)                     
          return 1;
        else                           
          return i*recursion(i-1);
    }
}