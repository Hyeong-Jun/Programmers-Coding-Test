import re

def solution(new_id):
    answer = ''
    #1
    answer = new_id.lower()

    #2
    answer = re.sub(r"[^a-zA-Z0-9\.\-\_]", "", answer)

    #3
    answer = re.sub(r"\.{2,}", ".", answer)

    #4
    answer = re.sub(r"^\.|\.$", "", answer)

    #5
    if answer == '':
        answer += "a" 

    #6
    if len(answer) >= 16:
        answer = answer[:15]
        if answer[14] == ".":
            answer = answer[:14]

    #7
    if len(answer) <= 2:
        while(len(answer) < 3):
            answer += answer[len(answer)-1]

    return answer
