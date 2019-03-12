#include <vector>
using namespace std;

struct ListNode
{
    int val;
    struct ListNode *next;
    ListNode(int x) : val(x), next(NULL)
    {
    }
};

class Solution
{
  public:
    vector<int> printListFromTailToHead(ListNode *head)
    {
        vector<int> out;
        ListNode *p = head;
        int length = 0;
        while (p != NULL)
        {
            {
                ++length;
                p = p->next;
            }
            out.resize(length);
            p = head;
            for (int i = length - 1; i > -1; --i)
            {
                out[i] = p->val;
                p = p->next;
            }
        }
        return out;
    }
};