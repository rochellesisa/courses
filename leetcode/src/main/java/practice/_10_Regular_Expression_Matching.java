package practice;

public class _10_Regular_Expression_Matching {

    public boolean isMatch(String s, String p) {
        System.out.println("Input=" + s + ", Pattern=" + p);
//        if (!p.contains("*")){
//            return nonWildcardMatching(s, p);
//        } else {
        boolean match = true;
        StringBuilder patternToMatch = new StringBuilder();

        int startingIndexForChecking = 0;
        for (int i = 0; i < p.length() && match; i++){

            char patternChar = p.charAt(i);

            if (patternChar == '.'){
                System.out.println("Matcher=" + patternChar + ", StringIndex=" + startingIndexForChecking + ", StringChar=" + s.charAt(startingIndexForChecking));
                startingIndexForChecking++;
            } else if (patternChar == '*'){ //means wildcard is not the last character in the pattern
                if (i != p.length() - 1){
                    String nextNonWildcard = getSeriesOfNextNonWildcard(p, i);
                    System.out.println("NextNonWildcard=" + nextNonWildcard);
                } else {
                    startingIndexForChecking = s.length();
                }
                //get series of next non-wildcard
                // if there is a non-wildcard, get series of those non-wildcard and do lastIndexOf. If -1, match = false else startingIndexForChecking = lastIndex+= length of series
            } else {
                System.out.println("Matcher=" + patternChar + ", StringIndex=" + startingIndexForChecking + ", StringChar=" + s.charAt(startingIndexForChecking));
                match = patternChar == s.charAt(startingIndexForChecking);
                startingIndexForChecking++;
            }

        }

        boolean entireStringChecked = startingIndexForChecking == s.length();
        System.out.println();

        return entireStringChecked && match;
    }

    private boolean nonWildcardMatching(String s, String p){
        if (s.length() != p.length())
            return false;
        for (int i = 0; i < s.length(); i++){
            char matcher = p.charAt(i);
            char input = s.charAt(i);
            if (matcher == '.'){
                continue;
            } else if (matcher != input){
                return false;
            }
        }
        return true;
    }


    private String getSeriesOfNextNonWildcard (String p, int currentWildcardIndex){
        StringBuilder series = new StringBuilder();
        int startingIndex = currentWildcardIndex + 1;
        while (startingIndex < p.length()){
            char c = p.charAt(startingIndex);
            if (c != '*')
                series.append(c);
            startingIndex++;
        }
        return series.toString();
    }
}