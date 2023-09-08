class Solution {
    long[] preSum;
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        preSum = new long[n+1];
        for (int i = 0; i < n; i++)
            preSum[i + 1] = preSum[i] + nums[i];

        int ans = 0;
        for (int i = 0; i < n; i++)
            ans = Math.max(ans, count(nums, k, i)); //checking each element for largest window
        return ans;
    }
    long getSum(int left, int right) {  // left, right inclusive
        return preSum[right + 1] - preSum[left];
    }
    // Count frequency of `nums[index]` if we make other elements equal to `nums[index]`
    int count(int[] nums, int k, int index) {
        int left = 0, right = index, res = index;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long s = getSum(mid, index - 1); // get sum of(nums[mid], nums[mid + 1]...nums[index - 1])
            if (s + k >= (long)(index - mid) * nums[index]) { // Found an answer -> Try to find a better answer in the left side
                res = mid; // save best answer so far
                right = mid - 1; // increasing the window size
            } else {
                left = mid + 1; // decreasing the window size  
            }
        }
        return index - res + 1;
    }
}