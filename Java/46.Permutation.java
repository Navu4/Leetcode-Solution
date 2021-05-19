import java.io.*;
import java.util.*;

public class Permutation46{
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args){
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }    
        System.out.println(permute(arr));
    }  


    // Brute Force Way ========================================================================================================
    // Foundation Way 
    public static void appendIntegerArrayList(ArrayList<Integer> arr, int data,ArrayList<ArrayList<Integer>> ans){
        for(int i = arr.size(); i >= 0; i--){
            arr.add(i,data);
            
            ans.add((new ArrayList<Integer>(arr)));

            arr.remove(i);
        }
        
    }

    public static ArrayList<ArrayList<Integer>> permute(int[] arr) {
        if(arr.length == 0) return new ArrayList<ArrayList<Integer>>();

        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

        ans.add((new ArrayList<Integer>()));
        
        for(int i = 0; i < arr.length; i++){
            int data = arr[i];


            ArrayList<ArrayList<Integer>> smallAns = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> s : ans){
                appendIntegerArrayList(s, data, smallAns);
            }
            
            ans = smallAns;
        }
        
        return ans;
    }

    // =================================================================================================================

    // Combination ==== IMPORTANT and OPTIMIZED WAY 
    public static int permutation46(int[] arr, List<Integer> ans , List<List<Integer>> res){
        if(idx == arr.length){
            List<Integer> base = new ArrayList<>(ans);
            res.add(base);
            return 1;
        }

        int count = 0;
        for(int i = 0; i < arr.length; i++){

            if(arr[i] > 0){
                arr[i] = - arr[i];
                ans.add(arr[i]);

                count += permutation46(arr, ans, res);
                
                ans.remove(ans.size() - 1);
                arr[i] = - arr[i];
            }
        }
        return count;
    }


    public static List<List<Integer>> permutation_46(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        permutation46I(nums, 0, )
        return res;
    }

}
