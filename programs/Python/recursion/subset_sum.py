from typing import List

class Solution:
    def subset_1(self, input: List[int]) -> int:
        ds = []
        self.recursion(0, input, 0, ds)
        ds.sort()
        return ds
    
    def subsets(self, nums: List[int]) -> List[List[int]]:
        ans = []
        self.recursion_2(0, nums, [], ans)
        return ans
    
    def recursion_2(self, idx: int, nums: List[int], ds: List[int], ans: List[List[int]]) -> None:
        # if idx >= len(nums):
        ans.append(ds[:])
        
        for i in range(idx, len(nums)):
            if i != idx and nums[i] == nums[i-1]:
                continue
            ds.append(nums[i])
            self.recursion_2(i + 1, nums, ds, ans)
            ds.pop()
    
    def recursion(self, idx: int, input: List[int], sum: int, ds: List[int]) -> None:
        if idx >= len(input):
            ds.append(sum)
            return
        
        sum += input[idx]
        self.recursion(idx + 1, input, sum, ds)
        sum -= input[idx]
        self.recursion(idx + 1, input, sum, ds)

if __name__ == "__main__":
    solution = Solution()
    result = solution.subsets([1,2,3])
    print("     =====           RESULT          =====", result)