/**
 * @param {number[]} nums
 * @param {number} k
 * @return {boolean}
 */
var containsNearbyDuplicate = function(nums, k) {
    const windowSet = new Set();
    let left = 0;

    for(let right = 0; right < nums.length; right++) {
        if(right - left > k) {
            windowSet.delete(nums[left]);
            left++;
        }
        if(windowSet.has(nums[right])) {
            return true;
        }
        windowSet.add(nums[right]);
    }
    return false;
};