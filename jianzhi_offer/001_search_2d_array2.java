/**
二维数组中的查找

    参与人数：18971 时间限制：1秒 空间限制：32768K
    本题知识点： 查找
    算法知识视频讲解

题目描述
在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

idea: start from bottom-left, if smaller, go right; if larger, go upper.
top-right similar beginning point
**/
public class Solution {
    public boolean Find(int [][] array,int target) {
        int len = array.length-1;
        int i = 0;
        while((len >= 0)&& (i < array[0].length)){
            if(array[len][i] > target){
                len--;
            }
            else if(array[len][i] < target){
                i++;
            }else{
                return true;
            }
        }
        return false;
    }
}
