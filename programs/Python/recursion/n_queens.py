from typing import List

class Solution:
    def totalNQueens(self, n: int) -> List[List[str]]:
        matrix = [['.'] * n for _ in range(n)]
        left_row = [0] * (n)
        upper_diagonal = [0] * (2 * n - 1)
        lower_diagonal = [0] * (2 * n - 1)
        return self.recursion(0, matrix, left_row, upper_diagonal, lower_diagonal, n)
    
    def recursion(
            self, col: int, matrix: List[List[str]], left_row: List[int], 
            upper_diagonal: List[int], lower_diagonal: List[int], n: int
        ) -> None:
        ans = 0
        if col == n:
            # print("ïnside")
            return 1

        for row in range(0, n):
            if (
                left_row[row] == 0 and 
                lower_diagonal[row + col] == 0 and 
                upper_diagonal[n - 1 + col - row] == 0
            ):
                matrix[row][col] = "Q"
                left_row[row] = 1
                lower_diagonal[row + col] = 1
                upper_diagonal[n - 1 + col - row] = 1
                ans += self.recursion(col + 1, matrix, left_row, upper_diagonal, lower_diagonal, n)
                matrix[row][col] = "."
                left_row[row] = 0
                lower_diagonal[row + col] = 0
                upper_diagonal[n - 1 + col - row] = 0
        return ans
    
if __name__ == "__main__":
    solution = Solution()
    result = solution.totalNQueens(4)
    print(result)
    # print("\n")
    # for row in result:
    #     print(row)