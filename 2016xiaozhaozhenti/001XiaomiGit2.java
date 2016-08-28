import java.util.*;
// ／／牛客810369号
public class Solution {
     
    public boolean trace(char[][] tree, boolean[] visited, Stack<Integer> stack, int level, int x) {
         if (level > tree.length - 1)
            return false;
        if (level == x) {
            return true;
        }
        visited[level] = true;
 
        for (int i = 0; i < tree[level].length; ++i) {
            if (tree[level][i] == '1') {
                stack.push(i);
                if (!visited[i] && trace(tree, visited, stack, i, x))
                    return true;
                else {
                    stack.pop();
                }
            }
        }
        visited[level] = false;
        return false;
 
    }
 
    /**
     * 返回git树上两点的最近分割点
     *
     * @param matrix 接邻矩阵，表示git树，matrix[i][j] == '1' 当且仅当git树中第i个和第j个节点有连接，节点0为git树的跟节点
     * @param indexA 节点A的index
     * @param indexB 节点B的index
     * @return 整型
     */
    public int getSplitNode(String[] matrix, int indexA, int indexB) {
        Stack<Integer> astack = new Stack<Integer>();
        Stack<Integer> bstack = new Stack<Integer>();
 
        char[][] tree = new char[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; ++i) {
            char[] tmp = matrix[i].toCharArray();
            for (int j = 0; j < tree[i].length; j ++){
              tree[i][j] = tmp[j];
            }
        }
 
        astack.push(0);
        bstack.push(0);
        boolean[] visited = new boolean[matrix.length];
        visited[0] = true;
        trace(tree, visited, astack, 0, indexA);
        visited = new boolean[matrix.length];
        visited[0] = true;
        trace(tree, visited, bstack, 0, indexB);
 
        Stack<Integer> max;
        Stack<Integer> min;
 
        if (astack.size() >= bstack.size()) {
            max = astack;
            min = bstack;
        } else {
            max = bstack;
            min = astack;
        }
 
        int dis = max.si敏感词.size();
 
        while (dis-- > 0) {
            max.pop();
        }
        while (!max.isEmpty() && !min.isEmpty()) {
            int x = max.pop();
            int y = min.pop();
            if (x == y)
                return x;
        }
        return 0;
 
    }
 
}
