package mix.lec28.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseArray {
    public static void main(String[] args) {
        List<Integer> listOfele1 = new ArrayList<>();
        listOfele1.add(1);
        listOfele1.add(2);
        listOfele1.add(3);
        listOfele1.add(4);
        System.out.println(getReverse(listOfele1));

    }

    public static List<Integer> getReverse(List<Integer> reverseEle){
      Collections.reverse(reverseEle);
      return reverseEle;
    }
}
