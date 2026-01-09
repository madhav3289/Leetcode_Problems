class Solution {

 public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        Map<String, List<String>> memo = new HashMap<>();
        List<String> res = helper(words, groups, words.length - 1, "", Integer.MAX_VALUE, memo);
        Collections.reverse(res);
        return res;
    }


    private List<String> helper(String[] words, int[] groups, int idx, String lastWord, int lastGroup, Map<String, List<String>> memo) {

        if (idx < 0) {
            return new ArrayList<>();
        }

        if (memo.containsKey(lastWord)) {
            return memo.get(lastWord);
        }

        List<String> withList = new ArrayList<>();

        if ((lastGroup == Integer.MAX_VALUE || groups[idx] != lastGroup) && (lastWord.isEmpty() || distance(lastWord, words[idx]))) {
            withList.add(words[idx]);
            List<String> res = helper(words, groups, idx - 1, words[idx], groups[idx], memo);
            withList.addAll(res);
        }
        List<String> res2 = helper(words, groups, idx - 1, lastWord, lastGroup, memo);

        List<String> withoutList = new ArrayList<>(res2);

        if (withoutList.size() <= withList.size()) {
            memo.put(lastWord, withList);
            return withList;
        }

        memo.put(lastWord, withoutList);

        return withoutList;

    }

    private boolean distance(String lastWord, String word) {
        if (lastWord.length() != word.length()) {
            return false;
        }
        int exceptions = 0;
        for (int i = 0; i < word.length(); i++) {
            if (lastWord.charAt(i) != word.charAt(i)) {
                exceptions++;
            }
        }
        return exceptions == 1;
    }

}