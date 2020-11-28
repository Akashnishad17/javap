import math
t = int(input())

for w in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    
    count = 0
    
    for i in range(len(a)):
        
        sum = 0
        
        for j in range(i, len(a)):
            sum = sum + a[j]
            
            if int(math.sqrt(sum)) == math.sqrt(sum):
                count += 1
                
    print('Case #', w+1, ': ', count, sep = '')


# test = int(input())
# out = []
# for j in range(test):
#     n,k = map(int, input().split())
#     a = list(map(int, input().split()))
    
#     count = 0
#     dec = 0
#     i = 0
#     while i < n:
#         if a[i] == k:
#             while i < n and a[i] == k-dec:
#                 i += 1
#                 dec += 1
#             if dec == k:
#                 count += 1
#             dec = 0
#         i += 1
    
#     out.append(count)
    
# for j in range(test):
#     print('Case #', j+1, ': ', out[j], sep = '')