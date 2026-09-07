package mix.lec34;

import java.util.Arrays;

public class RotateByNinety {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(rotateByNinetyDegree(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
    }

    private static int [][] rotateByNinetyDegree(int[][] num) {
        // int len = num.length;
        for(int i=0; i<num.length;i++){
            for(int j=i+1;j<num[i].length;j++){
              int temp = num[i][j];
              num[i][j] = num[j][i];
              num[j][i] = temp;
            }
        }
        for(int i=0; i<num.length;i++){
            int left=0;
            int right = num.length-1;

            while(left<right){
                int temp = num[i][left];
                num[i][left] =  num[i][right];
                num[i][right] = temp;
                left++;
                right--;

            }
        }
        return num;
    }
}
