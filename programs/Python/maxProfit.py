def findMaxProfit(jobs):
    
    jobs.sort(key=lambda x: x["profit"], reverse=True)

    max_deadline = max(jobs, key=lambda x: x["deadline"])["deadline"]

    arr = [-1] * max_deadline

    max_profit = 0

    for job in jobs:
        deadline = job["deadline"]
        slot = deadline - 1
        while (slot >= 0):
            if (arr[slot] == -1):
                break
            slot -= 1

        if slot >= 0:
            arr[slot] = job["job"]
            max_profit += job["profit"]
    
    return max_profit


jobs = [{"job": 1, "profit": 450, "deadline": 1},
        {"job": 2,   "profit": 250, "deadline": 2}, 
        {"job": 3,   "profit": 800, "deadline": 2},
        {"job": 4,   "profit": 300, "deadline": 3}]

max_profit = findMaxProfit(jobs)

print(max_profit)