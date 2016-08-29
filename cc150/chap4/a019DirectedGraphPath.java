import java.util.*;

/*
    这个题目考察的其实是有向图的遍历，图的遍历分为深度优先遍历和广度优先遍历，深度优先遍历用堆栈实现，广度优先遍历用队列实现，在该题目中给出了每个节点的子节点，所以最好用广度优先遍历。

      图的广度优先遍历和树的层次遍历类似，但是不是完全相同，因为图是连通的，所以我们必须去标志那个节点被访问过，那个节点没有被访问过，最后如果全部访问完以后，还没有找到a到b的路径，则返回false。

注意知识点：

（1）图中有环，记得标记是否被访问

（2）要分别检测两个方向（a->b，b->a）

public class UndirectedGraphNode {
    int label = 0;
    UndirectedGraphNode left = null;
    UndirectedGraphNode right = null;
    ArrayList<UndirectedGraphNode> neighbors = new ArrayList<UndirectedGraphNode>();

    public UndirectedGraphNode(int label) {
        this.label = label;
    }
}*/
public class Path {
  public boolean checkPath(UndirectedGraphNode a, UndirectedGraphNode b) {
      // write code here
      /*
       * 这里的left，right好像不太有意义，主要根据邻接矩阵遍历
       * 利用栈，首先a自身入栈以及其临街矩阵所有节点入栈，入栈前都进行判断
       * 若该点邻居都不是b，则该点出栈，继续上述遍历
       * 为了防止环的产生，已经入栈过的点不再入栈，用map管理
       */
      return check(a,b) || check(b,a);
  }
  public boolean check(UndirectedGraphNode a, UndirectedGraphNode b) {
      // TODO Auto-generated method stub
      if(a == null || b == null){
          return false;
      }
      if(a == b){
          return true;
      }
      Map<UndirectedGraphNode, Boolean> checkedMap = new HashMap<UndirectedGraphNode, Boolean>();
      LinkedList<UndirectedGraphNode> searchQueue = new LinkedList<UndirectedGraphNode>();
      searchQueue.push(a);
      checkedMap.put(a, true);
      while(!searchQueue.isEmpty()){
          UndirectedGraphNode currentNode = searchQueue.pop();
          if(currentNode.neighbors != null){
              for(int i = 0; i < currentNode.neighbors.size(); i++){
                  UndirectedGraphNode neib = currentNode.neighbors.get(i);
                  if(neib != null){
                      if(neib == b){
                          return true;
                      }
                      if(checkedMap.get(neib) == null || !checkedMap.get(neib)){
                          searchQueue.push(neib);
                          checkedMap.put(neib, true);
                      }      
                  }
              }
          }
      }
      return false;
  }
}
