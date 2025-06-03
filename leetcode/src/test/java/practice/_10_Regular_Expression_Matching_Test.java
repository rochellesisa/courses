package practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _10_Regular_Expression_Matching_Test {

    private _10_Regular_Expression_Matching cl = new _10_Regular_Expression_Matching();

    @Test
    public void actualCharactersInMatcher_shouldBeEqual(){
        Assertions.assertFalse(cl.isMatch("aaaa", "a"));
        Assertions.assertTrue(cl.isMatch("aabb", "aabb"));
    }

    @Test
    public void matcherHasPeriod_allowReplacementOfPeriodWithAnyCharacter(){
        Assertions.assertTrue(cl.isMatch("aa", "a."));
        Assertions.assertTrue(cl.isMatch("cd", ".."));
        Assertions.assertTrue(cl.isMatch("ap", ".p"));
        Assertions.assertFalse(cl.isMatch("ac", ".p"));
        Assertions.assertFalse(cl.isMatch("abc", ".."));
    }

    @Test
    public void matcherHasWildcard_allowAnyCharacters(){
        Assertions.assertTrue(cl.isMatch("abcdefghijkl", "*"));
        Assertions.assertTrue(cl.isMatch("abcdefghijkl", "abc*"));
        Assertions.assertTrue(cl.isMatch("abcdefghijkl", "*jkl"));
//        Assertions.assertTrue(cl.isMatch("abcdefghijkl", "abc*jkl"));
//        Assertions.assertTrue(cl.isMatch("abcdefabcabc", "abc*abc"));
//        Assertions.assertTrue(cl.isMatch("abcdefghijkl", "ab*g*jkl"));
//        Assertions.assertFalse(cl.isMatch("abcdefghi", "abc*jkl"));
//        Assertions.assertTrue(cl.isMatch("abcdjklmnop", "abc*jkl*"));
//        Assertions.assertTrue(cl.isMatch("abcdjklmnop", "*cd*lmnop"));
//        Assertions.assertTrue(cl.isMatch("abcdjklmnop", "*cd*lmn*"));
//        Assertions.assertFalse(cl.isMatch("defghi", "abc*jkl"));
    }


}
