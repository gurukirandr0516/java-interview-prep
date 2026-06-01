package java8;

import java.util.*;
import java.util.stream.Collectors;

public class FindOccuranceCharacter {

    public static void main(String[] args){

        String str = "java";
        Map<Character, Long> count = str.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        System.out.println("count the occurance of character"+ count);

    }
}
