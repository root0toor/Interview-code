from typing import List

class MaxSumNonAdjacent:
    def recursion(self, idx, nums, dp: List, sum: int, max_sum: List[int]):
        if idx >= len(nums):
            max_sum[0] = max(max_sum[0], sum)
            return
        if dp[idx] != -1:
            return

        dp[idx] = 1
        for i in range(idx, len(nums)):
            sum += nums[i]
            self.recursion(i + 2, nums, dp, sum, max_sum)
            sum -= nums[i]

    def maximumNonAdjacentSum(self, nums):
        max_sum = [0]
        dp = [-1] * len(nums)
        self.recursion(0, nums, dp, 0, max_sum)
        return max_sum[0]

if __name__ == "__main__":
    msnd = MaxSumNonAdjacent()
    input = [2, 1, 4, 9]
    ans = msnd.maximumNonAdjacentSum(input)
    print(ans)
