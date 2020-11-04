public class BinarySearch {
    public static void main(String[] args) {
        new BinarySearch().program();
    }

    private void program() {
        int[] ascending = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] descending = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        System.out.println(binarySearchAscending(ascending, 6));
        System.out.println(binarySearchDescending(descending, 6));
    }


    private boolean binarySearchAscending(int[] arr, int value){
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi){
            int mid = (lo + hi) / 2;
            if (value < arr[mid]){
                hi = mid - 1;
            }
            else if (value > arr[mid]){
                lo = mid + 1;
            }
            else {
                return true;
            }
        }

        return false;
    }

    private boolean binarySearchDescending(int[] arr, int value){
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi){
            int mid = (lo + hi) / 2;
            if (value > arr[mid]){
                hi = mid - 1;
            }
            else if (value < arr[mid]){
                lo = mid + 1;
            }
            else {
                return true;
            }
        }

        return false;
    }
}
