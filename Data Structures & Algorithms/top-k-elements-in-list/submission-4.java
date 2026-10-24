class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var frequencyTable = new HashMap<Integer, Integer>();
        for(int num: nums) {
            frequencyTable.put(num, frequencyTable.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(frequencyTable::get)
        );

        for (int num : frequencyTable.keySet()) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] result = new int[minHeap.size()];
        for(int i = 0 ; i < result.length; i++) {
            result[i] = minHeap.remove();
        }
        return result;
    }
}
