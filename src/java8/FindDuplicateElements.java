package java8;

import java.util.*;
import java.util.stream.Collectors;

public class FindDuplicateElements {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 2, 5, 3, 6, 1);

        Set<Integer> uniqueElements = new HashSet<>();

        Set<Integer> duplicates = numbers.stream()
                .filter(n->!uniqueElements.add(n))
                        .collect(Collectors.toSet());

        System.out.println("Duplicate Elements: " + duplicates);
    }
}