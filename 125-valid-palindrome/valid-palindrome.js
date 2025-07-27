/**
 * @param {string} s
 * @return {boolean}
 */
var isPalindrome = function(s) {
    const cleanedString = s.toLowerCase().replace(/[^a-z0-9]/g, '');

    let left = 0;
    let right = cleanedString.length - 1;

    while(left < right) {
        if(cleanedString[left] !== cleanedString[right]) {
            return false;
        }
        left++;
        right--;
    }
    return true;
};