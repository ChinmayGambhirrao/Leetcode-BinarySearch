class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int totalLoad = 0, maxLoad = 0;
        for(int weight : weights){
            totalLoad += weight;
            maxLoad = Math.max(maxLoad, weight);
        }
        int left = maxLoad, right = totalLoad;

        while(left < right){
            int mid = (left + right) / 2;
            if(feasible(weights, mid, days)){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean feasible(int[] weights, int c, int days){
        int daysNeeded = 1, currentLoad = 0;
        for(int weight : weights){
            currentLoad += weight;

            if(currentLoad > c){
                daysNeeded++;
                currentLoad = weight;
            }
        }
        return daysNeeded <= days;
    }
}