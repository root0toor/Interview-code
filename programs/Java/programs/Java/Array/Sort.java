package programs.Java.Array;
import java.util.Arrays;

public class Sort {
    public static void main(int[] args){
        // Arrays.sort(\)
    }
    public static int[] mergeSort(int[] input) {
        int[] deepCopiedArray = Arrays.copyOf(input, input.length);
        Arrays.sort(deepCopiedArray);
        System.out.println("        ====        ^^^^^^^^^^^^     ====        " + Arrays.toString(deepCopiedArray));
        return input;
    }
    public static void main(String[] args) {
        int[] arr = { 34, 23, 89, 120, 34, 20, 1, 1000 };
        System.out.println("        ====        Input Array     ====        " + Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("        ====        Sorted Array     ====        " + Arrays.toString(arr));
    }
}