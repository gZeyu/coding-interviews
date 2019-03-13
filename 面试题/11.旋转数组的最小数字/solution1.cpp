#include <vector>

using namespace std;

class Solution
{
  public:
	int minNumberInRotateArray(vector<int> rotateArray)
	{
		int left, right, mid;
		if (rotateArray.size() == 0)
		{
			return 0;
		}
		left = 0;
		right = rotateArray.size() - 1;
		mid = left + ((right - left - 1) >> 1) + 1;
		while (left < right - 1)
		{
			if (rotateArray[left] == rotateArray[right] && rotateArray[left] == rotateArray[mid])
			{
				--right;
			}
			else if (rotateArray[mid] >= rotateArray[left])
			{
				left = mid;
			}
			else
			{
				right = mid;
			}
			mid = left + ((right - left - 1) >> 1) + 1;
		}
		return rotateArray[mid];
	}
};