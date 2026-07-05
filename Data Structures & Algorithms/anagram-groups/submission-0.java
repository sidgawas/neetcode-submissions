class Solution {
    public List<List<String>> groupAnagrams(final String[] strs) {
        HashMap<String, List<String>> groups = new HashMap<>();
        for (String s : strs) {
            int[] charCount = new int[26];
            for (char c : s.toCharArray()) {
                int index = Character.toLowerCase(c) - 'a';
                charCount[index]++;
            }
            StringBuilder key = new StringBuilder();
            for (int j = 0; j < charCount.length; j++) {
                int count = charCount[j];
                if (count > 0) {
                    key.append('a' + j);
                    key.append(count);
                }
            }
            String keyStr = key.toString();
            List<String> group = groups.getOrDefault(keyStr, new ArrayList<>());
            group.add(s);
            groups.put(keyStr, group);
        }
        return groups.values().stream().toList();
    }
}
