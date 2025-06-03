package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class _06_Zigzag_Conversion_v3 {

    public String convert(String s, int numRows) {
        List<StringBuilder> zigzag = init(numRows);

        int row = 0;
        boolean isDownDirection = true;

        for (int i = 0; i < s.length(); i++){
            char letter = s.charAt(i);
            zigzag.get(row).append(letter);

            if (numRows > 1){
                if (row == numRows - 1){
                    isDownDirection = false;
                } else if (row == 0) {
                    isDownDirection = true;
                }

                row = isDownDirection ? row + 1 : row - 1;
            }

        }

        return print(zigzag, numRows);
    }

    public static void main(String[]args){
        _06_Zigzag_Conversion_v3 a = new _06_Zigzag_Conversion_v3();

        List<StringBuilder> list = a.init(3);
        list.get(0).append('a').append('b');
        list.get(1).append('c').append('b');
        list.get(2).append('d').append('e');
    }

    private String print(List<StringBuilder> list, int rows){
        return list.stream().map(StringBuilder::toString).collect(Collectors.joining());
    }

    private List<StringBuilder> init(int numRows){
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++)
            list.add(new StringBuilder());
        return list;
    }

}
