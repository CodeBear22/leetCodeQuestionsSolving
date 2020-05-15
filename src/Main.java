import java.util.List;

public class Main {

    public static void main(String[] args) {
//        problem_1();
//        problem_3();
//        problem_5();
//        problem_8();
//        problem_11();
        problem_17();
    }


    //Add Two Numbers
    public static void problem_2() {
        problemStartEndAnnouncer(2, true);

        DsAlgo app = new DsAlgo();
        int[] num1 = {2, 4, 3};
        int[] num2 = {5, 6, 4};
        ListNode l1 = app.makeArrayToLinkedList(num1);
        ListNode l2 = app.makeArrayToLinkedList(num2);
        ListNode result = app.addTwoNumbers(l1, l2);
        app.printList(result);

        problemStartEndAnnouncer(2, false);
    }

    //Longest Substring Without Repeating Characters
    public static void problem_3() {
        problemStartEndAnnouncer(3, true);

        DsAlgo app = new DsAlgo();
        String input = "aabaab!bb";
        int result = app.lengthOfLongestSubstring(input);
        System.out.println(result);

        problemStartEndAnnouncer(3, false);
    }

    //Longest Palindromic Substring
    public static void problem_5() {
        problemStartEndAnnouncer(5, true);

        DsAlgo app = new DsAlgo();

        String input = "babad";
        String result = app.longestPalindrome(input);
        System.out.println(result);

        problemStartEndAnnouncer(5, false);
    }

    //String to Integer (atoi)
    public static void problem_8() {
        problemStartEndAnnouncer(8, true);

        DsAlgo app = new DsAlgo();
        String input = "91283472332 with words";
        int result = app.myAtoi(input);
        System.out.println(result);

        problemStartEndAnnouncer(8, true);
    }

    //Container With Most Water
    public static void problem_11() {
        problemStartEndAnnouncer(11, true);

        DsAlgo app = new DsAlgo();

        int[] input = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = app.largestRectangleArea(input);
        System.out.println(result);

        problemStartEndAnnouncer(11, false);
    }

    //Letter Combinations of a Phone Number
    public static void problem_17() {
        problemStartEndAnnouncer(17, true);

        DsAlgo app = new DsAlgo();

        String input = "234";
        List<String> result = app.letterCombinations(input);
        for (String str : result) {
            System.out.println(str);
        }

        problemStartEndAnnouncer(17, false);
    }

    public static void problemStartEndAnnouncer(int problemNumber, boolean starts) {
        if (starts) {
            System.out.println("#################### LeetCode Problem Number : " + problemNumber + " STARTS ####################");
        } else {
            System.out.println("#################### LeetCode Problem Number : " + problemNumber + " ENDS ####################");
        }
    }
}
