package practice;

import java.util.Arrays;

public class _07_Reverse_Integer {

    public static void main(String[]args){
        _07_Reverse_Integer cl = new _07_Reverse_Integer();

//        int i = 2147483647;
////        System.out.println(1234%100);
        System.out.println(cl.reverse(1563847412));
    }

    public int reverse(int x) {
        boolean isPositive = x > 0;
        int absolute = Math.abs(x);
        int remaining = absolute/1;

        int reverse = 0;
        while(remaining/1 > 0){
            int digit = remaining % 10;
//Integer.MIN_VALUE
            if (reverse > Integer.MAX_VALUE / 10 && ((isPositive && remaining > 7) || (remaining < 8))) //214748364.7 | -214748364.8
                return 0;

            reverse = (reverse + digit);

            remaining = remaining / 10;
            if (remaining / 1 > 0)
                reverse *= 10;

        }
        return isPositive ? reverse : reverse * -1;
    }

    public int reverse2(int x) {
        boolean isPositive = x > 0;
        String str = String.valueOf(Math.abs(x));

        try {
            int reverse = Integer.parseInt(new StringBuilder(str).reverse().toString());
            return isPositive ? reverse : Math.negateExact(reverse) ;
        } catch (NumberFormatException e){
            return 0;
        }

    }
}
