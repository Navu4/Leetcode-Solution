class Solution {
	public int combinationSum(int[] arr, int tar, int idx, List<Integer> ans, List<List<Integer>> res){
		if(tar == 0){
			ArrayList<Integer> base = new ArrayList<>(ans);
			res.add(base);
			return 1;
		}
		int count = 0;
		for(int i = idx; i < arr.length; i++){
			if(tar - arr[i] >= 0){
				ans.add(arr[i]);
				count += combinationSum(arr, tar - arr[i], i + 1, ans, res);
				ans.remove(ans.size() - 1);	
			}
			
		}
		return count;	
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<Integer> ans = new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();

		combinationSum(candidates, target, 0, ans, res);

		return res;
	}
}