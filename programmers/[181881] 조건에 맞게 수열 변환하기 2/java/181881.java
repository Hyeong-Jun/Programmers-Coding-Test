import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int iter = 0;
        Map<String, Integer> map = new HashMap<>();
        String arrString = Arrays.toString(arr);
        while (!map.containsKey(arrString)) {
            map.put(arrString, iter);
            
            for (int i = 0; i < arr.length; i++) {
                int num = arr[i];
                if (num >= 50 && (num % 2 == 0)) {
                    arr[i] = num / 2;
                } else if (num < 50 && (num % 2 == 1)) {
                    arr[i] = num * 2 + 1;
                }
            }
            
            arrString = Arrays.toString(arr);
            iter++;
        }
        
        return iter - 1;
    }
}
