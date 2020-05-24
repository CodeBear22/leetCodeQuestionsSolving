package com.kunal.leetcode;

import com.kunal.utils.Node;
import com.kunal.utils.TreeNode;

import java.util.*;

public class DsAlgo {


    public void test(int input)
    {
        input = 789;
        System.out.println(input);

    }



//    public void rearrangeInMaxMin(int[] array) {
//        int arraySize = array.length;
//        int min = Integer.MIN_VALUE;
//        int element = array[arraySize - 1] + 1;
//        int maxIndex = arraySize - 1;
//        int minIndex = 0;
//        int i = 0;
//
//        for (i = 0; i < arraySize; i++) {
//            if (i % 2 == 0) {
//                array[i] += (array[maxIndex] % element) * element;
//                maxIndex--;
//            } else {
//                array[i] += (array[minIndex] % element) * element;
//                minIndex++;
//            }
//        }
//
//        for (i = 0; i < arraySize; i++) {
//            array[i] = array[i] / element;
//        }
//        System.out.println(Arrays.toString(array));
//    }
//
//    public void kthLargestElement(int[] array, int k) {
//        int n = array.length;
//        int l = 0;
//        int r = n - 1;
//
//        Random rand = new Random(0);
//
//        while (l <= r) {
//            int chosenPivotIndex = rand.nextInt(r - l + 1) + l;
//
//            int finalPivotIndex = __kthLargestElement(array, l, r, chosenPivotIndex);
//
//            if (finalPivotIndex == n - k) {
//                System.out.println(array[finalPivotIndex]);
//                return;
//            } else if (finalPivotIndex > n - k) {
//                r = finalPivotIndex - 1;
//            } else {
//                l = finalPivotIndex + 1;
//            }
//        }
//        System.out.println("Element Not Found");
//    }
//
//    private int __kthLargestElement(int[] array, int left, int right, int chosenPivotIndex) {
//        int pivotValue = array[chosenPivotIndex];
//        int lesserElementsTail = left;
//        this.__swapInArray(array, chosenPivotIndex, right);
//
//        for (int i = left; i < right; i++) {
//            if (array[i] < pivotValue) {
//                this.__swapInArray(array, i, lesserElementsTail);
//                lesserElementsTail++;
//            }
//        }
//        this.__swapInArray(array, right, lesserElementsTail);
//        return lesserElementsTail;
//    }
//
//    public void rotateArrayRight(int[] nums, int k) {
//
//        if (k == nums.length)
//            return;
//        int size = nums.length;
//        int i;
//        int temp;
//        int swapHelper = 0;
//        int rotateCount = 0;
//        int[] extra = new int[k];
//
//
//        while (rotateCount < k) {
//            i = rotateCount;
//            temp = nums[i];
//
//
//            for (i += k; i < size; i += k) {
//                swapHelper = nums[i];
//                nums[i] = temp;
//                temp = swapHelper;
//            }
//            extra[i - size] = temp;
//            rotateCount++;
//
//            System.out.println(temp);
//        }
//
//        for (i = 0; i < k; i++) {
//            nums[i] = extra[i];
//        }
//
//        System.out.println(Arrays.toString(nums));
//    }
//
//    public void tippingRainWater(int[] bars) {
//        int[] maxBarsRightToLeft = new int[bars.length];
//        maxBarsRightToLeft[0] = bars[0];
//        int waterStored = 0;
//        for (int i = 1; i < bars.length; i++) {
//            if (bars[i] > maxBarsRightToLeft[i - 1]) {
//                maxBarsRightToLeft[i] = bars[i];
//            } else {
//                maxBarsRightToLeft[i] = maxBarsRightToLeft[i - 1];
//            }
//        }
//        System.out.println(Arrays.toString(maxBarsRightToLeft));
//        int max = 0;
//        for (int i = bars.length - 1; i >= 0; i--) {
//
//            if (bars[i] > max) {
//                max = bars[i];
//            }
//            waterStored += Math.abs(maxBarsRightToLeft[i] - max);
//        }
//
//        System.out.println(waterStored);
//    }
//
////    public List<List<Integer>> threeSumCloseToZero(int[] arr) {
////        boolean found = false;
////        int n = arr.length;
////        List<List<Integer>> result = new ArrayList<ArrayList<Integer>>();
////
////        // sort array elements
////        Arrays.sort(arr);
////
////        for (int i=0; i<n-1; i++)
////        {
////            // initialize left and right
////            int l = i + 1;
////            int r = n - 1;
////            int x = arr[i];
////            while (l < r)
////            {
////                if (x + arr[l] + arr[r] == 0)
////                {
////                    // print elements if it's sum is zero
////                    System.out.print(x + " ");
////                    System.out.print(arr[l]+ " ");
////                    System.out.println(arr[r]+ " ");
////
////                    l++;
////                    r--;
////                    found = true;
////                }
////
////                // If sum of three elements is less
////                // than zero then increment in left
////                else if (x + arr[l] + arr[r] < 0)
////                    l++;
////
////                    // if sum is greater than zero than
////                    // decrement in right side
////                else
////                    r--;
////            }
////        }
////
////        if (found == false)
////            System.out.println(" No Triplet Found");
////
////
////
////    }
//
//    public void mazeTraveller(int threshold, int[][] initThickness, long[][] rate, int rows, int cols) {
//        // Write your code here
//        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
//        if (mazeTravellerHelper(threshold, initThickness, rate, rows, cols, 0, 0, 0, map))
//            System.out.println("YES");
//        else
//            System.out.println("NO");
//    }
//
//    private void __swapInArray(int[] arr, int firstIndex, int secondIndex) {
//        int temp = arr[firstIndex];
//        arr[firstIndex] = arr[secondIndex];
//        arr[secondIndex] = temp;
//    }
//
//    public List<List<Integer>> zigzagLevelOrder(Node root) {
//        Stack<Node> stack = new Stack<Node>();
//        Queue<Node> queue = new LinkedList<Node>();
//        List<Integer> list = new ArrayList<Integer>();
//
//
//        List<List<Integer>> result = new ArrayList<>();
//        list.add(root.val);
//        stack.push(root.left);
//        stack.push(root.right);
//        result.add(list);
//
//        Boolean type = false;
//
//
//        while (!stack.empty() && !queue.isEmpty()) {
//            Node current;
//            list = new ArrayList<Integer>();
//            if (type) {
//                while (!queue.isEmpty()) {
//                    current = queue.poll();
//                    list.add(current.val);
//                    stack.push(current.left);
//                    stack.push(current.right);
//
//                    type = false;
//                }
//
//            } else {
//
//                while (!stack.empty()) {
//                    current = stack.pop();
//                    list.add(current.val);
//                    queue.add(current.left);
//                    queue.add(current.right);
//                    type = true;
//                }
//
//            }
//            result.add(list);
//        }
//        return result;
//
//
//    }
//
//    public void printLevelOrderTraversal(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<>();
//
//        queue.add(root);
////        queue.add(null);
//
//        while (!queue.isEmpty()) {
//            TreeNode curr = queue.poll();
//
//            System.out.println(curr.val);
//            if (curr.left != null) {
//                queue.add(curr.left);
//            }
//
//            if (curr.right != null) {
//                queue.add(curr.right);
//            }
//        }
//
//    }
//
//    public int[] findFirstAndLastOccurrenceInSortedArray(int[] nums, int target) {
//
//        int targetIndex = binarySearch(nums, target);
//
//        int[] result = new int[2];
//
//        Arrays.fill(result, -1);
//        if (targetIndex == -1) {
//            return result;
//        }
//
//        int firstIndex = targetIndex;
//        int lastIndex = targetIndex;
//
//        while (firstIndex >= 0) {
//            if (nums[firstIndex] == nums[firstIndex - 1])
//                firstIndex--;
//            else
//                break;
//        }
//
//        while (lastIndex < nums.length) {
//            if (nums[lastIndex] == nums[lastIndex + 1])
//                lastIndex++;
//            else
//                break;
//        }
//
//        result[0] = firstIndex;
//        result[1] = lastIndex;
//
//        return result;
//    }
//
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//
//        HashMap<Integer, Integer> preOrderMap = new HashMap<>();
//
//        for (int i = 0; i < preorder.length; i++) {
//            preOrderMap.put(preorder[i], i);
//        }
//
//
//        return buildTreeHelper(preOrderMap, inorder, 0, inorder.length - 1);
//
//    }
//
//    private TreeNode buildTreeHelper(HashMap<Integer, Integer> preorder, int[] inorder, int l, int r) {
//        System.out.println(l + "---" + r);
//
//        if (l > r) {
//            return null;
//        }
//
//
//        int minIndex = Integer.MAX_VALUE;
//        int rootVal = 0;
//        int rootIndex = -1;
//
//        for (int i = l; i <= r; i++) {
//
//            if (preorder.containsKey(inorder[i]) && preorder.get(inorder[i]) < minIndex) {
//                minIndex = preorder.get(inorder[i]);
//                rootVal = inorder[i];
//                rootIndex = i;
//            }
//        }
//
//        if (minIndex >= inorder.length)
//            return null;
//
//        TreeNode root = new TreeNode(rootVal);
//        System.out.println(root.val);
//        System.out.println("left");
//        root.left = buildTreeHelper(preorder, inorder, l, rootIndex - 1);
//        System.out.println("right");
//        root.right = buildTreeHelper(preorder, inorder, rootIndex + 1, r);
//        return root;
//    }
//
//    public int maxSumSubarray(int[] nums) {
//
//        int size = nums.length;
//
//        int maxSum = 0;
//
//        int currSum = 0;
//
//        for (int i = 0; i < size; i++) {
//            currSum = currSum + nums[i];
//
//            if (currSum < 0) {
//                currSum = 0;
//            }
//
//            if (maxSum < currSum) {
//                maxSum = currSum;
//            }
//        }
//        return maxSum;
//    }
//
//    public int maxProductSubarray(int[] nums) {
//        int[] min = new int[nums.length];
//        int[] max = new int[nums.length];
//        int result;
//        result = min[0] = max[0] = nums[0];
//
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] > 0) {
//                max[i] = Math.max(max[i - 1], max[i - 1] * nums[i]);
//                min[i] = Math.max(min[i - 1], min[i - 1] * nums[i]);
//            } else {
//                max[i] = Math.max(min[i - 1], min[i - 1] * nums[i]);
//                min[i] = Math.max(max[i - 1], max[i - 1] * nums[i]);
//            }
//
//            result = Math.max(result, max[i]);
//        }
//
//        return result;
//    }
//
//    public int findPeakElement(int[] nums) {
//
//
//        if (nums.length == 1) {
//            return 0;
//        }
//
//        if (nums.length == 2) {
//            if (nums[0] > nums[1]) {
//                return 0;
//            } else {
//                return 1;
//            }
//        }
//
//        if (nums.length < 3) {
//            return -1;
//        }
//
//        for (int i = 1; i < nums.length - 1; i++) {
//            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
//                return i;
//            }
//        }
//
//        if (nums[nums.length - 1] > nums[nums.length - 2]) {
//            return nums.length - 1;
//        }
//        return -1;
//    }
//
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int size = nums1.length + nums2.length;
//
//        int i, j, k, prev, curr;
//
//        prev = curr = i = j = k = 0;
//
//        while (j < nums1.length && k < nums2.length) {
//            prev = curr;
//            if (nums1[j] < nums2[k]) {
//                curr = nums1[j];
////                i++;
//                j++;
//            } else {
//                curr = nums2[k];
////                i++;
//                k++;
//            }
//
//            if (i == (size / 2)) {
//                if (size % 2 == 0) {
//                    return (double) (curr + prev) / 2;
//                } else {
//                    return curr;
//                }
//            }
//            i++;
//        }
//
//        while (j < nums1.length) {
//            prev = curr;
//            curr = nums1[j];
////            i++;
//            j++;
//
//            if (i == (size / 2)) {
//                if (size % 2 == 0) {
//                    return (double) (curr + prev) / 2;
//                } else {
//                    return curr;
//                }
//            }
//            i++;
//        }
//
//        while (k < nums2.length) {
//            prev = curr;
//            curr = nums2[k];
////            i++;
//            k++;
//
//            if (i == (size / 2)) {
//                if (size % 2 == 0) {
//                    return (double) (curr + prev) / 2;
//                } else {
//                    return curr;
//                }
//            }
//            i++;
//        }
//        return -1;
//    }
//
//    public boolean isHappy(int n) {
//
//        List<Integer> check = new ArrayList<>();
//
//        check.add(n);
//
//        int temp, product;
//        // product =
//
//        while (n != 1) {
//            product = 0;
//            while (n > 0) {
//                int i = n % 10;
//                product += i * i;
//                n /= 10;
//            }
//
//            if (check.contains(product)) {
//                return false;
//            } else {
//                check.add(product);
//            }
//
//            n = product;
//        }
//
//        return true;
//    }
//
//    private Boolean mazeTravellerHelper(int t, int[][] initThickness, long[][] rate, int rows, int cols, int currRow, int currCol, int steps, HashMap<String, Boolean> cachedResult) {
//        if (currRow >= rows || currCol >= cols) {
//            return false;
//        }
//
//        if (currRow == rows - 1 && currCol == cols - 1) {
//            return true;
//        }
//
//        String key = currRow + "," + currCol;
//
//        if (cachedResult.containsKey(key)) {
//            System.out.println("cached result--" + key);
//            return cachedResult.get(key);
//        }
//
//
//        long currentThickness = initThickness[currRow][currCol] + (rate[currRow][currCol] * steps);
//
//        if (currentThickness >= (long) t) {
//            return false;
//        }
//
//
//        Boolean down = mazeTravellerHelper(t, initThickness, rate, rows, cols, currRow + 1, currCol, steps + 1, cachedResult);
//
//        cachedResult.put((currRow + 1) + "," + currCol, down);
//        if (down) {
//            return true;
//        }
//        Boolean right = mazeTravellerHelper(t, initThickness, rate, rows, cols, currRow, currCol + 1, steps + 1, cachedResult);
//
//
//        cachedResult.put(currRow + "," + (currCol + 1), right);
//        return right;
//
//    }
//
//    public int firstUniqChar(String s) {
//
//        HashMap<Character, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            if (map.containsKey(s.charAt(i))) {
//                int count = map.get(s.charAt(i));
//                map.put(s.charAt(i), ++count);
//            } else {
//                map.put(s.charAt(i), 1);
//            }
//        }
//
//        for (int i = 0; i < s.length(); i++) {
//
//            if (map.get(s.charAt(i)) == 1)
//                return i;
//        }
//
//        return -1;
//    }
//
//    public List<Integer> topKFrequent(int[] nums, int k) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        List<Integer> result = new ArrayList<>();
//        int count;
//        for (int item : nums) {
//            if (map.containsKey(item)) {
//                count = map.get(item);
//                count++;
//                if (count == k) {
//                    result.add(item);
//                }
//            } else {
//                count = 1;
//            }
//            map.put(item, count);
//        }
//        return result;
//    }
//
//
//    public String minWindow(String s, String t) {
//        HashMap<Character, Integer> map = new HashMap<>();
//
//
//        if (t.length() == s.length() && s.length() == 1)
//            return t.equals(s) ? s : "";
//
//
//        String result;
//
//        int iterator = 0;
//
//        for (iterator = 0; iterator < t.length(); iterator++) {
//            map.put(t.charAt(iterator), 0);
//        }
//
//        int l, r = 0;
//        l = 0;
//
//        boolean flag = false;
//        while (!flag && r < s.length()) {
//            if (map.containsKey(s.charAt(r))) {
//                map.put(s.charAt(r), map.get(s.charAt(r)) + 1);
//                flag = true;
//
//                for (iterator = 0; iterator < t.length(); iterator++) {
//                    if (map.get(t.charAt(iterator)) == 0) {
//                        flag = false;
//                    }
//                }
//
//            }
//            if (!flag) {
//                r++;
//            }
//        }
//
//        if (!flag)
//            return "";
//
//
//        int min = Integer.MAX_VALUE;
//        r++;
//        System.out.println(s.substring(l, r) + "---dssdf");
//
//        result = s.substring(l, r + 1);
//        while (r < s.length() && l < r) {
//            if (flag) {
//                if (map.containsKey(s.charAt(l))) {
//                    map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
//                    flag = true;
//                    for (iterator = 0; iterator < t.length(); iterator++) {
//                        if (map.get(t.charAt(iterator)) == 0) {
//                            flag = false;
//                        }
//                    }
//                }
//
//                if (flag) {
//                    System.out.println("Left");
//
//
//                    if (min > (r - 1) - l) {
//                        min = (r - 1) - l;
//                        result = s.substring(l + 1, (r));
//                        System.out.println(s.substring(l + 1, (r)));
//                    }
//                    System.out.println(l + "-" + (r - 1) + "-" + min);
//                }
//                l++;
//            } else {
//
//                if (map.containsKey(s.charAt(r))) {
//                    map.put(s.charAt(r), map.get(s.charAt(r)) + 1);
//                    flag = true;
//                    for (iterator = 0; iterator < t.length(); iterator++) {
//                        if (map.get(t.charAt(iterator)) == 0) {
//                            flag = false;
//                        }
//                    }
//                }
//                if (flag) {
//                    System.out.println("Right");
//
//                    if (min > r - (l - 1)) {
//                        min = r - (l - 1);
//                        result = s.substring((l - 1), r);
//                        System.out.println(s.substring((l - 1), r));
//                    }
//                    System.out.println((l - 1) + "-" + r + "-" + min);
//                }
//                r++;
//
//            }
//        }
//
//
//        while (flag) {
//            if (map.containsKey(s.charAt(l))) {
//                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
//                flag = true;
//                for (iterator = 0; iterator < t.length(); iterator++) {
//                    if (map.get(t.charAt(iterator)) == 0) {
//                        flag = false;
//                    }
//                }
//            }
//
//            if (flag) {
//                System.out.println("Final");
//
////                min = Math.min(min, (r - 1) - l);
//                if (min > (r - 1) - l) {
//                    min = (r - 1) - l;
//                    result = s.substring(l + 1, r);
//                    System.out.println(s.substring(l + 1, r));
//                }
//                System.out.println(l + "---" + (r - 1) + "-" + min);
//            }
//            l++;
//        }
//
//
//        System.out.println(min);
//        return result;
//    }
//
//    public int trailingZeroes(int n) {
//        long factorial = 1;
//
//        for (int i = 1; i <= n; i++) {
//            factorial *= i;
//        }
//
//        int mod = 0;
//        int divisor = 10;
//        int zeros = 0;
//        System.out.println(factorial);
//        while (mod == 0) {
//            System.out.println(divisor);
//            mod = (int) (factorial % divisor);
//
//            if (mod == 0) {
//                zeros++;
//            } else {
//                return zeros;
//            }
//
//            divisor *= 10;
//        }
//        return zeros;
//    }
//
//    public TreeNode sortedArrayToBST(int[] nums) {
//        return _sortedArrayToBST(nums, 0, nums.length - 1);
//    }
//
//    public TreeNode _sortedArrayToBST(int[] nums, int left, int right) {
//
//        if (left > right)
//            return null;
//
//        int mid = (left + right) / 2;
//
//        TreeNode root = new TreeNode(nums[mid]);
//
//        root.left = _sortedArrayToBST(nums, left, mid - 1);
//        root.right = _sortedArrayToBST(nums, mid + 1, right);
//        return root;
//    }
//
//    public int maxDepth(TreeNode root) {
//        return this._maxDepthHelper(root, 0);
//    }
//
//    private int _maxDepthHelper(TreeNode root, int depth) {
//        if (root == null) {
//            return depth;
//        }
//        int leftDepth = this._maxDepthHelper(root.left, depth);
//        int rightDepth = this._maxDepthHelper(root.right, depth);
//        return Math.max(leftDepth, rightDepth) + 1;
//    }
//
////    public String entityParser(String text) {
////        String[] entities = {};
////        String[] character = {};
////    }
//
//    private int binarySearch(int[] input, int target) {
//        int l = 0;
//        int r = input.length - 1;
//        int mid;
//
//        while (l <= r) {
//            mid = (l + r) / 2;
//
//            if (target == input[mid]) {
//                return mid;
//            }
//
//            if (input[mid] < target) {
//                l = mid + 1;
//            } else {
//                r = mid - 1;
//            }
//        }
//        return -1;
//    }
//
//    public int minStep(int m, int n) {
//
//        int[][] grid = new int[m][n];
//
////        Arrays.fill(grid, 0);
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (i == 0 && j == 0)
//                    grid[i][j] = 0;
//                else if (i == 0)
//                    grid[i][j] = grid[i][j - 1] + 1;
//                else if (j == 0)
//                    grid[i][j] = grid[i][j] + 1;
//                else {
//                    int comingFromUp = grid[i - 1][j];
//                    int comingFromRight = grid[i][j - 1];
//                    grid[i][j] = comingFromRight > comingFromUp ? comingFromRight + 1 : comingFromUp + 1;
//                }
//
//            }
//        }
//        return grid[m - 1][n - 1];
//    }
//
//    public void combinationMaker(int[] nums) {
//
//        boolean[] combination = new boolean[nums.length];
//        Arrays.fill(combination, false);
//
//        List<String> combinations = new ArrayList<>();
//
//        _combinationMakerHelper(nums, 0, combination, combinations);
//
//        for (String arr : combinations) {
//            System.out.println(arr);
//        }
//    }
//
//    private void _combinationMakerHelper(int[] nums, int currentIndex, boolean[] combination, List<String> combinations) {
//        if (currentIndex == nums.length) {
//            combinations.add(Arrays.toString(combination));
//            return;
//        }
//        combination[currentIndex] = true;
//        _combinationMakerHelper(nums, currentIndex + 1, combination, combinations);
//
//        combination[currentIndex] = false;
//        _combinationMakerHelper(nums, currentIndex + 1, combination, combinations);
//    }



    //    public static void test(int N, int T, int D) {
//
//        int mod = T % N;
//        int x = D + mod - 1;
//        int result;
//
//        if(x > N)
//        {
//            result = x - N;
//        } else {
//            result = x;
//        }
//
//        if(result == 0)
//            result = N;
//        System.out.println(result);
//    }

//    public static int test(String pattern) {
//        boolean[] digitsUsed = new boolean[10];
//
//        int result = 0;
//
//        int patternLength = pattern.length();
//
////        int initialM = 21;
//
////        int initialN = 21;
//
//        if (patternLength == 1 && pattern.equals("M"))
//            return 21;
//
//        if (patternLength == 1 && pattern.equals("N"))
//            return 12;
//
//        for (int i = 0; i < patternLength - 1; i++) {
//
//            if (pattern.charAt(i) == 'M') {
//                if (result == 0) {
//                    result = (result * 10) + getNextDigit(digitsUsed, true);
//                    result = (result * 10) + getNextDigit(digitsUsed, false);
//                } else {
//                    result = (result * 10) + getNextDigit(digitsUsed, true);
//                }
//            } else {
//
//                if (result == 0) {
//                    result = (result * 10) + getNextDigit(digitsUsed, false);
//                    result = (result * 10) + getNextDigit(digitsUsed, true);
//                } else {
//                    result = (result * 10) + getNextDigit(digitsUsed, false);
//                }
//            }
//        }
//
//        System.out.println(result);
//        System.out.println(Arrays.toString(digitsUsed));
//        if (patternLength > 1) {
//            int lastDigit = result % 10;
//            System.out.println(lastDigit);
//
//            if (pattern.charAt(patternLength - 1) == 'M') {
//                for (int i = 1; i < digitsUsed.length; i++) {
//                    if (!digitsUsed[i] && i < lastDigit) {
//                        result = (result * 10) + i;
//                        break;
//                    }
//                }
//            } else if (pattern.charAt(patternLength - 1) == 'N'){
//                for (int i = 1; i < digitsUsed.length; i++) {
//                    if (!digitsUsed[i] && i > lastDigit) {
//                        result = (result * 10) + i;
//                        break;
//                    }
//                }
//            }
//        }
//        return result;
//    }
//
//    static int getNextDigit(boolean[] usedDigits, boolean even) {
//
//        if (even) {
//            for (int i = 2; i < usedDigits.length; i = i + 2) {
//                if (!usedDigits[i]) {
//                    usedDigits[i] = true;
//                    return i;
//                }
//            }
//        } else {
//            for (int i = 1; i < usedDigits.length; i = i + 2) {
//                if (!usedDigits[i]) {
//                    usedDigits[i] = true;
//                    return i;
//                }
//            }
//
//        }
//        return 0;
//    }
}