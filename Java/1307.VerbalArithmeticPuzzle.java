class Solution {
    public static int convertStringToNumber(String str, int[] map) {
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            res = res * 10 + map[ch - 'A']; 
        }

        return res;
    }
    
    public int crypto(String[] words, String res, String str, int idx, int[] map, boolean[] used){
        // crypto(words, res, str, 0 , map, used)
        if(idx == str.length()){
                
            int sumOfWords = 0;
            for(String s : words){
                sumOfWords += convertStringToNumber(s, map);
            }
            
            int resNo = convertStringToNumber(res, map);
            
            if(sumOfWords == resNo){
                return 1;
            }
            
            return 0;        
        }
        
        int count = 0;
        char ch = str.charAt(idx);
        for(int i = 0; i <= 9; i++){
            if(!used[i]){
                used[i] = true;
                map[(int)(ch - 'A')] = i;
                
                count += crypto(words, res, str, idx + 1, map, used);
                
                used[i] = false;
            }
        }
        return count;
    }
    
    public boolean crypto(String[] words, String res){
        int[] freq = new int[26];
        for(String s : words){
            for(int i = 0; i < s.length(); i++){
                char ch = s.charAt(i);
                freq[(int)(ch - 'A')]++;
            }
        }
        
        String str = "";
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0)
                str += (char) (i + 'A');
        }
        
        int[] map = new int[26];
        boolean[] used = new boolean[10];
        
        Arrays.fill(map, -1);
        // int ans =
        
        // for(int i = 0; i < freq.length; i++){
        //     System.out.print(freq[i] +  " ");
        // }
        int ans = crypto(words, res, str, 0 , map, used);
        // return true;
        return ans == 0 ? false : true;
    }
    
    
    public boolean isSolvable(String[] words, String result) {
        System.out.println(crypto(words, result));
    }
}