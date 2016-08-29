//直接遍历求子树深度的方法会有效率上的问题，因为遍历过程当中
//子节点会多次求深度，这样没有必要
//思路：后序遍历的方式，保存当前求得的深度，
//上层的节点就是当前深度加1，所以每个节点只求一次,效率上来了
 
class Balance {
public:
    bool isBalance(TreeNode *root, int *depth) {
        if (root == NULL) {
            *depth = 0;
            return true;
        }
        int ldepth, rdepth;
        if (isBalance(root->left, &ldepth) && isBalance(root->right, &rdepth)) {
            int diff = ldepth - rdepth;
            if (diff <= 1 && diff >= -1) {
                *depth = (ldepth > rdepth ? ldepth : rdepth) + 1;
                return true;
            }
        }
        return false;
    }
    bool isBalance(TreeNode* root) {
        int depth = 0;
        return isBalance(root, &depth);
    }
};
