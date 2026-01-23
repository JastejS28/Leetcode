class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // REQUIRED
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, target, 0, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int[] candidates, int target, int idx,
                           int sum, List<Integer> path,
                           List<List<Integer>> ans) {

        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {

            // SKIP DUPLICATES (CORE OF LC-40)
            if (i > idx && candidates[i] == candidates[i - 1]) continue;

            // PRUNING
            if (sum + candidates[i] > target) break;

            path.add(candidates[i]);
            backtrack(candidates, target, i + 1, sum + candidates[i], path, ans);
            path.remove(path.size() - 1);
        }
    }
}
