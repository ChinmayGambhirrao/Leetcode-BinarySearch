class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int prevRob = 0;
        int prevNotRob = 0;

        for(int num : nums) {
            int currentRob = prevNotRob + num;

            int currentNotRob = Math.max(prevRob, prevNotRob);

            prevRob = currentRob;
            prevNotRob = currentNotRob;
        }

        return Math.max(prevRob, prevNotRob);
    }
}