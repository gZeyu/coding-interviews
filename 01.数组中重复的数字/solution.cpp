class Solution {
public:
    // Parameters:
    //        numbers:     an array of integers
    //        length:      the length of array numbers
    //        duplication: (Output) the duplicated number in the array number
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    bool duplicate(int numbers[], int length, int* duplication) {
        std:map<int,bool> number_map;
        for (int i = 0; i < length; ++i)
        {
            if (number_map[numbers[i]])
            {
                *duplication = numbers[i];
                return true;
            }
            else
            {
                number_map[numbers[i]] = true;
            }
        }
        return false;
    }
};
