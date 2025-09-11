/**
 * @param {number} target
 * @param {number[]} nums
 * @return {number}
 */
var minSubArrayLen = function(target, nums) {
    let left = 0;
    let minLen = Infinity;
    let windowSum = 0;

    for(let right = 0; right < nums.length; right++) {
        windowSum += nums[right];
        while(windowSum >= target) {
            minLen = Math.min(minLen, right - left + 1);
            windowSum -= nums[left];
            left++;
        }
    }
    return minLen === Infinity ? 0 : minLen;
};