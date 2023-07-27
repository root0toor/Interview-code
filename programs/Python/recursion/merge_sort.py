class Solution:
    def __init__(self):
        pass

    def merge(self, arr, l, m, h, output):
        left = l
        right = m + 1
        temp = []
        while left <= m and right <= h:
            if arr[left] < arr[right]:
                temp.append(arr[left])
                left += 1
            else:
                temp.append(arr[right])
                right += 1
        while left <= m:
            temp.append(arr[left])
            left += 1
        while right <= h:
            temp.append(arr[right])
            right += 1

        # Assign the sorted elements back to the output list
        for i in range(len(temp)):
            output[l + i] = temp[i]

    def merge_sort(self, arr, l, h, output):
        if l < h:
            m = (l + h) // 2
            self.merge_sort(arr, l, m, output)
            self.merge_sort(arr, m + 1, h, output)
            self.merge(arr, l, m, h, output)

if __name__ == "__main__":
    input = [3, 1, 2, 8, 2, 1, 5, 6, 3, 8, 7]
    output = input[:]  # Make a copy of the input list
    solution = Solution()
    solution.merge_sort(input, 0, len(input) - 1, output)
    print(output)
