#include <vector>

using namespace std;
class Solution
{
  public:
    bool Find(int target, vector<vector<int>> array)
    {
        int rows, cols, i, j;
        rows = array.size();
        cols = array[0].size();
        i = 0;
        j = cols - 1;
        while (i < rows && j >= 0)
        {
            if (array[i][j] == target)
            {
                return true;
            }
            else if (array[i][j] < target)
            {
                ++i;
            }
            else
            {
                --j;
            }
        }
        return false;
    }
};