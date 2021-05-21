class Solution {
	public int combinationSum3(int tar, int k,  int idx, List<Integer> smallAns, List<List<Integer>> res){
		if (k == 0 || tar == 0) {
            if (tar == 0 && k == 0) {
                List<Integer> base = new ArrayList<>(smallAns);
                res.add(base);
                return 1;
            }
            return 0;
        }

        int count = 0;
        for (int i = idx; i <= 9; i++) {
            if (tar - i >= 0) {
                smallAns.add(i);
                count += combinationSum3(tar - i, k - 1, i + 1, smallAns, res);
                smallAns.remove(smallAns.size() - 1);
            } else
                break;
        }

        return count;
	}

    public List<List<Integer>> combinationSum3(int k, int n) {
    	List<Integer> ans = new ArrayList<>();
    	List<List<Integer>> res = new ArrayList<>();

    	combinationSum3(n, k, 1, ans, res);

    	return res;    
    }
}