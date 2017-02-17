package algorithms;

import util.LogUtils;

import java.util.Arrays;

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

        LogUtils.printArray(arr);
        return arr[m-1][n-1];
    }
}
