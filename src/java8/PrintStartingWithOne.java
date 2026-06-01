package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrintStartingWithOne {

    public static void main(String[] args) {

        List<Integer> num=List.of(1,2,3,11,12,3,4);

        List<Integer> result= num.stream().filter(n->String.valueOf(n).startsWith("1"))
                              .collect(Collectors.toList());
        System.out.println(result);
    }
}
