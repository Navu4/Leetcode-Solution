class Solution {


	// DS
    public boolean isSubsequence(String s, String t) {
        char sArray[] = s.toCharArray();
        char tArray[] = t.toCharArray();
        int count = 0;
        int k = 0;
        for(int i = 0; i < tArray.length; i++){
            if(k == sArray.length)
                break;
            if(sArray[k] == tArray[i]){
                k++;
                count++;
            }
        }
        return count == sArray.length;
    }
}