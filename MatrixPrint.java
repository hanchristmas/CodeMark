//矩阵蛇形打印

import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
       ArrayList<Integer> result=new ArrayList<Integer>();
       int m=matrix.length;//行数
       int n=matrix[0].length;//列数
       int layers=(Math.min(n,m)-1)/2+1;//层数
        for(int i=0;i<layers;i++){
            for(int x=i;x<n-i;x++){result.add(matrix[i][x]);}
            for(int y=i+1;y<m-i;y++){result.add(matrix[y][n-i-1]);}
            for(int w=n-i-2;(w>=i)&&(m-i-1!=i);w--){result.add(matrix[m-i-1][w]);}//判断单行单列的重复打印问题
            for(int v=m-i-2;(v>i)&&(n-i-1!=i);v--){result.add(matrix[v][i]);};//判断单行单列的重复打印问题
        }
        return result;
    }