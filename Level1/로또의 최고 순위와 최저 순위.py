def rankByCount(count):
    rank=0
    if count==6:
        rank=1
    elif count==5:
        rank=2
    elif count==4:
        rank=3
    elif count==3:
        rank=4
    elif count==2:
        rank=5
    else:
        rank=6
    return rank

def solution(lottos, win_nums):
    answer = []
    count = 0
    anw = 0

    for i in range(len(lottos)):
        if(lottos[i]==0):
            lottos[i]=win_nums[i]
            anw += 1

    for i in range(len(lottos)):
        for j in range(len(win_nums)):
            if lottos[i] == win_nums[j]:
                count+=1
    rank=rankByCount(count)

    if rank+anw>6:
        anw=6-1

    answer=[rank, rank+anw]

    return answer
