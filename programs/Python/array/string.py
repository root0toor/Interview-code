from typing import List

class Solution:
    def recursion(self, s, wordDict, start, str_map):
        if start == len(s):
            return True
        if start in str_map:
            return str_map[start]

        for i in range(start, len(s)):
            if s[start:i+1] in wordDict and self.recursion(s, wordDict, i+1, str_map):
                str_map[start] = True
                return True

        str_map[start] = False
        return False

    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        str_map = {}
        ans = self.recursion(s, wordDict, 0, str_map)
        print(str_map)
        return ans

if __name__ == "__main__":
    s = Solution()
    result = s.wordBreak("leetcode", ["leet","code"])
    # result = s.wordBreak("applepenapple", ["apple","pen"])
    # result = s.wordBreak("catsandog", ["cats","dog","sand","and","cat"])
    print("result is, ", result)
