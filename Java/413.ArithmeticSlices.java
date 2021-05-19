import java.util.*;;

public class ArithmeticSlices413 {
    public static Scanner scn = new Scanner(System.in);

    // AC : Arithmetic Calculation
    public static boolean AC(int a, int b, int c) {
        return b - a == c - b;
    }

    public static void print(int[] dp) {
        for (int ele : dp) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static int arithmeticSlices(int[] arr, int[] dp) {
        int n = arr.length;
        int i = 0, j = 2;

        for (; j < n; i++, j++) {
            if (AC(arr[i], arr[i + 1], arr[j])) {
                dp[i] = arr[i + 1] - arr[i];
            } else {
                dp[i] = (int)1e9;
            }
        }

        int count = 0;
        if (dp[0] != (int)1e9) {
            count++;
        }
        for (int k = 1; k < dp.length; k++) {
            if (dp[k] != (int)1e9) {
                count++;
                if (dp[k - 1] == dp[k])
                    count++;
            }
        }
        print(dp);
        return count;
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3)
            return 0;

        int[] dp = new int[n - 2];
        Arrays.fill(dp, (int)1e9);
        return arithmeticSlices(nums, dp);
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }


        System.out.println(numberOfArithmeticSlices(arr));
    }
}
