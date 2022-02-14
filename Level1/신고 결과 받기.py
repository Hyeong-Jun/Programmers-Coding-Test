from collections import Counter

def solution(id_list, report, k):
    answer = []
    check_list = []
    report_dict = {}
    count_list = []
    
    for report_id in id_list:
        report_dict[report_id] = []
        
    for i in report:
        did_report, got_reported = i.split()
        if(got_reported not in report_dict[did_report]):
            report_dict[did_report].append(got_reported)
            check_list.append(got_reported)
    count_list = Counter(check_list)
    
    for i in id_list:
        count = 0
        anw = report_dict[i]
        for j in anw:
            if (count_list[j] >= k):
                count += 1
        answer.append(count)
        
    return answer