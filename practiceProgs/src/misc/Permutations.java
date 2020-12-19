package misc;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        permutations("ABCD");
    }

    private static List<String> permutations(String str) {
        System.out.println(str);
        List<String> permutations = new ArrayList<>();

        if(str == null) return null;
        if(str.equals("")) {
            permutations.add("");
            return permutations;
        }

        char first = str.charAt(0);
        String remaining = str.substring(1);
        List<String> words = permutations(remaining);
        for(String word : words) {
            for(int i = 0;i <= word.length(); i++) {
                String temp = word.substring(0, i) + first + word.substring(i);
                permutations.add(temp);
            }
        }
        System.out.println(":::" + permutations);
        return permutations;
    }
}
