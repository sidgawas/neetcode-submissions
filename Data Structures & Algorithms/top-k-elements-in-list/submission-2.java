class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var frequencyTable = new HashMap<Integer, Integer>();
        for(int num: nums) {
            frequencyTable.put(num, frequencyTable.getOrDefault(num, 0) + 1);
        }
        var minHeap = new PriorityQueue<Integer[]>(Comparator.comparingInt(p -> p[1]));
        for( var entry: frequencyTable.entrySet()) {
            var pair = new Integer[2];
            pair[0] = entry.getKey();
            pair[1] = entry.getValue();
            minHeap.add(pair);
            if(minHeap.size() > k) {
                minHeap.remove();
            }
        }
        int[] result = new int[minHeap.size()];
        for(int i = 0 ; i < result.length; i++) {
            result[i] = minHeap.remove()[0];
        }
        return result;
    }
}
