package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _06_Zigzag_Conversion_v2 {

    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;

        List[] zigzag = init(numRows);

        int row = 0;
        boolean isDownDirection = true;
        for (int i = 0; i < s.length(); i++){
            char letter = s.charAt(i);
            zigzag[row].add(letter);

            if (row == numRows-1){
                isDownDirection = false;
            } else if (row == 0) {
                isDownDirection = true;
            }

            if (isDownDirection){
                row++;
            } else {
                row--;
            }

        }

        return print(s, zigzag, numRows);
    }

    private String print(String s, List[] list, int rows){
        char[] zigzag = new char[s.length()];
        int index = 0;
        for (int i = 0; i < rows; i++){

            for (Object letter : list[i]){
                zigzag[index] = (char) letter;
                index++;
            }
        }
        return new String(zigzag);
    }

    private List[] init(int numRows){
        List[] list = new List[numRows];

        for (int i = 0; i < numRows; i++)
            list[i] = new ArrayList<>();

        return list;
    }

}
