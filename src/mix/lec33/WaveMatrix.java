package mix.lec33;

import java.util.ArrayList;
import java.util.List;

public class WaveMatrix {
    public static void main(String[] args) {
        System.out.println(getWaveMatrix(new int[][]{{1,2,3},{4,5,6},{7,8,9},{10,11,12}}));
    }
    private static List<Integer> getWaveMatrix(int[][] num) {
       List<Integer> listOfData = new ArrayList<>();
             for(int j=0; j<num[0].length;j++){
                 if((j & 1)==1){
                     for(int i=num.length-1;i>=0;i--){
                         listOfData.add(num[i][j]);
                     }
                 }else{
                     for(int i=0;i<num.length;i++){
                         listOfData.add(num[i][j]);
                     }
                 }

             }
        return listOfData;
    }
}
