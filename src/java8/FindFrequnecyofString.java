package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindFrequnecyofString {

    public static void main(String[] args){

        List<String> names= Arrays.asList("Java","Spring","java","RestAPI");

       Map<String,Long> frequency= names.stream().map(String::toUpperCase).collect(Collectors.groupingBy(s-> s,Collectors.counting()));

       System.out.println(frequency);
    }
}
