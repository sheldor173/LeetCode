package com.mindarray.medium;

import com.mindarray.medium.utils.ListNode;

import java.util.ArrayList;
import java.util.Scanner;

public class AddTwoNumbers {

    public static void main(String[] args) {

        var scanner = new Scanner(System.in);

        var number1Tokens = getTokens(scanner.nextDouble());

        var number2Tokens = getTokens(scanner.nextDouble());

        displayNodes(addTwoNumbers(getNode(number1Tokens), getNode(number2Tokens)));
    }

    private static ArrayList<Integer> getTokens(double number) {

        var result = new ArrayList<Integer>();

        if (number > 9) while (number > 0) {

            var rem = (int) (number % 10);

            result.add(rem);

            number = number / 10;
        }
        else result.add((int) number);

        return result;
    }

    private static ListNode getNode(ArrayList<Integer> numberTokens) {

        var primaryNode = new ListNode(numberTokens.get(numberTokens.size() - 1));

        for (int i = numberTokens.size() - 2; i >= 0; i--) {

            primaryNode = new ListNode(numberTokens.get(i), primaryNode);
        }

        return primaryNode;
    }

    private static void displayNodes(ListNode node) {

        System.out.println();
        while (node.next != null) {

            System.out.print(node.val);
            System.out.print("->");
            node = node.next;
        }

        System.out.print(node.val);

    }

    /*
     * 1234
     * 4->3->2->1
     * 12
     * 2->1
     * 1246
     * 6->4->2->1
     * */


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        var success = false;

        var carry = 0;

        var buffer = new ArrayList<Integer>();

        while (!success) {

            var num1 = l1.val;
            var num2 = l2.val;

            if (l1.next != null) {
                l1 = l1.next;
            }

            if (l2.next != null) {
                l2 = l2.next;
            }

            var sum = carry + num1 + num2;

            if (sum > 9) {
                carry = sum / 10;
                buffer.add(sum % 10);
            } else {
                carry = 0;
                buffer.add(sum);
            }

            if (l1.next == null && l2.next == null) {
                success = true;
            }
        }

        var result = new ListNode();

        for (int i = buffer.size() - 1; i >=0 ; i--) {

            result = new ListNode(buffer.get(i), result);

        }

        return result;
    }

    private static void addRemainingSum(ListNode node) {

    }

}



