class Solution {
    public int[] applyOperations(int[] nums) {
        int writeIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i < nums.length - 1 && nums[i] == nums[i + 1] && nums[i] != 0) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
            if(nums[i] != 0) {
                if(i != writeIndex) {
                    int temp = nums[i];
                    nums[i] = nums[writeIndex];
                    nums[writeIndex] = temp;
                }
                writeIndex++;
            }
        }
        return nums;
    }
}