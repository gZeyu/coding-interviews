#include <iostream>
#include <vector>
#include <stack>
#include <string>
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
        stack<int> s;
        ListNode *p = head;
        while (p != NULL)
        {
            s.push(p->val);
            p = p->next;
        }
        while (!s.empty())
        {
            out.push_back(s.top());
            s.pop();
        }
        return out;
    }
};

int main()
{
    // Solution s;
    // ListNode a(1), b(2), c(3), d(4), e(5);
    // a.next = &b;
    // b.next = &c;
    // c.next = &d;
    // d.next = &e;
    // e.next = NULL;
    // vector<int> out = s.printListFromTailToHead(&a);
    // for (int i = 0; i < out.size(); ++i)
    // {
    //     cout << out[i];
    // }
    // cout << endl;
    string a = "a";
    string b = a;
    string c = b;
    c = " ";
    a
            cout
        << (c.c_str() == b.c_str());
    return 0;
}