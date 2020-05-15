import java.util.*;

public class DsAlgo {

    public void rearrangeInMaxMin(int[] array) {
        int arraySize = array.length;
        int min = Integer.MIN_VALUE;
        int element = array[arraySize - 1] + 1;
        int maxIndex = arraySize - 1;
        int minIndex = 0;
        int i = 0;

        for (i = 0; i < arraySize; i++) {
            if (i % 2 == 0) {
                array[i] += (array[maxIndex] % element) * element;
                maxIndex--;
            } else {
                array[i] += (array[minIndex] % element) * element;
                minIndex++;
            }
        }

        for (i = 0; i < arraySize; i++) {
            array[i] = array[i] / element;
        }
        System.out.println(Arrays.toString(array));
    }

    public void kthLargestElement(int[] array, int k) {
        int n = array.length;
        int l = 0;
        int r = n - 1;

        Random rand = new Random(0);

        while (l <= r) {
            int chosenPivotIndex = rand.nextInt(r - l + 1) + l;

            int finalPivotIndex = __kthLargestElement(array, l, r, chosenPivotIndex);

            if (finalPivotIndex == n - k) {
                System.out.println(array[finalPivotIndex]);
                return;
            } else if (finalPivotIndex > n - k) {
                r = finalPivotIndex - 1;
            } else {
                l = finalPivotIndex + 1;
            }
        }
        System.out.println("Element Not Found");
    }

    private int __kthLargestElement(int[] array, int left, int right, int chosenPivotIndex) {
        int pivotValue = array[chosenPivotIndex];
        int lesserElementsTail = left;
        this.__swapInArray(array, chosenPivotIndex, right);

        for (int i = left; i < right; i++) {
            if (array[i] < pivotValue) {
                this.__swapInArray(array, i, lesserElementsTail);
                lesserElementsTail++;
            }
        }
        this.__swapInArray(array, right, lesserElementsTail);
        return lesserElementsTail;
    }

    public void rotateArrayRight(int[] nums, int k) {

        if (k == nums.length)
            return;
        int size = nums.length;
        int i;
        int temp;
        int swapHelper = 0;
        int rotateCount = 0;
        int[] extra = new int[k];


        while (rotateCount < k) {
            i = rotateCount;
            temp = nums[i];


            for (i += k; i < size; i += k) {
                swapHelper = nums[i];
                nums[i] = temp;
                temp = swapHelper;
            }
            extra[i - size] = temp;
            rotateCount++;

            System.out.println(temp);
        }

        for (i = 0; i < k; i++) {
            nums[i] = extra[i];
        }

        System.out.println(Arrays.toString(nums));
    }

    public void tippingRainWater(int[] bars) {
        int[] maxBarsRightToLeft = new int[bars.length];
        maxBarsRightToLeft[0] = bars[0];
        int waterStored = 0;
        for (int i = 1; i < bars.length; i++) {
            if (bars[i] > maxBarsRightToLeft[i - 1]) {
                maxBarsRightToLeft[i] = bars[i];
            } else {
                maxBarsRightToLeft[i] = maxBarsRightToLeft[i - 1];
            }
        }
        System.out.println(Arrays.toString(maxBarsRightToLeft));
        int max = 0;
        for (int i = bars.length - 1; i >= 0; i--) {

            if (bars[i] > max) {
                max = bars[i];
            }
            waterStored += Math.abs(maxBarsRightToLeft[i] - max);
        }

        System.out.println(waterStored);
    }

//    public List<List<Integer>> threeSumCloseToZero(int[] arr) {
//        boolean found = false;
//        int n = arr.length;
//        List<List<Integer>> result = new ArrayList<ArrayList<Integer>>();
//
//        // sort array elements
//        Arrays.sort(arr);
//
//        for (int i=0; i<n-1; i++)
//        {
//            // initialize left and right
//            int l = i + 1;
//            int r = n - 1;
//            int x = arr[i];
//            while (l < r)
//            {
//                if (x + arr[l] + arr[r] == 0)
//                {
//                    // print elements if it's sum is zero
//                    System.out.print(x + " ");
//                    System.out.print(arr[l]+ " ");
//                    System.out.println(arr[r]+ " ");
//
//                    l++;
//                    r--;
//                    found = true;
//                }
//
//                // If sum of three elements is less
//                // than zero then increment in left
//                else if (x + arr[l] + arr[r] < 0)
//                    l++;
//
//                    // if sum is greater than zero than
//                    // decrement in right side
//                else
//                    r--;
//            }
//        }
//
//        if (found == false)
//            System.out.println(" No Triplet Found");
//
//
//
//    }

