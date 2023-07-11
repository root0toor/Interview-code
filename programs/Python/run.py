class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

def isLeaf(node):
    if node is None:
        return False
    return node.left is None and node.right is None

def isSumTree(node):
    print(node.data)
    if node is None and isLeaf(node):
        return True
    
    if isSumTree(node.left) and isSumTree(node.right):
        left_sum = 0 if node.left is None else (node.left.data if isLeaf(node.left) else 2 * node.left.data)
        right_sum = 0 if node.right is None else (node.right.data if isLeaf(node.right) else 2 * node.right.data)
        return node.data == (left_sum + right_sum)
    return False

def isSumTree(node):
    if node is None or isLeaf(node):
        return True
    
    if isSumTree(node.left) and isSumTree(node.right):
        left_sum = 0 if node.left is None else (node.left.data if isLeaf(node.left) else 2 * node.left.data)
        right_sum = 0 if node.right is None else (node.right.data if isLeaf(node.right) else 2 * node.right.data)
        return node.data == left_sum + right_sum
    
    return False

# Test the code
root = Node(26)
root.left = Node(10)
root.right = Node(3)
root.left.left = Node(4)
root.left.right = Node(6)
root.right.right = Node(3)

if isSumTree(root):
    print("The given tree is a SumTree")
else:
    print("The given tree is not a SumTree")

