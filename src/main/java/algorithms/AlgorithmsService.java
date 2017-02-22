package algorithms;

import java.util.ArrayList;

import static util.LogUtils.info;
import static util.LogUtils.printArray;

public class AlgorithmsService {

    /**
     * DFS - not effective here
    * */
    public static int countPathsRec(int m, int n){
        if (m == 1 || n == 1) return 1;

        return countPathsRec(m-1, n) + countPathsRec(m, n-1);
    }

    public int countPaths(int m, int n){
        int[][] arr = new int[m][n];
        arr[0][0] = 1;

        for (int i = 0; i < n; i++) {
            arr[0][i] = 1;
        }

        for (int i = 0; i < m; i++) {
            arr[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }

        printArray(arr);
        return arr[m-1][n-1];
    }

    public ArrayList<String> combParenthesis(int pairs) {

        ArrayList<String> combinations = new ArrayList<>();

        if (pairs > 0)
            combParenthesisHelper(combinations, "", pairs, pairs);

        return combinations;
    }

    private void combParenthesisHelper(ArrayList<String> combinations, String combo, int left, int right) {

        info(String.format("left: %s | right: %s | combo: %s", left, right, combo));

        if (left > right) {
            return;
        }

        if (left == 0 && right == 0) {
            combinations.add(combo);
            info(combo);
        }

        if (left > 0) {
            combParenthesisHelper(combinations, combo + "(", left - 1, right);
        }

        if (right > 0) {
            combParenthesisHelper(combinations, combo + ")", left, right - 1);
        }
    }
}
