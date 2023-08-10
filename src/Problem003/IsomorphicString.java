package Problem003;

/*
* Problem 3
*
* Given two strings s and t, determine if they are isomorphic. Two strings are
* isomorphic if the characters in s can be replaced to get t.
*
* For example,"egg" and "add" are isomorphic, "foo" and "bar" are not.
*
* */

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {

    public boolean isIsomorphic (String s1, String s2) {

        if(s1 == null || s2 == null) {
            throw new IllegalArgumentException("Strings invalidos.");
        }

        if(s1.length() != s2.length()) {
            return false;
        }

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        Map<Character, Character> dictionary = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {

            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (dictionary.containsKey(c1)) {

                Character c = dictionary.get(c1);

                if(c != c2)
                    return false;

            } else {
                dictionary.put(c1, c2);
                dictionary.put(c2, c1);
            }
        }

        return true;
    }

}
