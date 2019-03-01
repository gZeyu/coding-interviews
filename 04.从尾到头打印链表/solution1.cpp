#include <iostream>
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
        if (head == NULL)
        {
            return out;
        }
        ListNode *prev = head;
        ListNode *cur = head->next;
        ListNode *next;
        head->next = NULL;
        while (cur != NULL)
        {
            next = cur->next;
            cur->next = prev;
            prev = cur;
            cur = next;
        }

        cur = prev;
        while (cur != NULL)
        {
            out.push_back(cur->val);
            cur = cur->next;
        }

        return out;
    }
};

int main()
{
    Solution s;
    ListNode a(1), b(2), c(3), d(4), e(5);
    a.next = &b;
    b.next = &c;
    c.next = &d;
    d.next = &e;
    e.next = NULL;
    vector<int> out = s.printListFromTailToHead(&a);
    for (int i = 0; i < out.size(); ++i)
    {
        cout << out[i];
    }
    cout << endl;
}