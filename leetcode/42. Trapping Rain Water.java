// ����ÿ�����ӣ��ҵ�������������ߵ����ӣ������������ɵ�������� min(max_left,
// max_right) - height�����ԣ�
// 1. ��������ɨ��һ�飬����ÿ�����ӣ���ȡ������ֵ��
// 2. ��������ɨ��һ�飬����ÿ�����ӣ��������ֵ��
// 3. ��ɨ��һ�飬��ÿ�����ӵ�������ۼӡ�

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