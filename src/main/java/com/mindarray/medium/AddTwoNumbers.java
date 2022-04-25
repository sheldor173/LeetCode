package com.mindarray.medium;

import com.mindarray.medium.utils.ListNode;

import java.util.ArrayList;
import java.util.Scanner;

public class AddTwoNumbers {

    public static void main(String[] args) {

        var scanner = new Scanner(System.in);

        var number1Tokens = getTokens(scanner.nextInt());

        var number2Tokens = getTokens(scanner.nextInt());

        displayNodes(addTwoNumbers(getNode(number1Tokens), getNode(number2Tokens)));
    }

    private static ArrayList<Integer> getTokens(int number) {

        var result = new ArrayList<Integer>();

        while (number > 0) {

            var rem = number % 10;

            result.add(rem);

            number = number / 10;
        }

        return result;
    }

    private static ListNode getNode(ArrayList<Integer> numberTokens) {

        var primaryNode = new ListNode(numberTokens.get(numberTokens.size() - 1));

        for (int i = numberTokens.size() - 2; i >= 0; i--) {

            primaryNode = new ListNode(numberTokens.get(i), primaryNode);
        }

        return primaryNode;
    }

    private static int getNumber(ListNode node) {

        var multiplier = 1;

        var number = 0;

        while (node.next != null) {

            number += node.val * multiplier;

            multiplier *= 10;

            node = node.next;
        }

        number += node.val * multiplier;

        return number;
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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        return getNode(getTokens(getNumber(l1) + getNumber(l2)));

    }
}



