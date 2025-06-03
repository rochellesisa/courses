package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _06_Zigzag_Conversion {

    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;

        Map<Integer, List<Character>> zigzag = init(numRows);

        int row = 1;
        boolean isDownDirection = true;
        for (int i = 0; i < s.length(); i++){
            char letter = s.charAt(i);
            System.out.println("letter=" + letter + ", row=" + row);
            zigzag.get(row).add(letter);

            if (row == numRows){
                isDownDirection = false;
            } else if (row == 1) {
                isDownDirection = true;
            }

            if (isDownDirection)
                row++;
            else
                row--;

        }

        return print(zigzag, numRows);
    }

    private String print(Map<Integer, List<Character>> map, int rows){
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= rows; i++){

            for (Character letter : map.get(i)){
                sb.append(letter);
            }
        }
        return sb.toString();
    }

    private Map<Integer, List<Character>> init(int numRows){
        Map<Integer, List<Character>> map = new HashMap<>();
        for (int i = 1; i <= numRows; i++)
            map.put(i, new ArrayList<>());
        return map;
    }

}
