from typing import List
# // // // String[] recipe = ["a0","apple", "apple", "flour", "flour", "sugar"] (m)
# // // // String[] storeInventory = ["a","apple","apple","az","flour", "flour","yeast"] (n)




# //recipe = ["apple", "flour","sugar"]


# // Your previous Plain Text content is preserved below:

# // // // You want to bake a pie. You have a recipe, but no ingredients at home. 
# // // // There is a store, and it has an inventory.

# // // // Given the recipe, and the store's inventory, please write a function to return whether or not you can bake the pie.


# // //

# i recipe
# j storeInventory 
# arr[i] != arr[j]
#     continue

# {
#     ä":1,
#     apple: 0
#     az:1,
#     flour: 2,
#     yeast:1
# }

# loop recipe -> 0:n (n+1) return True
#     recipeitem is in storeInventory:
#         storeInventory[item] -= 1

# [1,2,3,3,4]
# [1,2,3,3,3,3,3,4]

def isAvailable(recipie: List[str], inventory: List[str]) -> bool:
    i = 0
    j = 0
    while i < len(recipie) and j < len(inventory):
        print(i, j)
        # if j == len(inventory) and i < len(recipie):
        #     return False
        if recipie[i] == inventory[j]:
            i += 1
            j += 1
        elif recipie[i] < inventory[j]:
            return False
        else:
            j += 1

    return True

ans = isAvailable(["apple", "apple", "flour", "flour", "sugar","yeast"], ["apple","az","flour", "flour","sugar", "tea", "yeast"])
print(ans)