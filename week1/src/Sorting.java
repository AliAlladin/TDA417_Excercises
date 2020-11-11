import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        new Sorting().program();
    }

    private void program() {
        /*
        int[] arr = {1,2,3,4,5,6,0,0,0,0,0};
        System.out.println(Arrays.toString(arr));
        insert(arr, 4);
        System.out.println(Arrays.toString(arr));
         */

        int[] arr2 = {1,2,2,3,5,7,9};
        int[] arr3 = {2,4,6,8,10,22,70};
        int[] mergedArray = merge(arr2, arr3);
        System.out.println(Arrays.toString(mergedArray));

    }


    void insert(int[] arr, int x){
        int index = searchIndex(arr, x);

        for (int i = arr.length-2; i >= index; i--){
            arr[i+1] = arr[i];
        }

        arr[index] = x;
    }

    private int searchIndex(int[] arr, int value) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo != hi) {
            int mid = (lo + hi) / 2;
            if (value < arr[mid]) {
                hi = mid - 1;
            } else if (value >= arr[mid]) {
                lo = mid + 1;
            }
        }

        return lo;
    }

        // postcondition: a[lo .. hi] is sorted

    int[] merge(int[] arr1, int[] arr2){
        int[] mergedArray = new int[arr1.length + arr2.length];
        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = 0; i < mergedArray.length; i++){
            if (leftIndex < arr1.length && rightIndex < arr2.length){
                if (arr1[leftIndex] <= arr2[rightIndex]){
                    mergedArray[i] = arr1[leftIndex];
                    leftIndex++;
                }
                else if (arr1[leftIndex] > arr2[rightIndex]){
                    mergedArray[i] = arr2[rightIndex];
                    rightIndex++;
                }
            }
            else if (leftIndex >= arr1.length){
                mergedArray[i] = arr2[rightIndex];
                rightIndex++;
            }
            else if (rightIndex >= arr2.length){
                mergedArray[i] = arr1[leftIndex];
                leftIndex++;
            }
        }

        return mergedArray;
    }

}
