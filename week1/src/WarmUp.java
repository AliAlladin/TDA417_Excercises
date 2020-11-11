public class WarmUp {
    public static void main(String[] args) {
        new WarmUp().program();
    }

    private void program() {
        System.out.println(isPalindrome("madamimadam"));
        System.out.println(isPalindrome("Madam, I'm Adam!"));

        DynamicArray<Character> dynamicArray = new DynamicArray<Character>();

        dynamicArray.add('A');
        dynamicArray.add('B');
        dynamicArray.add('C');

        System.out.println(dynamicArray.get(0).equals('A'));
        System.out.println(dynamicArray.get(1).equals('B'));
        System.out.println(!dynamicArray.get(2).equals('B'));

        dynamicArray.set(2, 'B');
        System.out.println(dynamicArray.get(2).equals('B'));

        try {
            System.out.println(dynamicArray.get(4));
        } catch (Exception exception) {
            System.out.println(exception.toString());
        }

        try {
            dynamicArray.set(-1, 'D');
        } catch (Exception exception) {
            System.out.println(exception.toString());
        }
    }

    boolean isPalindrome(String original) {
        String originalCopy = "";
        String reversed = "";

        for (int i = 0; i < original.length(); i++) {
            if (Character.isAlphabetic(original.charAt(i))) {
                originalCopy += Character.toUpperCase(original.charAt(i));
            }
        }

        for (int i = originalCopy.length() - 1; i >= 0; i--) {
            reversed += Character.toUpperCase(originalCopy.charAt(i));
        }

        if (originalCopy.equals(reversed)) {
            return true;
        } else {
            return false;
        }
    }


    public static class DynamicArray<A> {
        private A[] array = (A[]) new Object[1];
        private int used = 0;

        void add(A value) {
            if (array.length == used) {
                A[] newArray = (A[]) new Object[array.length * 2];
                for (int i = 0; i < array.length; i++) {
                    newArray[i] = array[i];
                }
                array = newArray;
            }

            array[used] = value;
            used++;
        }

        A get(int index) {
            if (index < 0 || index >= array.length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            return array[index];
        }

        void set(int index, A value) {
            if (index < 0 || index >= array.length) {
                throw new ArrayIndexOutOfBoundsException();
            }

            array[index] = value;
        }

    }
}

