package practice;

public class _02_Add_Two_Numbers_v2 {

    public static void main(String[]args){
        _02_Add_Two_Numbers_v2 cl = new _02_Add_Two_Numbers_v2();
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

    private ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode out = new ListNode(0);
        ListNode prev = out;
        boolean hasCarryOver = false;

        while (l1 != null || l2 != null){
            int sum = getValue(l1) + getValue(l2) + (hasCarryOver ? 1 : 0);
            hasCarryOver = sum > 9;
            prev.next = new ListNode(hasCarryOver ? sum % 10 : sum);
            prev = prev.next;

            l1 = getNextNode(l1);
            l2 = getNextNode(l2);
        }

        if (hasCarryOver)
            prev.next = new ListNode(1);

        return out.next;
    }

    private int getValue(ListNode node){
        return node != null ? node.val : 0;
    }

    private ListNode getNextNode(ListNode node){
        return node != null ? node.next : null;
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
