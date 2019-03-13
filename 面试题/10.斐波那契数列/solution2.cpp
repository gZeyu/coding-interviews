#include <iostream>
#include <string.h>
class Solution
{
  public:
    int dp[40];
    Solution()
    {
        dp[0] = 0;
        dp[1] = 1;
    }
    int Fibonacci(int n)
    {
        if (n > 1 && dp[n] == 0)
        {
            for (int i = 2; i <= n; ++i)
            {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }
};
