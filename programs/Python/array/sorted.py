from typing import List

class Solution:
    def isSorted(self, nums: List[int]) -> bool:
        return self.recursion(nums, 0, len(nums) - 1)

    def rotateArray(self, nums: List[int]):
        return
    
    def recursion(self, nums, l, h):
        if l >= h:
            return True
        m = (l + h) // 2
        
        if nums[m] < nums[m - 1] or nums[m] > nums[m + 1]:
            return False
        return self.recursion(nums, l, m - 1) and self.recursion(nums, m + 1, h)
    
    def _calculateFibonacciSeries(self, n: int, dp: List[int]) -> int:
        # print(n, dp)
        if n <= 1:
            return n
        prev2 = 0
        prev = 1
        # if dp[n] != -1:
        #     return dp[n]
        # dp[n] = self._calculateFibonacciSeries(n - 1, dp) + self._calculateFibonacciSeries(n - 2, dp)
        for i in range(2, n + 1):
            curr = prev2 + prev #3
            prev2 = prev #1
            prev = curr #2

        return curr

    def fibonacciSeries(self, n: int) -> int:
        dp = [-1] * (n + 1)
        return [self._calculateFibonacciSeries(n, dp), dp]

    
if __name__ == "__main__":
    sol = Solution()
    # is_sorted = sol.isSorted([1,2,3,4,5,6,7,8])
    ans = sol.fibonacciSeries(20000)
    print(" === ans is === ", ans[0])