package JavaCode;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicateElements {

    public static Set<Integer> findDuplicates(int[] arr){
        Set<Integer> seen= new HashSet<>();
        Set<Integer> dup=new HashSet<>();
        for (int n: arr){
            if(!seen.add(n)){
                dup.add(n);
            }
        }
        return dup;
    }

    public static void main(String[] args){
        int [] arr={1,1,2,3,3,4};
       System.out.println("Duplicate elements in Array :" +findDuplicates(arr));
    }
}
