class Solution {
	String[] codes = {
 "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	public List<String> letterCombinations(String str, int idx){
        if(idx == str.length()){
            List<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
		List<String> smallAns = letterCombinations(str, idx + 1);
		List<String> myAns = new ArrayList<>();

		char ch = str.charAt(idx);
		String code = codes[ch - '0'];

		for(int i = 0; i < code.length(); i++){
			char c = code.charAt(i);

			for(String s : smallAns){
				myAns.add(c + s);
			}
		}

		return myAns;
	}

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return new ArrayList<>();
        return letterCombinations(digits, 0);
    }
}