    public void mazeTraveller(int threshold, int[][] initThickness, long[][] rate, int rows, int cols) {
        // Write your code here
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        if (mazeTravellerHelper(threshold, initThickness, rate, rows, cols, 0, 0, 0, map))
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    /**
     * leetCode 17 prop
     */
    private static final String[] digitToCharactersMapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private void __swapInArray(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

    public List<List<Integer>> zigzagLevelOrder(Node root) {
        Stack<Node> stack = new Stack<Node>();
        Queue<Node> queue = new LinkedList<Node>();
        List<Integer> list = new ArrayList<Integer>();


        List<List<Integer>> result = new ArrayList<>();
        list.add(root.val);
        stack.push(root.left);
        stack.push(root.right);
        result.add(list);

        Boolean type = false;


        while (!stack.empty() && !queue.isEmpty()) {
            Node current;
            list = new ArrayList<Integer>();
            if (type) {
                while (!queue.isEmpty()) {
                    current = queue.poll();
                    list.add(current.val);
                    stack.push(current.left);
                    stack.push(current.right);

                    type = false;
                }

            } else {

                while (!stack.empty()) {
                    current = stack.pop();
                    list.add(current.val);
                    queue.add(current.left);
                    queue.add(current.right);
                    type = true;
                }

            }
            result.add(list);
        }
        return result;


    }

    public void printLevelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
//        queue.add(null);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            System.out.println(curr.val);
            if (curr.left != null) {
                queue.add(curr.left);
            }

            if (curr.right != null) {
                queue.add(curr.right);
            }
        }

    }

    public void rotateMatrixNinetyDegree(int[][] matrix) {
        int n = matrix.length;

        for (int x = 0; x < n / 2; x++) {
            for (int y = x; y < n - x - 1; y++) {
                int temp = matrix[x][y];

                matrix[x][y] = matrix[n - 1 - y][x];
                matrix[n - 1 - y][x] = matrix[n - 1 - x][n - 1 - y];
                matrix[n - 1 - x][n - 1 - y] = matrix[y][n - 1 - x];
                matrix[y][n - 1 - x] = temp;
            }
        }

        for (int[] row : matrix)
            System.out.println(Arrays.toString(row));
    }

    public List<Integer> printMatrixInSpiral(int[][] matrix) {

        for (int[] row : matrix)
            System.out.println(Arrays.toString(row));


        List<Integer> list = new ArrayList<>();

        if (matrix.length == 0)
            return list;

        int rowStart, rowEnd, colStart, colEnd;

        int x, y, i;
        y = matrix.length;
        x = matrix[0].length;


        rowStart = 0;
        colStart = 0;
        rowEnd = y;
        colEnd = x;


        while (colStart < colEnd && rowStart < rowEnd) {

            for (i = colStart; i < colEnd; i++) {
                list.add(matrix[rowStart][i]);
                System.out.print("right-" + matrix[rowStart][i] + "->");
            }
            rowStart++;

            for (i = rowStart; i < rowEnd; i++) {
                list.add(matrix[i][colEnd - 1]);

                System.out.print("down-" + matrix[i][colEnd - 1] + "->");
            }
            colEnd--;


            if (rowStart < rowEnd) {
                for (i = colEnd - 1; i >= colStart; i--) {
                    list.add(matrix[rowEnd - 1][i]);

                    System.out.print("left-" + matrix[rowEnd - 1][i] + "->");

                }
                rowEnd--;

            }

            if (colStart < colEnd) {

                for (i = rowEnd - 1; i >= rowStart; i--) {
                    list.add(matrix[i][colStart]);

                    System.out.print("UP-" + matrix[i][colStart] + "->");
                }
                colStart++;
            }
        }
        return list;
    }

