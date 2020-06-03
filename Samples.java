import java.util.*;
import java.util.stream.*;

/**
 * Write a description of class Samples here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Samples {
    public Samples() {
         List<Integer> nums = List.of(1,2,3,4,3,6,3,8,9);
         Set odds = nums.stream()
                         .filter(num -> num % 2 == 1)
                         .collect(Collectors.toSet());
         System.out.println(odds);
         
         List<String> chars = List.of("a", "B", "c", "D", "e");
         String charsLower = chars.stream()
                         .filter(ch -> ch.charAt(0) >= 'a')
                         .collect(Collectors.joining(", "));
         System.out.println(charsLower); 
    }
}
