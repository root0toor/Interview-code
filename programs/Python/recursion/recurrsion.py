class Solution:
    def __init__(self):
        pass

    def subsequence(self, index, output, input):
        if index == len(input):
            return [output.copy()]
        output.append(input[index])
        subsequences = self.subsequence(index + 1, output, input)
        output.pop()
        subsequences.extend(self.subsequence(index + 1, output, input))
        return subsequences

if __name__ == "__main__":
    input = [3, 1, 2]
    output = []
    solution = Solution()
    result = solution.subsequence(0, output, input)
    print(result)
