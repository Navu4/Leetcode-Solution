class Solution {

    // USing Combination and Backtracking 
    // Using boolean array to block elements in WIDTH
    public int combinationSum2(int[] arr, int tar, int idx, List<Integer> ans, List<List<Integer>> res){
        if(tar == 0){
            List<Integer> base = new ArrayList<>(ans);
            res.add(base);
            return 1;
        }
        
        int count = 0;
        boolean[] vis = new boolean[51];  // Imp point
        for(int i = idx; i < arr.length; i++){
            if(!vis[arr[i]] && tar - arr[i] >= 0){
                ans.add(arr[i]);
                vis[arr[i]] = true;

                count += combinationSum2(arr, tar - arr[i], i + 1, ans, res);
                
                ans.remove(ans.size() - 1);                
            }

        }
        return count;
    }

    // Using Prev to BLock Elements in Width (This can be apply Only If array is Sorted)
    public int combinationSum2(int[] arr, int tar, int idx, List<Integer> ans, List<List<Integer>> res){
        if(tar == 0){
            List<Integer> base = new ArrayList<>(ans);
            res.add(base);
            return 1;
        }
        
        int count = 0;
        // boolean[] vis = new boolean[51];  // Imp point
        int prev = -1; // Contraints ke according vali deni hai prev ko 
        for(int i = idx; i < arr.length; i++){
            if(prev != arr[i] && tar - arr[i] >= 0){
                ans.add(arr[i]);
               
                count += combinationSum2(arr, tar - arr[i], i + 1, ans, res);
                
                ans.remove(ans.size() - 1);                
            }
            if(tar - arr[i] < 0){
                break;          // If array sorted hai aur koi element se value target se choti hai aage check krne ka koi fyda hi ni hai 
            }
            prev = arr[i];

        }
        return count;
    }
    

    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        
        Arrays.sort(candidates);
        
        combinationSum2(candidates, target, 0, ans, res);
        
        return res;
    }
}