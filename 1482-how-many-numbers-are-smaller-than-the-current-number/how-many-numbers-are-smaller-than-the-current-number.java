class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);

        HashMap<Integer, Integer> countMap = new HashMap<>();
        for(int i = 0; i < sortedNums.length; i++) {
            if(!countMap.containsKey(sortedNums[i])) {
                countMap.put(sortedNums[i], i);
            }
        }

        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            result[i] = countMap.get(nums[i]);
        }
        return result;
    }
}