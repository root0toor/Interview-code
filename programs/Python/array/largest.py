from math import inf
from typing import List

class Solution:
    def second_largest_good(self, input: List[int]) -> int:
        input.sort()
        n = len(input)
        second_max = None
        largest = input[n-1]
        for index in range(n-2, -1, -1):
            # print(input[index], second_max)
            if input[index] != largest:
                second_max = max(second_max, input[index])
                break

        return second_max
    
    def second_largest_better(self, input:List[int]) -> int:
        largest = -1
        for idx in range(0, len(input)):
            largest = max(largest, input[idx])

        second_largest = -1
        for idy in range(0, len(input)):
            # print(second_largest, largest, input[idy])
            if input[idy] < largest and second_largest < input[idy]:
                second_largest = input[idy]

        return second_largest
    
    def second_largest_and_smallest(self, input: List[int]):
        if len(input) < 2:
            return [-1, -1]
        largest = max(input[0], input[1])
        second_largest = min(input[0], input[1])

        smallest = min(input[0], input[1])
        second_smallest = max(input[0], input[1])

        for idx in range(2, len(input)):
            if largest < input[idx]:
                second_largest = largest
                largest = input[idx]
            elif input[idx] > second_largest:
                second_largest = input[idx]

            if smallest > input[idx]:
                second_smallest = smallest
                smallest = input[idx]
            elif input[idx] < second_smallest:
                second_smallest = input[idx]

        if largest == second_largest and smallest == second_smallest:
            return [-1, -1]
        elif largest == second_largest:
            return [-1, second_smallest]
        elif smallest == second_smallest:
            return [second_largest, -1]

        return [second_largest, second_smallest]
    
if __name__ == "__main__":
    sol = Solution()
    nums = [7, 7, 7, 7, 4, 7, 4, 7, 7, 5]
    result = sol.second_largest_and_smallest(nums)
    res = nums[:]
    res.sort()
    print(res)
    print("         =====           RESULT           =====          ", result)