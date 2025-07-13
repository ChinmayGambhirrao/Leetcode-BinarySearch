/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var topKFrequent = function(nums, k) {
    const frequencyMap = {};
    for(const num of nums) {
        frequencyMap[num] = (frequencyMap[num] || 0) + 1;
    }

    const sorted = Object.entries(frequencyMap).sort((a, b) => b[1] - a[1]);

    return sorted.slice(0,k).map(entry => parseInt(entry[0]));
};