    public int[] findFirstAndLastOccurrenceInSortedArray(int[] nums, int target) {

        int targetIndex = binarySearch(nums, target);

        int[] result = new int[2];

        Arrays.fill(result, -1);
        if (targetIndex == -1) {
            return result;
        }

        int firstIndex = targetIndex;
        int lastIndex = targetIndex;

        while (firstIndex >= 0) {
            if (nums[firstIndex] == nums[firstIndex - 1])
                firstIndex--;
            else
                break;
        }

        while (lastIndex < nums.length) {
            if (nums[lastIndex] == nums[lastIndex + 1])
                lastIndex++;
            else
                break;
        }

        result[0] = firstIndex;
        result[1] = lastIndex;

        return result;
    }

    public boolean canJump(int[] nums) {
        int max = nums[0];

        if (nums.length <= 1) {
            return true;
        }

        for (int i = 0; i < nums.length; i++) {
            if (max <= i && nums[i] == 0) {
                return false;
            }

            if (i + nums[i] > max) {
                max = i + nums[i];
            }

            if (max >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }

    public int[][] mergeIntervals(int[][] intervals) {
        int[] prev, curr, item;
        int p = 0;

        item = new int[2];
//        int[][] result;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> result = new ArrayList<int[]>();
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            prev = result.get(p);
            curr = intervals[i];

            if (curr[0] <= prev[1]) {
                item = prev;
                if (curr[1] > prev[1]) {
                    item[1] = curr[1];
                }
                if (curr[0] < prev[0]) {
                    item[0] = curr[0];
                }
                result.set(p, item);
            } else {
                result.add(curr);
                p++;
            }
        }

        int[][] rr = new int[result.size()][2];
        result.toArray(rr);
        return rr;
    }

    public void setZeroes(int[][] matrix) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (Integer r : rows) {
            Arrays.fill(matrix[r], 0);
        }

        for (Integer c : cols) {
            for (int k = 0; k < matrix.length; k++) {
                matrix[k][c] = 0;
            }

        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        HashMap<Integer, Integer> preOrderMap = new HashMap<>();

        for (int i = 0; i < preorder.length; i++) {
            preOrderMap.put(preorder[i], i);
        }


        return buildTreeHelper(preOrderMap, inorder, 0, inorder.length - 1);

    }

    private TreeNode buildTreeHelper(HashMap<Integer, Integer> preorder, int[] inorder, int l, int r) {
        System.out.println(l + "---" + r);

        if (l > r) {
            return null;
        }


        int minIndex = Integer.MAX_VALUE;
        int rootVal = 0;
        int rootIndex = -1;

        for (int i = l; i <= r; i++) {

            if (preorder.containsKey(inorder[i]) && preorder.get(inorder[i]) < minIndex) {
                minIndex = preorder.get(inorder[i]);
                rootVal = inorder[i];
                rootIndex = i;
            }
        }

        if (minIndex >= inorder.length)
            return null;

        TreeNode root = new TreeNode(rootVal);
        System.out.println(root.val);
        System.out.println("left");
        root.left = buildTreeHelper(preorder, inorder, l, rootIndex - 1);
        System.out.println("right");
        root.right = buildTreeHelper(preorder, inorder, rootIndex + 1, r);
        return root;
    }

    public int maxSumSubarray(int[] nums) {

        int size = nums.length;

        int maxSum = 0;

        int currSum = 0;

        for (int i = 0; i < size; i++) {
            currSum = currSum + nums[i];

            if (currSum < 0) {
                currSum = 0;
            }

            if (maxSum < currSum) {
                maxSum = currSum;
            }
        }
        return maxSum;
    }

    public int maxProductSubarray(int[] nums) {
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        int result;
        result = min[0] = max[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                max[i] = Math.max(max[i - 1], max[i - 1] * nums[i]);
                min[i] = Math.max(min[i - 1], min[i - 1] * nums[i]);
            } else {
                max[i] = Math.max(min[i - 1], min[i - 1] * nums[i]);
                min[i] = Math.max(max[i - 1], max[i - 1] * nums[i]);
            }

            result = Math.max(result, max[i]);
        }

        return result;
    }


