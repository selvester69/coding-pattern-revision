## Selection sort- ascending order
    private static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }

        }
    }
## Insertion Sort- ascending order
    private static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            int temp = nums[i];
            while (j >= 0 && temp<nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j+1] = temp; //can be used at line 25 also 
        }
    }
## Bubble sort - ascending order
    private static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
## quick Sort
    public static int pivot(int[] arr, int pivotIndex, int end) {
        int swapindex = pivotIndex;
        for (int i = pivotIndex + 1; i <= end; i++) {
            if (arr[i] < arr[pivotIndex]) {
                swapindex++;
                swap(arr, swapindex, i);
            }
        }
        swap(arr,pivotIndex, swapindex );

        return swapindex;
    }
    public static void quickSortHelper(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = pivot(arr, left, right);
            quickSortHelper(arr, left, pivotIndex - 1);
            quickSortHelper(arr, pivotIndex + 1, right);
        }
        return;
    }

    public static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }
## Merge Sort
    public static int[] merge(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] combined = new int[n1 + n2];
        int index1 = 0, index2 = 0, index = 0;
        while (index1 < n1 && index2 < n2) {
            if (nums1[index1] < nums2[index2]) {
                combined[index++] = nums1[index1++];
            }
            else {
                combined[index++] = nums2[index2++];
            }
        }
        while (index1 < n1) {
            combined[index++] = nums1[index1++];
        }
        while (index2 < n2) {
            combined[index++] = nums2[index2++];
        }
        return combined;
    }
    
    public static int[] mergeSort(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }
        int mid = nums.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(nums, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(nums, mid, nums.length));
        return merge(left, right);
    }
