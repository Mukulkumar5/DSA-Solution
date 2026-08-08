package mix.lec28.practice;

import java.util.ArrayList;
import java.util.List;

public class Shift {
    public static void main(String[] args) {
        List<Integer> listOfele1 = new ArrayList<>();
        listOfele1.add(1);
        listOfele1.add(2);
        listOfele1.add(3);
        listOfele1.add(4);
        System.out.println(getShiftData(listOfele1));
    }

    private static List<Integer> getShiftData(List<Integer> listOfele1) {
        int gTemp = listOfele1.get(0);
        for(int i=0; i<listOfele1.size();i++){
            if(i== listOfele1.size()-1){
                listOfele1.set(0, gTemp);
               return listOfele1;
            }
            int temp = listOfele1.get(i+1);
            listOfele1.set(i+1, gTemp);
            gTemp = temp;
        }
        return null;
    }
}
