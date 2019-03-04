#include <iostream>
#include <cstring>

using namespace std;

char buff[65535];
class Solution
{
  public:
    void replaceSpace(char *str, int length)
    {
        int numberOfSpace = 0;
        char *psrc, *pdest;
        for (int i = 0; i < length; ++i)
        {
            if (str[i] == ' ')
            {
                ++numberOfSpace;
            }
        }
        psrc = str + length;
        pdest = psrc + 2 * numberOfSpace;
        while (psrc >= str)
        {
            if (*psrc == ' ')
            {
                *pdest-- = '0';
                *pdest-- = '2';
                *pdest-- = '%';
                --psrc;
            }
            else
            {
                *pdest-- = *psrc--;
            }
        }
    }
};

int main()
{
    char test[255] = " ";
    Solution s;
    s.replaceSpace(nullptr, 1);
    char *p = test;
    while (*p != '\0')
    {
        cout << *p++;
    }
    cout << endl;
}