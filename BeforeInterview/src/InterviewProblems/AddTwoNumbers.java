package InterviewProblems;

import java.util.Scanner;

/**
 * Created by Arpit on 23-09-2017.
 * https://leetcode.com/problems/add-two-numbers/description/
 */

class ListNode {
    ListNode next;
    int val;
    ListNode(int data){
        this.val = data;
    }
}

public class AddTwoNumbers {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number 1:");
        String num1 = String.valueOf(scan.nextLong());
        System.out.println("Enter number 2:");
        String num2 = String.valueOf(scan.nextLong());

        ListNode head1 = makeLinkedList(num1);
        ListNode head2 = makeLinkedList(num2);

//        displayLinkedList(head1);
//        System.out.println();
//        displayLinkedList(head2);

        ListNode resultHead = addTwoNumbers(head1,head2);
        displayLinkedList(resultHead);
    }

    private static void displayLinkedList(ListNode head) {
        while (head!=null) {
            System.out.printf(head.val +" ");
            head = head.next;
        }
    }

    private static ListNode makeLinkedList(String num) {
        ListNode head = null;
        for (int i = 0; i < num.length(); i++) {
            int value = Integer.parseInt(num.charAt(i)+"");
            head = addNode(value,head);
        }
        return head;
    }

    private static ListNode addNode(int value,ListNode head){

        if (head == null) {
            ListNode node = new ListNode(value);
            node.next = null;
            return node;
        }
        ListNode node = new ListNode(value);
        node.next = head;
        head = node;

        return head;
    }

    /*
    TODO: 1. IMPROVE THIS
    1610910013
    1628526855
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head1 = l1, head2 = l2, resultHead = null;
        int carry = 0;

        //Corner case for lists with 1 element
        if (head1.next == null && head2.next == null){
            int sum = head1.val + head2.val;
            String sumS = String.valueOf(sum);
            if (sumS.length()>1)
                resultHead = addNode(Integer.parseInt(sumS.charAt(1)+""),resultHead);
            resultHead = addNode(Integer.parseInt(sumS.charAt(0)+""),resultHead);
            resultHead = ReverseIterative(resultHead);
            return resultHead;
        }
        String sumS = "";
        while(head1!=null && head2!=null){

            int sum = head1.val + head2.val + carry;
            sumS = String.valueOf(sum);
            if (sumS.length()>1){
                sum = Integer.parseInt(sumS.charAt(1)+"");
                carry = Integer.parseInt(sumS.charAt(0)+"");
            }
            resultHead = addNode(sum,resultHead);

            head1 = head1.next;
            head2 = head2.next;

            if (head1 == null && head2 == null && sumS.length() > 1)
                resultHead = addNode(carry,resultHead);
            if (sumS.length()==1)
                carry=0;
        }


        while (head1!=null){
            int sum = head1.val;
            if (sumS.length()>1)
                sum += carry;
            sumS = String.valueOf(sum);

            if (sumS.length()>1){
                sum = Integer.parseInt(sumS.charAt(1)+"");
                carry = Integer.parseInt(sumS.charAt(0)+"");
            }
            resultHead = addNode(sum,resultHead);
            head1 = head1.next;
        }

        while (head2!=null){
            int sum = head2.val;
            if (sumS.length()>1)
                sum += carry;
            sumS = String.valueOf(sum);

            if (sumS.length()>1){
                sum = Integer.parseInt(sumS.charAt(1)+"");
                carry = Integer.parseInt(sumS.charAt(0)+"");
            }
            resultHead = addNode(sum,resultHead);
            head2 = head2.next;
        }
        if (resultHead.val == 0)
            resultHead = addNode(carry,resultHead);
//        resultHead = addRemaining(head1,carry,resultHead);
//        resultHead = addRemaining(head2,carry,resultHead);
        resultHead = ReverseIterative(resultHead);
        return resultHead;

    }


//    private static ListNode addRemaining(ListNode head, int carry, ListNode resultHead){
//        while (head!=null){
//            int sum = head.val + carry;
//            String sumS = String.valueOf(sum);
//
//            if (sumS.length()>1){
//                sum = Integer.parseInt(sumS.charAt(1)+"");
//                carry = Integer.parseInt(sumS.charAt(0)+"");
//            }
//            resultHead = addNode(sum,resultHead);
//            head = head.next;
//        }
//        resultHead = addNode(carry,resultHead);
//
//        return resultHead;
//    }

    private static ListNode ReverseIterative(ListNode head){

        ListNode prev, curr, next;

        prev = null;
        curr = head;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev=curr;
            curr=next;
        }
        head=prev;
        return head;
    }




}
