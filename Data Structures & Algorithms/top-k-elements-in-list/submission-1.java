class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var result = new LinkedList<Integer>();
        var mapOfNumberToFrequency = new HashMap<Integer, Integer>();
        var mapOfFrequencyToNumber = new TreeMap<Integer, HashSet<Integer>>();
        for (int num : nums) {
            var currentCount = mapOfNumberToFrequency.getOrDefault(num, 0);
            var currentListOfFrequency = mapOfFrequencyToNumber.getOrDefault(currentCount + 1, new HashSet<>());
            if (currentListOfFrequency.isEmpty()) {
                currentListOfFrequency.add(num);
                mapOfFrequencyToNumber.put(currentCount + 1, currentListOfFrequency);
            } else {
                currentListOfFrequency.add(num);
            }
            currentListOfFrequency = mapOfFrequencyToNumber.getOrDefault(currentCount, new HashSet<>());
            currentListOfFrequency.remove(num);
            if (currentListOfFrequency.isEmpty()) {
                mapOfFrequencyToNumber.remove(currentCount);
            }
            mapOfNumberToFrequency.put(num, currentCount + 1);
        }
        var highestFrequency = mapOfFrequencyToNumber.lastKey();
        var highestSet = mapOfFrequencyToNumber.get(highestFrequency);
        int i = 0;
        while(k != 0) {
            if (k  > highestSet.size()) {
                result.addAll(highestSet);
                k = k - highestSet.size();
                mapOfFrequencyToNumber.remove(highestFrequency);
                highestFrequency = mapOfFrequencyToNumber.lastKey();
                highestSet = mapOfFrequencyToNumber.get(highestFrequency);
            } else {
                result.addAll(highestSet.stream().toList().subList(0, k));
                k = 0;
            }
        }
        int[] resultArray = new int[result.size()];
        for(int j = 0; j< resultArray.length; j++) {
            resultArray[j] = result.get(j);
        }
        return resultArray;
    }
}
