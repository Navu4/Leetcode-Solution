import java.util.Scanner;
import java.util.ArrayList;

public class PalindromicPair {
    public static Scanner scn = new Scanner(System.in);

    public static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
        }
        return true;
    }

    public static ArrayList<ArrayList<Integer>> palindromePairs(String[] words) {
        StringBuilder sb;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int n = words.length;
        int i = 0;
        int j = n - 1;
        while (i < n && j >= 0) {
            sb = new StringBuilder();

            sb.append(words[i] + words[j]);
            if (isPalindrome(sb.toString())) {
                ArrayList<Integer> smallAns = new ArrayList<>();
                smallAns.add(i, j);
                ans.add(smallAns);
            }

            sb = new StringBuilder();

            sb.append(words[j] + words[i]);
            if (isPalindrome(sb.toString())) {
                ArrayList<Integer> smallAns = new ArrayList<>();
                smallAns.add(j, i);
                ans.add(smallAns);
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        String[] arr = { "abcd", "dcba", "lls", "s", "sssll" };
        System.out.println(palindromePairs(arr));
    }
}