from typing import List

class MaxSumNonAdjacent: 
    counter = 0
    def n_to_0(self, idx, nums, dp):
        if idx == 0:
            return nums[0]
        if idx < 0:
            return 0
        if dp[idx] != -1:
            return dp[idx]
        self.counter += 1
        pick = nums[idx] + self.n_to_0(idx - 2, nums, dp)
        not_pick = self.n_to_0(idx - 1, nums, dp)
        dp[idx] = max(pick, not_pick)
        return dp[idx]
    
    def recursion(self, idx, nums, dp: List, sum: int, max_sum: List[int]):
        if idx >= len(nums):
            max_sum[0] = max(max_sum[0], sum)
            # print(max_sum)
            return
        self.counter += 1
        # print(self.counter)
        dp[idx]
        for i in range(idx, len(nums)):
            # dp.append(nums[i])
            sum += nums[i]
            self.recursion(i + 2, nums, dp, sum, max_sum)
            # dp.pop()
            sum -= nums[i] 
            # self.recursion(i + 2, nums, dp, sum, max_sum)
        # pass

    def maximumNonAdjacentSum(self, nums):
        max_sum = [0]
        self.recursion(0, nums, [], 0, max_sum)
        return max_sum[0]

    def tabulation(self, nums):
        dp[0] = nums[0]

        for i in range(1, len(nums)):
            pick = nums[i]
            if i > 1:
                pick += dp[i - 2]
            not_pick = dp[i-1]
            dp[i] = max(pick, not_pick)
        return dp[len(nums) - 1]

if __name__ == "__main__":
    msnd = MaxSumNonAdjacent()
    input = [2, 1, 11, 9]
    input_1 = [1, 2, 3, 1, 3, 5, 8, 1, 9]
    # ans = msnd.maximumNonAdjacentSum(input)
    dp = [-1] * len(input_1)
    print("dp, ", dp)
    ans_1 = msnd.n_to_0(len(input_1) - 1, input_1, dp)
    ans_2 = msnd.tabulation(input_1)
    print("dp, ", dp)
    print(ans_1, ans_2)
    print("counter", msnd.counter)