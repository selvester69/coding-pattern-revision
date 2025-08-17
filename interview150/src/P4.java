import java.util.Arrays;

public class P4 {

    public static int removeDuplicates(int[] arr) {
        if (arr.length < 2)
            return arr.length;
        int i = 2;
        for (int j = 2 ; j < arr.length; j++) {
            if (arr[j] != arr[i - 2]) {
                arr[i++] = arr[j];
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 1, 1, 2, 2, 3 };
        int res = removeDuplicates(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(res);
    }

}
