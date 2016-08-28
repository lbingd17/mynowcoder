import java.util.ArrayList;
import java.util.List;
/*

题目描述
git是一种分布式代码管理工具，git通过树的形式记录文件的更改历史，比如： base'<--base<--A<--A' ^ | --- B<--B' 
小米工程师常常需要寻找两个分支最近的分割点，即base.假设git 树是多叉树，
请实现一个算法，计算git树上任意两点的最近分割点。 
（假设git树节点数为n,用邻接矩阵的形式表示git树：
字符串数组matrix包含n个字符串，每个字符串由字符'0'或'1'组成，长度为n。
matrix[i][j]=='1'当且仅当git树种第i个和第j个节点有连接。节点0为git树的根节点。）
输入例子:

[01011,10100,01000,10000,10000],1,2


输出例子:

1
 

*/
public class Solution {
    /**
     * 返回git树上两点的最近分割点
     *
     * @param matrix 接邻矩阵，表示git树，matrix[i][j] == '1' 当且仅当git树中第i个和第j个节点有连接，节点0为git树的跟节点
     * @param indexA 节点A的index
     * @param indexB 节点B的index
     * @return 整型
     ＆copy from Author: 西西大虾 
     */
   public int getSplitNode(String[] matrix, int indexA, int indexB) {
 
        if(indexA == indexB){
            return indexA;
        }
        List<Integer> listA = new ArrayList<Integer>();
        List<Integer> listB = new ArrayList<Integer>();
 
        getBranch(listA,matrix,indexA,0,-1);
        getBranch(listB,matrix,indexB,0,-1);
 
        int lengthA = listA.size()-1;
        int lengthB = listB.size()-1;
        int splitNode = 0;
        while(lengthA>=0&&lengthB>=0){
            if(listA.get(lengthA)!=listB.get(lengthB)){
                break;
            }else{
                splitNode = listA.get(lengthA);
                lengthA--;
                lengthB--;
            }
        }
        return splitNode;
 
    }
 
    public int getBranch(List<Integer> list,String[] matrix,int index,int degree,int parentNode){
        if(index==0){
            return -1;
        }
        for(int i=0;i<matrix[degree].length();i++){
            if(matrix[degree].charAt(i) == '1' ){
                if(i==index){
                    list.add(i);
                    return degree;
                }else{
                    if(i==parentNode){
                        continue;
                    }
                    int result = getBranch(list,matrix,index,i,degree);
                    if(result!=-1){
                        list.add(i);
                        return result;
                    }
                }
            }
        }
 
        return -1;
    }
}
