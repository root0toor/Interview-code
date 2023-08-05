class MinimumDeleteSum:
    def minimumDeleteSum(self, s1: str, s2: str) -> int:
        s1_map = {}
        for i in range(0, len(s1)):
            if s1[i] not in s1_map:
                s1_map[s1[i]] = 0
            s1_map[s1[i]] += 1
        for i in range(0, len(s2)):
            if s2[i] not in s1_map:
                s1_map[s2[i]] = 0
            s1_map[s2[i]] -= 1
        print(s1_map)
        return 0
    
if __name__ == "__main__":
    mds = MinimumDeleteSum()
    mds.minimumDeleteSum("sea", "eat")
    mds.minimumDeleteSum("delete", "leet")

print(ord("n") + ord("i"))
print(ord("n") + ord("t"))
print(ord("i") + ord("t"))
print(ord("n") + ord("i") + ord("t"))