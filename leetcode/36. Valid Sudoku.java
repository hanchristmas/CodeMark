// Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

// The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


// A partially filled sudoku which is valid.

// Note:
// A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

// 在检测行是否合法时，i 表示矩阵的行，j 表示矩阵的列；
// 检测列是否合法时，i 表示矩阵的列，j 表示矩阵的行；
// 检测九宫格是否合法时，i 表示九宫格的标号，j 表示九宫格里的每个元素（只是我们需要根据i、j定位相应的元素到原来的矩阵：
// 第 i 个九宫格里面的第 j 个元素在原矩阵的第 3*(i/3) + j/3 行，第 3*(i%3) + j%3）列 ，“/” 表示整数除法）

import java.util.*;
public class Solution {
    public HashMap map=new HashMap();
    public boolean isValidSudoku(char[][] board) {
        //ÅÐ¶ÏÐÐ
        for(int i=0;i<board.length;i++){
            initMap();
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]>='0'&&board[i][j]<='9'){
                    if((int)map.get(board[i][j])>0)
                        return false;
                    else
                        map.put(board[i][j],1);
                }
                else if(board[i][j]!='.')
                    return false;
            }
        }
        
        //ÅÐ¶ÏÁÐ
        for(int i=0;i<board[0].length;i++){
            initMap();
            for(int j=0;j<board.length;j++){
                if(board[j][i]>='0'&&board[j][i]<='9'){
                    if((int)map.get(board[j][i])>0)
                        return false;
                    else
                        map.put(board[j][i],1);
                }
                else if(board[j][i]!='.')
                    return false;
            }
        }
        int i,j;
        //ÅÐ¶ÏÃ¿¸ömatrix
        for(int m=0;m<9;m++){
            initMap();
            for(int n=0;n<9;n++){
                i=3*(m/3)+n/3;
                j=3*(m%3)+n%3;
                if(board[i][j]>='0'&&board[i][j]<='9'){
                    if((int)map.get(board[i][j])>0)
                        return false;
                    else
                        map.put(board[i][j],1);
                }
                else if(board[i][j]!='.')
                    return false;
            }
        }
        return true;
    }
    
    private void initMap(){
        for(char c='0';c<='9';c++){
            map.put(c,0);
        }
    }
}