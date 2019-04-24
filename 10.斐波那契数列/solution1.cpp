class Solution
{
  public:
    int Fibonacci(int n)
    {
        if (n == 0)
        {
            return 0;
        }
        else if (n == 1)
        {
            return 1;
        }
        else
        {
            return Fibonacci(n - 1) + Fibonacci(n - 1);
        }
    }
};

#include <iostream>
#include <algorithm>

using namespace std;

int arry[3] = {1, 2, 3}; //len==3;

void Permutation()
{
    do
        printf("%d%d%d\n", arry[0], arry[1], arry[2]);
    while (next_permutation(arry, arry + 3));
}

int main()
{

    Permutation();

    return 0;
}