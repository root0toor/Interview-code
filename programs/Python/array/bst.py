class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

def generate_bsts(start, end):
    if start > end:
        return [None]

    all_bsts = []
    for i in range(start, end + 1):
        left_subtrees = generate_bsts(start, i - 1)
        right_subtrees = generate_bsts(i + 1, end)

        for left_subtree in left_subtrees:
            for right_subtree in right_subtrees:
                root = TreeNode(i)
                root.left = left_subtree
                root.right = right_subtree
                all_bsts.append(root)

    return all_bsts

def generate_bst_combinations(n):
    if n <= 0:
        return []

    return generate_bsts(1, n)

# Function to print the tree in a human-readable format
def print_tree(root, level=0, prefix="Root: "):
    if root is not None:
        print(" " * (level * 4) + prefix + str(root.val))
        print_tree(root.left, level + 1, "L --- ")
        print_tree(root.right, level + 1, "R --- ")

# Test
n = 4
bst_combinations = generate_bst_combinations(n)
for idx, bst in enumerate(bst_combinations):
    print("BST Combination", idx + 1)
    print_tree(bst)
    print("\n")
