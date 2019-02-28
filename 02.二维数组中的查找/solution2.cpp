#include <vector>

using namespace std;
class Solution
{
  public:
    bool Find(int target, vector<vector<int>> array)
    {
        int rows = array.size();
        int cols = array[0].size();
        for (int i = 0; i < rows; ++i)
        {
            int index = binary_search(array[i], target, 0, cols - 1);
            if (index > -1)
            {
                return true;
            }
        }
        return false;
    }
    int binary_search(vector<int> array, int target, int left, int right)
    {
        int l = left;
        int r = right;

        while (l <= r)
        {
            int m = l + ((r - l) >> 1);
            if (array[m] < target)
            {
                l = m + 1;
            }
            else if (array[m] > target)
            {
                r = m - 1;
            }
            else
            {
                return m;
            }
        }
        return -1;
    }
};