class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> ll= new ArrayList<>();
        List<List<Integer>> ans= new ArrayList<>();
        Coin_Permutation(candidates,target,0,ll,0, ans);
        return ans;
    }

    public static void Coin_Permutation(int []candidates, int target,int amount, List<Integer>ll, int idx,List<List<Integer>> ans ) {
		if(amount==target) {
            ans.add( new ArrayList<>(ll));  //vhapar new arraylist main dalna pada as ans.add(ll) is wrong cuz ll's elements are being removed so end result is giving null 2d list so that why we add a COPY of ll into ans
			return;
		}
		
		for(int i=idx; i<candidates.length  ; i++) {
			if(amount<=target) {
                ll.add(candidates[i]);
				Coin_Permutation(candidates, target, amount+candidates[i], ll,i, ans);
                ll.remove(ll.size()-1);
			}
			
		}
}
}