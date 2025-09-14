/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var characterReplacement = function(s, k) {
    let left = 0;
    let maxLen = 0;
    let maxFreq = 0;
    const freqMap = {};

    for(let right = 0; right < s.length; right++) {
        const char = s[right];
        freqMap[char] = (freqMap[char] || 0) + 1;

        maxFreq = Math.max(maxFreq, freqMap[char]);

        const windowSize = right - left + 1;
        if(windowSize - maxFreq > k) {
            freqMap[s[left]]--;
            left++;
        }
        maxLen = Math.max(maxLen, right - left + 1);
    }
    return maxLen;
};