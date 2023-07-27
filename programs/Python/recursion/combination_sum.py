from typing import List

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        output = set()
        candidates.sort()
        self.recursion_2(0, candidates, target, output, [])
        return [list(t) for t in output]

    def recursion_1(self, index: int, candidates: List[int], target: int, output: List[List[int]], ds: List[int]):
        if index >= len(candidates):
            if target == 0:
                output.append(ds[:])
            return

        if target >= candidates[index]:
            ds.append(candidates[index])
            self.recursion_1(index, candidates, target - candidates[index], output, ds)
            ds.pop()

        self.recursion_1(index + 1, candidates, target, output, ds)

    def recursion_2(self, index: int, candidates: List[int], target: int, output: set[List[int]], ds: List[int]):
        if target == 0:
            output.add(tuple(ds[:]))
            return

        for i in range(index, len(candidates)):
            if i > index and candidates[i] == candidates[i-1]:
                continue
            if target < candidates[i]:
                break
            ds.append(candidates[i])
            self.recursion_2(i + 1, candidates, target - candidates[i], output, ds)
            ds.pop()

if __name__ == "__main__":
    solution = Solution()
    result = solution.combinationSum([2,5,2,1,2], 5)
    print("     =====           RESULT          =====", result)