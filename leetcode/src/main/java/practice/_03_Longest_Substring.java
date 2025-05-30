package practice;

import java.util.HashMap;
import java.util.Map;

public class _03_Longest_Substring {

    public static void main(String[]args){
        _03_Longest_Substring cl = new _03_Longest_Substring();

        System.out.println(cl.lengthOfLongestSubstring("abcabcbb") == 3);
        System.out.println(cl.lengthOfLongestSubstring("bbbbb") == 1);
        System.out.println(cl.lengthOfLongestSubstring("pwwkew") == 3);
        System.out.println(cl.lengthOfLongestSubstring("") == 0);
        System.out.println(cl.lengthOfLongestSubstring(" ") == 1);
        System.out.println(cl.lengthOfLongestSubstring("dvdf") == 3);
        System.out.println(cl.lengthOfLongestSubstring("abcdeafgh") == 8);
        System.out.println(cl.lengthOfLongestSubstring("abcdeaafgh") == 5);
        System.out.println(cl.lengthOfLongestSubstring("abcdeaafgah") == 5);
        System.out.println(cl.lengthOfLongestSubstring("abcdeaafghijklmno") == 11);
    }

    public int lengthOfLongestSubstring(String s) {
        System.out.print(s + " :::: ");

        Map<Character, Integer> charIndexes = new HashMap<>();
        int current = 1, result = 0, lowestIndex = 0;

        //p w w k e w
        //1 2 3 4 5 6

        //a b c d e a f g h i  a
        //1 2 3 4 5 6 7 8 9 10 11

        //a b c d e a a f g h
        //1 2 3 4 5 6 7 8 9 10

        while (current <= s.length()){
            char currentChar = s.charAt(current - 1);

            if (charIndexes.containsKey(currentChar)){
                lowestIndex = Math.max(charIndexes.get(currentChar), lowestIndex);
            }

            charIndexes.put(currentChar, current);
            result = Math.max(result, current - lowestIndex);
            current++;
        }
        System.out.print(result + " :::: ");
        return result;
    }
}
