import java.util.Arrays;

public class q6 {
    public static void main(String[] args) {
        int[] array = {3, 1, 4, 1, 5, 9, 2, 6};
        largestNumbers(array, 4);
    }

    private static void largestNumbers(int[] array, int k) {
        int[] largestNumbers = new int[k];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > largestNumbers[0]){
                largestNumbers[0] = array[i];
                Arrays.sort(largestNumbers);
            }
        }
        System.out.println(Arrays.toString(largestNumbers));
    }
}
