/**
 * @param {number[]} nums
 * @return {boolean}
 */
var containsDuplicate = function(nums) {
    const seenSet = new Set();

    for(let num of nums) {
        if(seenSet.has(num)) {
            return true;
        }
        seenSet.add(num)
    }
    return false;
};