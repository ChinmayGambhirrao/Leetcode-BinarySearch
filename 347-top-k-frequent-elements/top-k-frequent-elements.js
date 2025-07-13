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

    const heap = new PriorityQueue((a, b) => a[1] - b[1]); // min heap
    for(const [num, freq] of Object.entries(frequencyMap)) {
        heap.push([num, freq]);

        if(heap.size() > k) heap.pop();
    }

    return heap.toArray().map(entry => parseInt(entry[0]));
};