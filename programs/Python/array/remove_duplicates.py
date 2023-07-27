from typing import List

def removeDuplicates(nums: List[int]) -> int:
    idx = 0
    idy = 1
    while idy < len(nums):
        if nums[idx] == nums[idy]:
            idy += 1
        else:
            nums[idx + 1] = nums[idy]
            idx += 1

    return idx + 1

result = removeDuplicates([1, 1, 2, 2, 2, 3, 3])
print("         ====         RESULT         ====         ", result)