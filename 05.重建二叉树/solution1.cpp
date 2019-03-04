#include <iostream>
#include <vector>

using namespace std;
struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution
{
  public:
    TreeNode *reConstructBinaryTree(vector<int> pre, vector<int> vin)
    {
        if (pre.empty() || vin.empty())
        {
            return NULL;
        }
        TreeNode *root = new TreeNode(pre[0]);
        int idxOfRootInorder = 0;
        for (int i = 0; i < vin.size(); ++i)
        {
            if (vin[i] == root->val)
            {
                idxOfRootInorder = i;
            }
        }
        int lengthOfLeft = idxOfRootInorder - 0;
        vector<int> preOfLeft, vinOfLeft, preOfRight, vinOfRight;
        preOfLeft.assign(pre.begin() + 1, pre.begin() + 1 + lengthOfLeft);
        preOfRight.assign(pre.begin() + 1 + lengthOfLeft, pre.end());
        vinOfLeft.assign(vin.begin(), vin.begin() + lengthOfLeft);
        vinOfRight.assign(vin.begin() + lengthOfLeft + 1, vin.end());
        root->left = reConstructBinaryTree(preOfLeft, vinOfLeft);
        root->right = reConstructBinaryTree(preOfRight, vinOfRight);
        return root;
    }
};