    public int findPeakElement(int[] nums) {


        if (nums.length == 1) {
            return 0;
        }

        if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                return 0;
            } else {
                return 1;
            }
        }

        if (nums.length < 3) {
            return -1;
        }

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }

        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        return -1;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;

        int i, j, k, prev, curr;

        prev = curr = i = j = k = 0;

        while (j < nums1.length && k < nums2.length) {
            prev = curr;
            if (nums1[j] < nums2[k]) {
                curr = nums1[j];
//                i++;
                j++;
            } else {
                curr = nums2[k];
//                i++;
                k++;
            }

            if (i == (size / 2)) {
                if (size % 2 == 0) {
                    return (double) (curr + prev) / 2;
                } else {
                    return curr;
                }
            }
            i++;
        }

        while (j < nums1.length) {
            prev = curr;
            curr = nums1[j];
//            i++;
            j++;

            if (i == (size / 2)) {
                if (size % 2 == 0) {
                    return (double) (curr + prev) / 2;
                } else {
                    return curr;
                }
            }
            i++;
        }

        while (k < nums2.length) {
            prev = curr;
            curr = nums2[k];
//            i++;
            k++;

            if (i == (size / 2)) {
                if (size % 2 == 0) {
                    return (double) (curr + prev) / 2;
                } else {
                    return curr;
                }
            }
            i++;
        }
        return -1;
    }

    public boolean isHappy(int n) {

        List<Integer> check = new ArrayList<>();

        check.add(n);

        int temp, product;
        // product =

        while (n != 1) {
            product = 0;
            while (n > 0) {
                int i = n % 10;
                product += i * i;
                n /= 10;
            }

            if (check.contains(product)) {
                return false;
            } else {
                check.add(product);
            }

            n = product;
        }

        return true;
    }

    private Boolean mazeTravellerHelper(int t, int[][] initThickness, long[][] rate, int rows, int cols, int currRow, int currCol, int steps, HashMap<String, Boolean> cachedResult) {
        if (currRow >= rows || currCol >= cols) {
            return false;
        }

        if (currRow == rows - 1 && currCol == cols - 1) {
            return true;
        }

        String key = currRow + "," + currCol;

        if (cachedResult.containsKey(key)) {
            System.out.println("cached result--" + key);
            return cachedResult.get(key);
        }


        long currentThickness = initThickness[currRow][currCol] + (rate[currRow][currCol] * steps);

        if (currentThickness >= (long) t) {
            return false;
        }


        Boolean down = mazeTravellerHelper(t, initThickness, rate, rows, cols, currRow + 1, currCol, steps + 1, cachedResult);

        cachedResult.put((currRow + 1) + "," + currCol, down);
        if (down) {
            return true;
        }
        Boolean right = mazeTravellerHelper(t, initThickness, rate, rows, cols, currRow, currCol + 1, steps + 1, cachedResult);


        cachedResult.put(currRow + "," + (currCol + 1), right);
        return right;

    }

    public int firstUniqChar(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int count = map.get(s.charAt(i));
                map.put(s.charAt(i), ++count);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {

            if (map.get(s.charAt(i)) == 1)
                return i;
        }

        return -1;
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String value : strs) {
            char[] str = value.toCharArray();
            Arrays.sort(str);
            String s = Arrays.toString(str);

            if (map.containsKey(s)) {
                List<String> list = map.get(s);
                list.add(value);
                map.put(s, list);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(value);
                map.put(s, newList);
            }

        }
        return new ArrayList<>(map.values());
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int count;
        for (int item : nums) {
            if (map.containsKey(item)) {
                count = map.get(item);
                count++;
                if (count == k) {
                    result.add(item);
                }
            } else {
                count = 1;
            }
            map.put(item, count);
        }
        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode current = root;

        while (current != null && !stack.empty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }

    /**
     * leetCode 3
     *
     * @param s String
     * @return int
     */
    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 1 || s.length() == 0) {
            return s.length();
        }
        HashMap<Character, Integer> map = new HashMap<>();

        int j = 0;
        int maxLength = 0;
        int index;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
                maxLength = Math.max(maxLength, i - j + 1);
            } else {
                index = map.get(s.charAt(i));
                j = index >= j ? index + 1 : j;
                map.put(s.charAt(i), i);
                maxLength = Math.max(maxLength, i - j + 1);
            }
        }
        return maxLength;
    }

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();


        if (t.length() == s.length() && s.length() == 1)
            return t.equals(s) ? s : "";


        String result;

        int iterator = 0;

        for (iterator = 0; iterator < t.length(); iterator++) {
            map.put(t.charAt(iterator), 0);
        }

        int l, r = 0;
        l = 0;

        boolean flag = false;
        while (!flag && r < s.length()) {
            if (map.containsKey(s.charAt(r))) {
                map.put(s.charAt(r), map.get(s.charAt(r)) + 1);
                flag = true;

                for (iterator = 0; iterator < t.length(); iterator++) {
                    if (map.get(t.charAt(iterator)) == 0) {
                        flag = false;
                    }
                }

            }
            if (!flag) {
                r++;
            }
        }

        if (!flag)
            return "";


        int min = Integer.MAX_VALUE;
        r++;
        System.out.println(s.substring(l, r) + "---dssdf");

        result = s.substring(l, r + 1);
        while (r < s.length() && l < r) {
            if (flag) {
                if (map.containsKey(s.charAt(l))) {
                    map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                    flag = true;
                    for (iterator = 0; iterator < t.length(); iterator++) {
                        if (map.get(t.charAt(iterator)) == 0) {
                            flag = false;
                        }
                    }
                }

                if (flag) {
                    System.out.println("Left");


                    if (min > (r - 1) - l) {
                        min = (r - 1) - l;
                        result = s.substring(l + 1, (r));
                        System.out.println(s.substring(l + 1, (r)));
                    }
                    System.out.println(l + "-" + (r - 1) + "-" + min);
                }
                l++;
            } else {

                if (map.containsKey(s.charAt(r))) {
                    map.put(s.charAt(r), map.get(s.charAt(r)) + 1);
                    flag = true;
                    for (iterator = 0; iterator < t.length(); iterator++) {
                        if (map.get(t.charAt(iterator)) == 0) {
                            flag = false;
                        }
                    }
                }
                if (flag) {
                    System.out.println("Right");

                    if (min > r - (l - 1)) {
                        min = r - (l - 1);
                        result = s.substring((l - 1), r);
                        System.out.println(s.substring((l - 1), r));
                    }
                    System.out.println((l - 1) + "-" + r + "-" + min);
                }
                r++;

            }
        }


        while (flag) {
            if (map.containsKey(s.charAt(l))) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                flag = true;
                for (iterator = 0; iterator < t.length(); iterator++) {
                    if (map.get(t.charAt(iterator)) == 0) {
                        flag = false;
                    }
                }
            }

            if (flag) {
                System.out.println("Final");

//                min = Math.min(min, (r - 1) - l);
                if (min > (r - 1) - l) {
                    min = (r - 1) - l;
                    result = s.substring(l + 1, r);
                    System.out.println(s.substring(l + 1, r));
                }
                System.out.println(l + "---" + (r - 1) + "-" + min);
            }
            l++;
        }


        System.out.println(min);
        return result;
    }

    /**
     * LeetCode 11
     *
     * @param heights //int[]
     * @return int
     */
    public int largestRectangleArea(int[] heights) {

        int left = 0, right = heights.length - 1;
        if (right == 0) {
            return 0;
        }

        int maxArea = 0, currentArea, minHeight;

        while (left < right) {
            minHeight = Math.min(heights[left], heights[right]);
            currentArea = minHeight * (right - left);
            maxArea = Math.max(currentArea, maxArea);

            while (left < right && heights[left] <= minHeight) left++;

            while (left < right && heights[right] <= minHeight) right--;
        }
        return maxArea;
    }

    public int divide(int dividend, int divisor) {

        boolean negative = dividend < 0 ^ divisor < 0;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int quotient = 0;

        if (divisor == 1) {
            if (dividend == Integer.MAX_VALUE || dividend == Integer.MIN_VALUE) {
                if (negative) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            } else {
                return negative ? dividend * -1 : dividend;
            }
        }


        while (dividend >= divisor) {
            dividend = dividend - divisor;

            if (dividend == Integer.MAX_VALUE || dividend == Integer.MIN_VALUE) {
                if (negative) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }

            quotient++;
        }
        if (negative)
            quotient = quotient * -1;

//        System.out.println(quotient);
        return quotient;
    }

    public int trailingZeroes(int n) {
        long factorial = 1;

        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }

        int mod = 0;
        int divisor = 10;
        int zeros = 0;
        System.out.println(factorial);
        while (mod == 0) {
            System.out.println(divisor);
            mod = (int) (factorial % divisor);

            if (mod == 0) {
                zeros++;
            } else {
                return zeros;
            }

            divisor *= 10;
        }
        return zeros;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return _sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode _sortedArrayToBST(int[] nums, int left, int right) {

        if (left > right)
            return null;

        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = _sortedArrayToBST(nums, left, mid - 1);
        root.right = _sortedArrayToBST(nums, mid + 1, right);
        return root;
    }

    public int maxDepth(TreeNode root) {
        return this._maxDepthHelper(root, 0);
    }

    /**
     * leetCode 8
     *
     * @param str
     * @return
     */
    public int myAtoi(String str) {

        int start;
        long result;

        start = 0;
        result = 0;
        str = str.trim();
//        String.tri
        while (start < str.length() && str.charAt(start) == ' ') start++;

        if (start >= str.length()) return 0;

        boolean negative = false;

        if (str.charAt(start) == '-') {
            negative = true;
            start++;
        } else if (str.charAt(start) == '+') {
//            negative = false;
            start++;
        } else if (!Character.isDigit(str.charAt(start))) {
            return 0;
        }

        while (start < str.length()) {
            if (!Character.isDigit(str.charAt(start)))
                break;
            if (negative) {
                result = result * 10 - (str.charAt(start) - '0');
                if (result <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
            } else {
                result = result * 10 + (str.charAt(start) - '0');
                if (result >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
            }
            start++;
        }
        return (int) result;
    }

    private int _maxDepthHelper(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        int leftDepth = this._maxDepthHelper(root.left, depth);
        int rightDepth = this._maxDepthHelper(root.right, depth);
        return Math.max(leftDepth, rightDepth) + 1;
    }

//    public String entityParser(String text) {
//        String[] entities = {};
//        String[] character = {};
//    }


    private int binarySearch(int[] input, int target) {
        int l = 0;
        int r = input.length - 1;
        int mid;

        while (l <= r) {
            mid = (l + r) / 2;

            if (target == input[mid]) {
                return mid;
            }

            if (input[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    /**
     * leetCode 2
     *
     * @param l1 ListNode list
     * @param l2 ListNode list
     * @return ListNode
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        int sum;
        ListNode result = null;
        ListNode result2 = null;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            if (result == null) {
                result = new ListNode(sum);
                result2 = result;
            } else {
                result.next = new ListNode(sum);
                result = result.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            sum = l1.val + carry;
            sum = sum % 10;
            carry = sum / 10;

            if (result == null) {
                result = new ListNode(sum);
                result2 = result;
            } else {
                result.next = new ListNode(sum);
                result = result.next;
            }
            l1 = l1.next;
        }

        while (l2 != null) {
            sum = l2.val + carry;
            sum = sum % 10;
            carry = sum / 10;

            if (result == null) {
                result = new ListNode(sum);
                result2 = result;
            } else {
                result.next = new ListNode(sum);
                result = result.next;
            }
            l2 = l2.next;
        }

        if (carry > 0) {
            result.next = new ListNode(carry);
        }
        return result2;
    }

    /**
     * leetCode 17
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {

        char[] tempCombination = new char[digits.length()];
        List<String> combinations = new ArrayList<>();

        combinationsMakerHelper(digits, 0, tempCombination, combinations);
        return combinations;
    }

    /**
     * leetCode 17 helper
     *
     * @param number
     * @param digit
     * @param tempCombination
     * @param combinations
     */
    private void combinationsMakerHelper(String number, int digit, char[] tempCombination, List<String> combinations) {
        if (digit == number.length()) {
            combinations.add(new String(tempCombination));
        } else {
            for (int i = 0; i < digitToCharactersMapping[number.charAt(digit) - '0'].length(); i++) {
                char c = digitToCharactersMapping[number.charAt(digit) - '0'].charAt(i);
                tempCombination[digit] = c;
                combinationsMakerHelper(number, digit + 1, tempCombination, combinations);
            }
        }
    }

    /**
     * leetCode 5
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int N = s.length();
        if (N == 0)
            return "";
        String str = _getModifiedString(s, N);
        int len = (2 * N) + 1;
        int[] P = new int[len];
        int c = 0; //stores the center of the longest palindromic substring until now
        int r = 0; //stores the right boundary of the longest palindromic substring until now
        int maxLen = 0;
        int left = 0, right = 0;
        String maxString = "";
        for (int i = 0; i < len; i++) {
            //get mirror index of i
            int mirror = (2 * c) - i;

            //see if the mirror of i is expanding beyond the left boundary of current longest palindrome at center c
            //if it is, then take r - i as P[i]
            //else take P[mirror] as P[i]
            if (i < r) {
                P[i] = Math.min(r - i, P[mirror]);
            }

            //expand at i
            int a = i + (1 + P[i]);
            int b = i - (1 + P[i]);
            while (a < len && b >= 0 && str.charAt(a) == str.charAt(b)) {
                P[i]++;
                a++;
                b--;
            }

            //check if the expanded palindrome at i is expanding beyond the right boundary of current longest palindrome at center c
            //if it is, the new center is i
            if (i + P[i] > r) {
                c = i;
                r = i + P[i];

                if (P[i] > maxLen) { //update maxlen
                    left = c - (r - c);
                    right = r;
                    maxLen = P[i];
                }
            }
        }
        return str.substring(left, right + 1).replaceAll("#", "");
    }

    /**
     * leetCode 5 helper
     *
     * @param s
     * @param N
     * @return
     */
    private String _getModifiedString(String s, int N) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("#");
            sb.append(s.charAt(i));
        }
        sb.append("#");
        return sb.toString();
    }

    /**
     * Convert int[] to ListNode list
     *
     * @param listValues int[]
     * @return ListNode
     */
    public ListNode makeArrayToLinkedList(int[] listValues) {
        if (listValues.length == 0) {
            return null;
        }

        ListNode newList = new ListNode(listValues[0]);
        ListNode current = newList;

        for (int i = 1; i < listValues.length; i++) {
            current.next = new ListNode(listValues[i]);
            current = current.next;
        }
        return newList;
    }

    /**
     * To print ListNode
     *
     * @param head ListNode
     */
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
            if (head != null)
                System.out.print(" -> ");
        }
        System.out.println();
    }
}