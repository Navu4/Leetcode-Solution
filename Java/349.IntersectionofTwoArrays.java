class Solution {
    public int[] intersection(int[] arr1, int[] arr2){
       ArrayList<Integer> al = new ArrayList<>();
       
       int n = arr1.length, int m = arr2.length;
       int[] freq = new int[1001];

       for(int i = 0; i < n; i++){
            freq[i] = arr
       }
    }



    // O(n^3)
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> al = new ArrayList<>();
        
        for(int i = 0; i < nums1.length; i++){ // n
            for(int j= 0; j < nums2.length; j++){ // n
                if(nums1[i] == nums2[j] && !al.contains(nums1[i])){// n
                    al.add(nums1[i]);
                }
            }
        }
        System.out.println(al);
        int[] ans = new int[al.size()];
        for(int k = 0; k < al.size(); k++){
            ans[k] = al.get(k);
        }
        
        return ans;
    }
}