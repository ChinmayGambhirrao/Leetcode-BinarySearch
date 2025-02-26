class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = 0;
        int minSum = 0;
        int maxAbsSum = 0;
        int currentMax = 0;
        int currentMin = 0;

        for(int num:nums) {
            currentMax = Math.max(num, currentMax + num);
            currentMin = Math.min(num, currentMin + num);

            maxSum = Math.max(maxSum, currentMax);
            minSum = Math.min(minSum, currentMin);

            maxAbsSum = Math.max(maxAbsSum, Math.max(Math.abs(maxSum), Math.abs(minSum)));
        }
        return maxAbsSum;
    }
}