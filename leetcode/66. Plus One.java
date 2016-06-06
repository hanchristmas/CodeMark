// Given a non-negative number represented as an array of digits, plus one to the number.

// The digits are stored such that the most significant digit is at the head of the list.

// 直接求解，设置一个进位标志carry，初值为1，表示加1，从最低位开始tmp = a[x] + carry， 
// a[x] = tmp%10，carry = tmp/10，
// 如果carry不为0对下一位再进行操作，直到所有的数位处理完或者carray为0就退出，
// 如果最后还有carray不为0说明整个数组要扩展一个数位。

public class Solution {
    public int[] plusOne(int[] digits) {
        int carry=1;
        int tmp=0;
        for(int i=digits.length-1;i>=0;i--){
            tmp=digits[i];
            digits[i]=(tmp+carry)%10;
            carry=(tmp+carry)/10;
            
            if(carry==0) break;
        }
        if(carry==1){
            int[] result =new int[digits.length+1];
            System.arraycopy(digits, 0, result, 1, digits.length);
            result[0]=1;
            return result;
        }
        else{
            return digits;
        }
    }
}