import com.kunal.Permutations;
import com.kunal.leetcode.*;
import com.kunal.utils.Helper;
import com.kunal.utils.ListNode;
import com.kunal.utils.TreeNode;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void problemStartEndAnnouncer(int problemNumber, boolean starts) {
        if (starts) {
            System.out.println("#################### LeetCode Problem Number : " + problemNumber + " STARTS ####################");
        } else {
            System.out.println("#################### LeetCode Problem Number : " + problemNumber + " ENDS ####################");
        }
    }


    public static void main(String[] args) {
//        problem_2();
//        problem_3();
//        problem_5();
//        problem_8();
//        problem_11();
//        problem_17();
//        problem_19();
//        problem_22();
//        problem_29();
//        problem_442();
//        problem_46();
//        problem_36();
//        problem_48();
//        problem_49();
//        problem_54();
//        problem_55();
//        problem_56();
//        problem_62();
//        problem_63();
//        problem_75();
//        problem_78();
//        problem_79();
//        problem_91();
//        problem_73();
//        problem_94();
//        problem_98();
//        problem_102();
//        problem_103();
        problem_105();
//        test();
    }


    //Add Two Numbers
    public static void problem_2() {
        problemStartEndAnnouncer(2, true);

        AddTwoNumbers app = new AddTwoNumbers();
        int[] num1 = {2, 4, 3};
        int[] num2 = {5, 6, 4};
        ListNode l1 = Helper.makeArrayToLinkedList(num1);
        ListNode l2 = Helper.makeArrayToLinkedList(num2);
        ListNode result = app.addTwoNumbers(l1, l2);
        Helper.printList(result);

        problemStartEndAnnouncer(2, false);
    }

    //Longest Substring Without Repeating Characters
    public static void problem_3() {
        problemStartEndAnnouncer(3, true);

        LongestSubstringWithoutRepeatingCharacters app = new LongestSubstringWithoutRepeatingCharacters();
        String input = "aabaab!bb";
        int result = app.lengthOfLongestSubstring(input);
        System.out.println(result);

        problemStartEndAnnouncer(3, false);
    }

    //Longest Palindromic Substring
    public static void problem_5() {
        problemStartEndAnnouncer(5, true);

        LongestPalindromicSubstring app = new LongestPalindromicSubstring();

        String input = "babad";
        String result = app.longestPalindrome(input);
        System.out.println(result);

        problemStartEndAnnouncer(5, false);
    }

    //String to Integer (atoi)
    public static void problem_8() {
        problemStartEndAnnouncer(8, true);

        StringToIntegerAtoi app = new StringToIntegerAtoi();
        String input = "91283472332 with words";
        int result = app.myAtoi(input);
        System.out.println(result);

        problemStartEndAnnouncer(8, true);
    }

    //Container With Most Water
    public static void problem_11() {
        problemStartEndAnnouncer(11, true);

        ContainerWithMostWater app = new ContainerWithMostWater();

        int[] input = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = app.largestRectangleArea(input);
        System.out.println(result);

        problemStartEndAnnouncer(11, false);
    }

    //Letter Combinations of a Phone Number
    public static void problem_17() {
        problemStartEndAnnouncer(17, true);

        LetterCombinationsOfPhoneNumber app = new LetterCombinationsOfPhoneNumber();

        String input = "234";
        List<String> result = app.letterCombinations(input);
        for (String str : result) {
            System.out.println(str);
        }

        problemStartEndAnnouncer(17, false);
    }

    //Remove Nth com.kunal.utils.Node From End of List
    public static void problem_19() {
        problemStartEndAnnouncer(19, true);

        RemoveNthNodeFromEndOfList app = new RemoveNthNodeFromEndOfList();
        int[] inputArr = {1, 2, 3, 4, 5};
        ListNode inputHead = Helper.makeArrayToLinkedList(inputArr);
        ListNode result = app.removeNthFromEnd(inputHead, 2);
        Helper.printList(result);

        problemStartEndAnnouncer(19, false);
    }

    //Generate Parentheses
    public static void problem_22() {
        problemStartEndAnnouncer(22, true);

        GenerateParentheses app = new GenerateParentheses();
        List<String> result = app.generateParenthesis(3);

        for (String str : result) {
            System.out.println(str);
        }

        problemStartEndAnnouncer(22, false);
    }

    //Divide Two Integers
    public static void problem_29() {
        problemStartEndAnnouncer(29, true);

        DivideTwoIntegers app = new DivideTwoIntegers();
        int result = app.divide(10, 3);
        System.out.println(result);

        problemStartEndAnnouncer(29, false);

    }

    //Find All Duplicates in an Array
    public static void problem_442() {
        problemStartEndAnnouncer(442, true);

        FindAllDuplicatesInAnArray app = new FindAllDuplicatesInAnArray();
        int[] input = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result = app.findDuplicates(input);

        for (int item : result)
            System.out.println(item);

        problemStartEndAnnouncer(442, false);
    }

    //Permutations
    public static void problem_46() {
        problemStartEndAnnouncer(46, true);

        Permutations app = new Permutations();
        int[] input = {1, 2, 3};
        List<List<Integer>> result = app.permute(input);

        for (List<Integer> list : result) {
            System.out.println(Arrays.toString(list.toArray()));
        }

        problemStartEndAnnouncer(46, false);
    }

    //Valid Sudoku
    public static void problem_36() {
        problemStartEndAnnouncer(46, true);

        ValidSudoku app = new ValidSudoku();

        char[][] input = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(app.isValidSudoku(input));

        problemStartEndAnnouncer(46, false);

    }

    //Rotate Image
    public static void problem_48() {
        problemStartEndAnnouncer(48, true);

        RotateImage app = new RotateImage();
        int[][] input = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        app.rotateMatrixNinetyDegree(input);
        problemStartEndAnnouncer(48, false);
    }

    //Group Anagrams
    public static void problem_49() {
        problemStartEndAnnouncer(49, true);

        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams app = new GroupAnagrams();
        List<List<String>> result = app.groupAnagrams(input);

        for (List<String> list : result) {
            for (String str : list) {
                System.out.print(str + "  ");
            }
            System.out.println();
        }

        problemStartEndAnnouncer(49, false);
    }

    //Spiral Matrix
    public static void problem_54() {
        problemStartEndAnnouncer(54, true);

        SpiralMatrix app = new SpiralMatrix();

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        List<Integer> result = app.printMatrixInSpiral(matrix);

        for (int i : result) {
            System.out.println(i);
        }

        problemStartEndAnnouncer(54, false);
    }

    //Jump Game
    public static void problem_55() {
        problemStartEndAnnouncer(55, true);

        JumpGame app = new JumpGame();
        int[] input = {2, 3, 1, 1, 4};
        System.out.println(app.canJump(input));

        problemStartEndAnnouncer(55, false);
    }

    // Merge Intervals
    public static void problem_56() {
        problemStartEndAnnouncer(56, true);

        MergeIntervals app = new MergeIntervals();
        int[][] input = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = app.mergeIntervals(input);

        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }

        problemStartEndAnnouncer(56, false);
    }

    public static void problem_62() {
        problemStartEndAnnouncer(62, true);

        UniquePaths app = new UniquePaths();
        System.out.println(app.uniquePaths(7, 3));

        problemStartEndAnnouncer(62, true);
    }

    public static void problem_63() {
        problemStartEndAnnouncer(63, true);

        UniquePathsII app = new UniquePathsII();
        int[][] input = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(app.uniquePathsWithObstacles(input));

        problemStartEndAnnouncer(63, false);
    }

    public static void problem_73() {
        problemStartEndAnnouncer(73, true);

        SetMatrixZeroes app = new SetMatrixZeroes();
        int[][] input = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        app.setZeroes(input);

        problemStartEndAnnouncer(73, false);
    }

    public static void problem_75() {
        problemStartEndAnnouncer(75, true);

        SortColors app = new SortColors();
        int[] input = {2, 0, 2, 1, 1, 0};
        app.sortColors(input);

        problemStartEndAnnouncer(75, false);
    }

    public static void problem_78() {
        problemStartEndAnnouncer(78, true);

        Subsets app = new Subsets();
        int[] input = {1, 2, 3};
        List<List<Integer>> result = app.subsets(input);

        for (List<Integer> list : result) {
            System.out.println(Arrays.toString(list.toArray()));
        }

        problemStartEndAnnouncer(78, false);
    }

    public static void problem_79() {
        problemStartEndAnnouncer(79, true);

        WordSearch app = new WordSearch();
        char[][] input = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        System.out.println(app.exist(input, "ABCCED"));

        problemStartEndAnnouncer(79, false);
    }

    public static void problem_91() {
        problemStartEndAnnouncer(91, true);

        DecodeWays app = new DecodeWays();
        String input = "226";
        int result = app.numDecodings(input);

        System.out.println(result);

        problemStartEndAnnouncer(91, false);
    }

    public static void problem_94() {
        problemStartEndAnnouncer(94, true);

        BinaryTreeInorderTraversal app = new BinaryTreeInorderTraversal();

        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = null;

        List<Integer> result = app.inorderTraversal(root);

        for (Integer val : result)
            System.out.println(val);

        problemStartEndAnnouncer(94, false);
    }

    public static void problem_98() {
        problemStartEndAnnouncer(98, true);

        ValidateBinarySearchTree app = new ValidateBinarySearchTree();
        //{3,1,5,0,2,4,6,null,null,null,3}
        Integer[] nodeValues = {1, null, 1};//{3, 1, 5, 0, 2, 4, 6};
        TreeNode root = Helper.constructTree(nodeValues);

        System.out.println(app.isValidBST(root));

        problemStartEndAnnouncer(98, false);
    }

    public static void problem_102() {
        problemStartEndAnnouncer(102, true);

        BinaryTreeLevelOrderTraversal app = new BinaryTreeLevelOrderTraversal();

        TreeNode root = new TreeNode(
                3,
                new TreeNode(9),
                new TreeNode(
                        20,
                        new TreeNode(15),
                        new TreeNode(7)
                )
        );
        List<List<Integer>> result = app.levelOrderRecursive(root);

        for (List<Integer> list : result) {
            System.out.println(Arrays.toString(list.toArray()));
        }

        problemStartEndAnnouncer(102, false);
    }

    public static void problem_103() {
        problemStartEndAnnouncer(103, true);

        Integer[] treeNodes = {3,9,20,null,null,15,7};

        TreeNode root = Helper.constructTree(treeNodes);

        BinaryTreeZigzagLevelOrderTraversal app = new BinaryTreeZigzagLevelOrderTraversal();

        List<List<Integer>> result = app.zigzagLevelOrder(root);

        for (List<Integer> list : result) {
            System.out.println(Arrays.toString(list.toArray()));
        }

        problemStartEndAnnouncer(103, false);
    }

    public static void problem_105() {
        problemStartEndAnnouncer(105, true);

        int[] preorder = {};
        int[] inorder = {};

        ConstructBinaryTreeFromPreorderAndInorderTraversal app = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        TreeNode root = app.buildTree(preorder, inorder);

        problemStartEndAnnouncer(105, false);
    }

    public static void test() {
        int input = 99;

//        input = {1,2,3};

        DsAlgo app = new DsAlgo();
        app.test(input);
        System.out.println(input);

    }
}
