#include <iostream>

struct TreeLinkNode
{
    int val;
    struct TreeLinkNode *left;
    struct TreeLinkNode *right;
    struct TreeLinkNode *next;
    TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL)
    {
    }
};

/*
struct TreeLinkNode {
    int val;
    struct TreeLinkNode *left;
    struct TreeLinkNode *right;
    struct TreeLinkNode *next;
    TreeLinkNode(int x) :val(x), left(NULL), right(NULL), next(NULL) {
        
    }
};
*/
class Solution
{
  public:
    TreeLinkNode *GetNext(TreeLinkNode *pNode)
    {

        TreeLinkNode *p;
        if (pNode == NULL)
        {
            return NULL;
        }
        else if (pNode->right != NULL)
        {
            p = pNode->right;
            while (p->left != NULL)
            {
                p = p->left;
            }
            return p;
        }
        else if (pNode->next != NULL)
        {
            p = pNode;
            while (p->next != NULL && p == p->next->right)
            {
                p = p->next;
            }
            return p->next;
        }
        else
        {
            return NULL;
        }
    }
};