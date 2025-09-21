/**
 * @param {string} s
 * @param {string} t
 * @return {string}
 */
var minWindow = function(s, t) {
    if(s.length < t.length) return "";

    const tFreq = {};
    for(const char of t) {
        tFreq[char] = (tFreq[char] || 0) + 1;
    }

    let left = 0;
    let minLen = Infinity;
    let minStart = 0;
    let count = 0;

    for(let right = 0; right < s.length; right++) {
        const charRight = s[right];
        if(tFreq[charRight] !== undefined) {
            tFreq[charRight]--;
            if(tFreq[charRight] >= 0) {
                count++;
            }
        }

        while(count === t.length) {
            if(right - left + 1 < minLen) {
                minLen = right - left + 1;
                minStart = left;
            }
            const charLeft = s[left];
            if(tFreq[charLeft] !== undefined) {
                tFreq[charLeft]++;
                if(tFreq[charLeft] > 0) {
                    count--;
                }
            }
            left++;
        }
    }
    return minLen === Infinity ? "" : s.substring(minStart, minStart + minLen)
};