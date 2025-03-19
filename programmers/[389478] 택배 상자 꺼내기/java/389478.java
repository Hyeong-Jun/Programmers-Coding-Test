class Solution {
    public int solution(int n, int w, int num) {
        int totalRows = (n % w == 0) ? n / w : n / w + 1; 
        int row = (num - 1) / w;
        int col = (num - 1) % w;

        if (row % 2 == 1) {
            col = (w - 1) - col;
        }

        int answer = 0;
        while (row < totalRows) {
            int currentCol = col;

            if (row % 2 == 1) {
                currentCol = (w - 1) - col;
            }

            if (row * w + currentCol < n) {
                answer++;
            }

            row++;
        }

        return answer;
    }
}
