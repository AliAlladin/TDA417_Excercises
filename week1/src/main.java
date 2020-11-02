public class main {
    public static void main(String[] args) {
        new main().program();
    }

    private void program() {
        System.out.println(isPalindrome("madamimadam"));
        System.out.println(isPalindrome("Madam, I'm Adam!"));
    }

    boolean isPalindrome(String original){
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

        if (originalCopy.equals(reversed)){
            return true;
        }
        else {
            return false;
        }
    }
}
