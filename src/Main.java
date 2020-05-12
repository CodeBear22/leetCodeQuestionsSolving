import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        DsAlgo app = new DsAlgo();



        int[] sortedArray = {1,2,3,4,4,4,4,5,6,7};
//        app.rearrangeInMaxMin(sortedArray);

        int[] randomArray = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//        app.kthLargestElement(randomArray, 6);
//        app.rotateArrayRight(randomArray, 3);
//        app.tippingRainWater(randomArray);

        int[][] initThick = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };

        long[][] rate = {
                {1, 1, 1},
                {1, 11, 11},
                {1, 1, 1},
                {1, 11, 11},
                {1, 1, 1},
                {1, 1, 1}
        };

//        app.mazeTraveller(10, initThick, rate, 6, 3);

        int[][] rotateMatrixInput = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20}
        };

//        app.rotateMatrixNinetyDegree(rotateMatrixInput);

//        int[] result = app.findFirstAndLastOccurrenceInSortedArray(sortedArray, 4);

//        System.out.println(Arrays.toString(result));

        int[][] spiralMatrixInput = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        //[[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]
//        app.printMatrixInSpiral(spiralMatrixInput);

//        int[] input = {2,3,1,1,4};
//        boolean result = app.canJump(input);
//        if(result == true)
//        {
//            System.out.println("true");
//        } else {
//            System.out.println("false");
//        }

//        int[][] mergeIntervalInput = {
//                {1,6},
//                {5,8},
//                {9,10},
//                {0,20}
//        };
//
//        app.mergeIntervals(mergeIntervalInput);
//
//        int[] preorder = {3,9,20,15,7};
//        int[] inorder = {9,3,15,20,7};
//        TreeNode result = app.buildTree(preorder, inorder);
//        app.printLevelOrderTraversal(result);

        int [] maxContiguousSum = {-2, -3, 4, -1, -2, 1, 5, -3};

//        int contiguousSum = app.maxSumSubarray(maxContiguousSum);
//        System.out.println(contiguousSum);

//        int contiguousProduct = app.maxProductSubarray(maxContiguousSum);

        int[] nums1 = {1,2,2};
        int[] nums2 = {2};

//        double result = app.findMedianSortedArrays(nums1, nums2);

//        app.lengthOfLongestSubstring("pwwkew");




//        RandomizedSet customSet = new RandomizedSet();
//        customSet.insert(11);
//        customSet.insert(12);
//        customSet.remove(11);

//        app.largestRectangleArea(nums1);

//        System.out.println(app.myAtoi("  -0012a42"));
//        System.out.println(result);


//        -2147483648
//        2
//        System.out.println(app.divide(-2147483648, 2));

//        System.out.println(app.trailingZeroes(30));
//        int[] sortedArray2 = {1,2,3,4,5,6,7};
        TreeNode result = app.sortedArrayToBST(sortedArray);

        app.maxDepth(result);
    }

}
