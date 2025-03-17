class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> luckyNumbers = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        int[] minInRow = new int[m];
        for(int i = 0; i < m; i++) {
            int min = matrix[i][0];
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
            minInRow[i] = min;
        }

        int[] maxInCol = new int[n];
        for(int j = 0; j < n; j++) {
            int max = matrix[0][j];
            for(int i = 1; i < m; i++) {
                if(matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
            maxInCol[j] = max;
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == minInRow[i] && matrix[i][j] == maxInCol[j]) {
                    luckyNumbers.add(matrix[i][j]);
                }
            }
        }
        return luckyNumbers;
    }
}