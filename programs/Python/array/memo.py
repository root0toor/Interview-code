from typing import List

class Solution:
    def recursion(self, s, wordDict, start, memo):
        if start == len(s):
            return True

        if start in memo:
            return memo[start]

        for i in range(start + 1, len(s) + 1):
            if s[start:i] in wordDict and self.recursion(s, wordDict, i, memo):
                memo[start] = True
                return True

        memo[start] = False
        return False

    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        memo = {}
        ans = self.recursion(s, wordDict, 0, memo)
        print(memo)
        return ans

if __name__ == "__main__":
    s = Solution()
    result = s.wordBreak("catscatsdog", ["cats", "dog", "sand", "and", "cat"])
    print("result is, ", result)
