from typing import List

class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        ans = []
        self.recursion(nums, [], [False] * len(nums), ans)
        return ans
    
    def recursion(self, nums: List[int], ds: List[int], flag: List[bool], ans: List[List[int]]) -> None:
        if len(ds) == len(nums):
            ans.append(ds[:])
            return
        
        for i in range(0, len(nums)):
            if not flag[i]:
                flag[i] = True
                ds.append(nums[i])
                self.recursion(nums, ds, flag, ans)
                ds.pop()
                flag[i] = False

    def recursion_1(self, idx: int, nums: List[int], ans: List[List[int]]) -> None:
        return

    def permute_1(self, nums: List[int]) -> List[List[int]]:
        ans = []
        self.recursion_1(0, nums, ans)

if __name__ == "__main__":
    solution = Solution()
    result = solution.permute([1,2,3])
    print("     =====           RESULT          =====", result)