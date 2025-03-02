class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] seen = new boolean[26];

        for(char c : sentence.toCharArray()) {
            if(c >= 'a' && c <= 'z') {
                seen[c - 'a'] = true;
            }
        }
        for(boolean letterSeen : seen) {
            if(!letterSeen) {
                return false;
            }
        }
        return true;
    }
}