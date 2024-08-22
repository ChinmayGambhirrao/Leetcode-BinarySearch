class Solution {
    public int findComplement(int num) {
        if(num == 0) return 1;

        int lengthOfBit = Integer.toBinaryString(num).length();

        // We are doing XOR of the num and making it as a mask of the number for flipping XOR will make 0 to 1 or 1 to 0
        int mask = (1 << lengthOfBit) - 1;

        return num ^ mask;
    }
}