class Solution {

	public int combine(int n, int k, int idx, List<Integer> ans, List<List<Integer>> res){
		if(k == 0){
			List<Integer> base = new ArrayList<>(ans);
			res.add(base);
			return 1;
		}
		int count = 0;
		for(int i = idx; i <= n; i++){
			ans.add(i);
			count += combine(n, k - 1, i + 1, ans, res);
			ans.remove(ans.size() - 1);
		}
		return count;
	}

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        combine(n, k, 1, ans, res);

        return res;
    }
}