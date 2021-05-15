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
}
