package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _02_Add_Two_Numbers {

    public static void main(String[]args){
        _02_Add_Two_Numbers cl = new _02_Add_Two_Numbers();
        cl.addTwoNumbers(cl.testData1(), cl.testData2());
    }

    private ListNode testData1(){
        ListNode l1c = new ListNode(3);
        ListNode l1b = new ListNode(4, l1c);
        ListNode l1a = new ListNode(2, l1b);
        return l1a;
    }

    private ListNode testData2(){
        ListNode l2c = new ListNode(4);
        ListNode l2b = new ListNode(6, l2c);
        ListNode l2a = new ListNode(5, l2b);
        return l2a;
    }

    private ListNode addTwoNumbers(ListNode l1a, ListNode l2a){
        List<Integer> firstNodeValues = getValues(l1a);
        List<Integer> secondNodeValues = getValues(l2a);
        List<Integer> result = sumUpValues(firstNodeValues, secondNodeValues);
        Collections.reverse(result);
        return convertToListNode(result);
    }

    private List<Integer> getValues(ListNode node){
        List<Integer> values = new ArrayList<>();
        while (node != null){
            values.add(node.val);
            node = node.next;
        }
        return values;
    }

    private List<Integer> sumUpValues(List<Integer> firstNodeValues, List<Integer> secondNodeValues){
        int size = Math.max(firstNodeValues.size(), secondNodeValues.size());

        List<Integer> result = new ArrayList<>();
        boolean hasCarryOver = false;
        for (int i = 0; i < size; i++){
            int sum = getValue(firstNodeValues, i) + getValue(secondNodeValues, i) + (hasCarryOver ? 1 : 0);
            hasCarryOver = sum >= 10;
            if (!hasCarryOver){
                result.add(sum);
            } else {
                result.add(sum % 10);
            }
        }
        return result;
    }

    private int getValue(List<Integer> values, int index){
        try {
            return values.get(index);
        } catch (IndexOutOfBoundsException e){
            return 0;
        }
    }

    private ListNode convertToListNode(List<Integer> values) {
        if (values.isEmpty())
            return null;

        ListNode node = new ListNode(values.get(0));
        for (int i = 1; i < values.size(); i++) {
            ListNode newNode = new ListNode(values.get(i), node);
            node = newNode;
        }
        return node;
    }

    private class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
