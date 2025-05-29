package src.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

//        Set<Character> seen = new HashSet<>();
//        int left = 0, maxLen = 0;
//
//        for (int right = 0; right < s.length(); right++) {
//            char curr = s.charAt(right);
//
//            while (seen.contains(curr)) {
//                seen.remove(s.charAt(left++)); // Shrink the window
//            }
//
//            seen.add(curr);
//            maxLen = Math.max(maxLen, right - left + 1);
//        }
//
//        return maxLen;
//        Set<Character> nonRepeating = new HashSet<>();
//        int longest = 0, read = 0, remove = 0;
//
//        //abcdeafgh  --> 8
//        //abcdeaafgh --> 5
//        //abcdeaafgah --> 5
//        //abcdeaafghijklmno --> 11
//        for (int i = 0; i < s.length(); i++){
//            char curr = s.charAt(i);
//            if (nonRepeating.contains(curr)){
//                remove++;
//                read = 0;
//            } else {
//                nonRepeating.add(curr);
//                read++;
//                remove = 0;
//            }
//
//            longest = Math.max(longest, read-remove);
//        }
//
//        return longest;

//
//        List<Character> longestNonRepeating = new ArrayList<>();
//        List<Character> currentNonRepeating = new ArrayList<>();
//
//        for (int i = 0; i < s.length(); i++){
//            char curr = s.charAt(i);
//            if (currentNonRepeating.contains(curr)){
//                s = s.substring(s.indexOf(curr) + 1, s.length());
//                i = -1;
//                currentNonRepeating = new ArrayList<>();
//            } else {
//                currentNonRepeating.add(curr);
//            }
//
//            if (currentNonRepeating.size() > longestNonRepeating.size())
//                longestNonRepeating = currentNonRepeating;
//        }
//        System.out.println(longestNonRepeating.toString());
//        return longestNonRepeating.size();
    }


    private List<Character> getLargerList(List<Character> l1, List<Character> l2){
        return l1.size() >= l2.size() ? l1 : l2;
    }



}
