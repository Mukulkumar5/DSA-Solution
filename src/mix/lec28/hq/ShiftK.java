package mix.lec28.hq;

import java.util.*;


public class ShiftK {
    public static void main(String[] args) {
        List<Integer> listOfele1 = new ArrayList<>();
        listOfele1.add(1);
        listOfele1.add(2);
        listOfele1.add(3);
        listOfele1.add(4);
        listOfele1.add(5);
        listOfele1.add(6);
        listOfele1.add(7);
        int [] d = new int[]{1,2,3,4,5,6,7};
        //5671234
        System.out.println(getShiftKData(listOfele1, 3));
        System.out.println(Arrays.toString(getShiftKData(d, 3)));
    }

    private static int[] getShiftKData(int[] d, int k) {
        int [] f = new int[d.length];
        for (int i=0; i<d.length;i++){
           if(i+k<d.length) {
               f[i+k] = d[i];
           }else{
               int cKShift = (i + k)-d.length;
               f[cKShift] = d[i];
           }
       }
               return f;
    }


    private static List<Integer> getShiftKData(List<Integer> listOfele1, int k) {
        List<Integer> kShiftList = new ArrayList<>();
       int n = listOfele1.size();
       k = k%n;
       System.out.println("K"+ k +"n"+ n);
       if(k<0){
           k = k + n;
       }
       List<Integer> kShiftList1= new ArrayList<>(n);
       for(int i=0; i<n; i++){
           int sourceIndex = (i-k+n)%n;
           kShiftList1.add(listOfele1.get(sourceIndex));
       }
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));

        Collections.rotate(list, 3);

        System.out.println("Lamda rotation" + list);
       return kShiftList1;
    }
}
