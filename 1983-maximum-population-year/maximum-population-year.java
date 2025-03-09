class Solution {
    public int maximumPopulation(int[][] logs) {
        Map<Integer, Integer> populationChanges = new HashMap<>();

        for(int[] log : logs) {
            int birth = log[0];
            int death = log[1];

            populationChanges.put(birth, populationChanges.getOrDefault(birth, 0) + 1);
            populationChanges.put(death, populationChanges.getOrDefault(death, 0) - 1);
        }
        List<Integer> years = new ArrayList<>(populationChanges.keySet());
        Collections.sort(years);

        int maxPopulation = 0;
        int currentPopulation = 0;
        int earliestYear = 0;

        for(int year : years) {
            currentPopulation += populationChanges.get(year);
            if(currentPopulation > maxPopulation) {
                maxPopulation = currentPopulation;
                earliestYear = year;
            }
        }
        return earliestYear;
    }
}