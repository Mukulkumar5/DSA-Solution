package mix.lecture32;

import java.util.Arrays;

public class TransposeMatrix {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(getTransposeMatrix(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
    }

    private static int[][] getTransposeMatrix(int[][] num) {
        int rowLen = num.length;
        int colNum = num[0].length;

        int [][]uNum = new int[colNum][rowLen];
        for(int i=0; i<rowLen;i++){
            for(int j=0;j<colNum;j++){
                uNum[j][i] = num[i][j];
            }
        }
        return uNum;
    }


}
