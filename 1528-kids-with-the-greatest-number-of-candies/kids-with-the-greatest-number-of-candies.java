class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
        for(int i = 0; i < candies.length; i++) {
            if(candies[i] > maxCandies) {
                maxCandies = candies[i];
            }
        }
        List<Boolean> res = new ArrayList<>();
        for(int i = 0; i < candies.length; i++) {
            res.add(candies[i] + extraCandies >= maxCandies);
        }
        return res;
    }
}